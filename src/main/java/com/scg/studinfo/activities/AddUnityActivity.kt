package com.scg.studinfo.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.ktx.getValue
import com.scg.studinfo.R
import com.scg.studinfo.models.Unity
import com.scg.studinfo.utils.CameraHelper
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_add_unity.*

class AddUnityActivity : AppCompatActivity() {

    private lateinit var mFirebase: FireBaseHelper
    private lateinit var mCamera: CameraHelper
    private lateinit var mUri: Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_unity)

        mFirebase = FireBaseHelper(this)
        mCamera = CameraHelper(this)

        icon_exit.setOnClickListener { finish() }
        unity_image.setOnClickListener { mCamera.takePicture() }
        icon_done.setOnClickListener { addUnity() }


        persons_btn.setOnClickListener {
            startActivity(Intent(this,
            AddPersonsAtUnityActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == mCamera.REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                mUri = data!!.data!!
                GlideApp.with(this).load(mUri).centerCrop().into(unity_image)
            } else {
                finish()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        persons_btn.text = "Участники: " + usersAtUnity.size
    }
    fun addUnity() {
        icon_done.isEnabled = false
        val uid = mFirebase.chUid()
        mFirebase.uploadPostPhoto("unity/images/${mUri.lastPathSegment}", mUri) {
            mFirebase.getUrl("unity/images/${mUri.lastPathSegment}") {
                val url = it.toString()
                mFirebase.addUnity(setUnity(url)) {
                    uploadUnityToUser {
                        finish()
                        showToast("Объединение было создано")
                    }
                }
            }
        }
    }

    fun uploadUnityToUser(onSuccess: () -> Unit) {
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

    fun setUnity(url: String): Unity {
        return Unity(
            text_name.text.toString(),
            text_fullname.text.toString(),
            text_text.text.toString(),
            usersAtUnity,
            text_vk.text.toString(),
            url
        )
    }
}

