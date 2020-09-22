package com.scg.studinfo.activities

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.database.ktx.getValue
import com.scg.studinfo.R
import com.scg.studinfo.models.Unity
import com.scg.studinfo.utils.CameraHelper
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_add_unity.*

class AddUnityActivity : AppCompatActivity() {

    private lateinit var mFirebase: FireBaseHelper
    private lateinit var mCamera: CameraHelper
    private lateinit var mUriImg: Uri
    private lateinit var mUriLogo: Uri
    private val CODE_LOGO = 12
    private val CODE_IMG = 13


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_unity)

        mFirebase = FireBaseHelper(this)
        mCamera = CameraHelper(this)

        icon_exit.setOnClickListener { finish() }
        unity_image.setOnClickListener { mCamera.takePicture(CODE_LOGO) }
        icon_done.setOnClickListener { addUnity() }

        bg_img_unity.setOnClickListener { mCamera.takePicture(CODE_IMG) }

        persons_btn.setOnClickListener {
            startActivity(Intent(this,
                AddPersonsAtUnityActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CODE_LOGO) {
            if (resultCode == RESULT_OK) {
                mUriLogo = data!!.data!!
                GlideApp.with(this).load(mUriLogo).centerCrop().into(unity_image)
            } else {
                finish()
            }
        }
        if (requestCode == CODE_IMG) {
            if (resultCode == RESULT_OK) {
                mUriImg = data!!.data!!
                GlideApp.with(this).load(mUriImg).centerCrop().into(bg_img_unity)
            } else {
                finish()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        persons_btn.text = "Участники: ${usersAtUnity.size}"
    }
    private fun addUnity() {
        icon_done.isEnabled = false
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Сохраняем...")
        progressDialog.setCancelable(false)
        progressDialog.show()
        Handler().postDelayed({progressDialog.dismiss()}, 10000)
        mFirebase.uploadPostPhoto("unity/images/${mUriLogo.lastPathSegment}", mUriLogo) {
            mFirebase.uploadPostPhoto("unity/images/${mUriImg.lastPathSegment}", mUriImg) {
                mFirebase.getUrl("unity/images/${mUriLogo.lastPathSegment}") {logoUrl ->
                    mFirebase.getUrl("unity/images/${mUriImg.lastPathSegment}") {imgUrl ->
                        val urlimg = imgUrl.toString()
                        val urlLogo = logoUrl.toString()
                        mFirebase.addUnity(setUnity(urlLogo, urlimg)) {
                            uploadUnityToUser {
                                progressDialog.dismiss()
                                finish()
                                showToast("Объединение было создано")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun uploadUnityToUser(onSuccess: () -> Unit) {
        mFirebase.uploadUnity {
            var uidU = ""
            for (item in it) {
                if (item.shortname == text_name.text.toString()) {
                    uidU = item.uid!!
                }
            }
            for(item in usersAtUnity) {
                mFirebase.database.child("users/$item/unity")
                    .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                        var unityList = mutableListOf<String>()
                        val cache = it.getValue<MutableList<String>>()
                        if(cache != null) {
                            unityList = cache
                        }
                        unityList.add(uidU)
                        mFirebase.database.child("users/$item/unity").setValue(unityList)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {

                                } else {
                                    showToast(it.exception!!.message!!)
                                }
                            }
                    })
            }
            onSuccess()
        }
    }

    private fun setUnity(urlLogo: String, urlImg: String): Unity {
        return Unity(
            shortname = text_name.text.toString(),
            name = text_fullname.text.toString(),
            text = text_text.text.toString(),
            users = usersAtUnity,
            vk = text_vk.text.toString(),
            img = urlLogo,
            imgmain = urlImg,
            sortword = text_sort.text.toString()
        )
    }
}