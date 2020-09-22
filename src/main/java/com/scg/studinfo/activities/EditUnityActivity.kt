package com.scg.studinfo.activities

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.ktx.getValue
import com.scg.studinfo.R
import com.scg.studinfo.models.Unity
import com.scg.studinfo.utils.CameraHelper
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_edit_unity.*

class EditUnityActivity : AppCompatActivity() {

    private lateinit var mFirebase: FireBaseHelper
    private lateinit var mCamera: CameraHelper
    private lateinit var mUri: Uri
    private lateinit var mUriImg: Uri
    private var newImg = false
    private var newImgBg = false
    private val CODE_LOGO = 12
    private val CODE_IMG = 13

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_unity)

        mFirebase = FireBaseHelper(this)
        mCamera = CameraHelper(this)

        mFirebase.uploadUnity {
            val unity = it.findLast { it.uid == selUnity!!.uid }
            selUnity = unity
            text_name.setText(unity!!.shortname)
            text_fullname.setText(unity.name)
            text_text.setText(unity.text)
            text_vk.setText(unity.vk)
            text_sort.setText(unity.sortword)
            unity_image.loadCircleImage(unity.img)
            bg_img_unity.loadCircleImage(unity.imgmain)
            if(unity.users != null)
            {
                usersAtUnity = unity.users as MutableList<String>
                persons_btn.text = "Участники: ${usersAtUnity.size}"
            }
            else persons_btn.text = "Участники: 0"
        }

        icon_exit.setOnClickListener { finish() }

        unity_image.setOnClickListener {
            mCamera.takePicture(CODE_LOGO)
        }
        bg_img_unity.setOnClickListener {
            mCamera.takePicture(CODE_IMG)
        }

        icon_done.setOnClickListener { editUnity() }


        persons_btn.setOnClickListener {
            startActivity(Intent(this,
                AddPersonsAtUnityActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CODE_LOGO) {
            if (resultCode == RESULT_OK) {
                newImg = true
                mUri = data!!.data!!
                GlideApp.with(this).load(mUri).centerCrop().into(unity_image)
            } else {
                finish()
            }
        } else if (requestCode == CODE_IMG) {
            if (resultCode == RESULT_OK) {
                newImgBg = true
                mUriImg = data!!.data!!
                GlideApp.with(this).load(mUriImg).centerCrop().into(bg_img_unity)
            } else {
                finish()
            }
        }
    }

    fun updateInfo(unity: Unity): MutableMap<String, Any?> {
        val updatesMap = mutableMapOf<String, Any?>()
        if(unity.name != selUnity!!.name) updatesMap["name"] = unity.name
        if (unity.shortname != selUnity!!.shortname) updatesMap["shortname"] = unity.shortname
        if(unity.text != selUnity!!.text) updatesMap["text"] = unity.text
        if(unity.vk != selUnity!!.vk) updatesMap["vk"] = unity.vk
        updatesMap["users"] = usersAtUnity
        if(newImg) updatesMap["img"] = unity.img
        if(newImgBg) updatesMap["imgmain"] = unity.imgmain
        return updatesMap
    }

    override fun onResume() {
        super.onResume()
        persons_btn.text = "Участники: " + usersAtUnity.size
    }
    fun editUnity() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Выкладываем...")
        progressDialog.setCancelable(false)
        progressDialog.show()
        if(newImg)
            mFirebase.uploadPostPhoto("unity/images/${mUri.lastPathSegment}", mUri) {
                if(newImgBg) {
                    mFirebase.uploadPostPhoto("unity/images/${mUriImg.lastPathSegment}", mUriImg) {
                        mFirebase.getUrl("unity/images/${mUri.lastPathSegment}") { logoUrl ->
                            mFirebase.getUrl("unity/images/${mUriImg.lastPathSegment}") { imgUrl ->
                                progressDialog.dismiss()
                                val urlLogo = logoUrl.toString()
                                val urlBg = imgUrl.toString()
                                mFirebase.updateUnity(
                                    selUnity!!.uid!!,
                                    updateInfo(setUnity(urlLogo, urlBg))
                                ) {
                                    uploadUnityToUser {
                                        mFirebase.uploadUnity {
                                            selUnity = it.findLast { it.uid == selUnity!!.uid }
                                            finish()
                                            showToast("Объединение было изменено")
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    mFirebase.getUrl("unity/images/${mUri.lastPathSegment}") { logoUrl ->
                        val urlLogo = logoUrl.toString()
                        progressDialog.dismiss()
                        mFirebase.updateUnity(
                            selUnity!!.uid!!,
                            updateInfo(setUnity(urlLogo, null))
                        ) {
                            uploadUnityToUser {
                                mFirebase.uploadUnity {
                                    selUnity = it.findLast { it.uid == selUnity!!.uid }
                                    finish()
                                    showToast("Объединение было изменено")
                                }
                            }
                        }

                    }
                }
            }
        else if(newImgBg) {
            mFirebase.uploadPostPhoto("unity/images/${mUriImg.lastPathSegment}", mUriImg) {
                mFirebase.getUrl("unity/images/${mUriImg.lastPathSegment}") { imgUrl ->
                    progressDialog.dismiss()
                    val urlBg = imgUrl.toString()
                    mFirebase.updateUnity(
                        selUnity!!.uid!!,
                        updateInfo(setUnity(null, urlBg))
                    ) {
                        uploadUnityToUser {
                            mFirebase.uploadUnity {
                                selUnity = it.findLast { it.uid == selUnity!!.uid }
                                finish()
                                showToast("Объединение было изменено")
                            }
                        }
                    }
                }
            }
        } else {
            mFirebase.updateUnity(selUnity!!.uid!!, updateInfo(setUnity(null, null))) {
                progressDialog.dismiss()
                uploadUnityToUser {
                    mFirebase.uploadUnity {
                        selUnity = it.findLast { it.uid == selUnity!!.uid }
                        finish()
                        showToast("Объединение было изменено")
                    }

                }
            }
        }
    }

    fun ifDeletedUsers(): MutableList<String> {
        val listtest = mutableListOf<String>()
        if(selUnity?.users != null) listtest.addAll(selUnity!!.users!!)
        for (itn in usersAtUnity) {
            listtest.removeIf { it == itn }
        }
        return listtest
    }


    fun uploadUnityToUser(onSuccess: () -> Unit) {
        val uidU = selUnity!!.uid!!
        var ifHaveUnity: Boolean
        for(item in ifDeletedUsers())
            mFirebase.database.child("users/$item/unity")
                .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                    val unityList = it.getValue<MutableList<String>>()
                    unityList!!.remove(uidU)
                    mFirebase.database.child("users/$item/unity").setValue(unityList)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {

                            } else {
                                showToast(it.exception!!.message!!)
                            }
                        }
                })
        for (item in usersAtUnity) {
            ifHaveUnity = false
            mFirebase.database.child("users/$item/unity")
                .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                    var unityList = mutableListOf<String>()
                    val cache = it.getValue<MutableList<String>>()
                    if (cache != null) {
                        unityList = cache
                        for (itm in unityList) {
                            if (itm == uidU) ifHaveUnity = true
                        }
                    }
                    if (!ifHaveUnity) {
                        unityList.add(uidU)
                        mFirebase.database.child("users/$item/unity").setValue(unityList)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {

                                } else {
                                    showToast(it.exception!!.message!!)
                                }
                            }
                    }
                })
        }
        onSuccess()
    }

    fun setUnity(url: String?, url2: String?): Unity {
        return Unity(
            shortname = text_name.text.toString(),
            name = text_fullname.text.toString(),
            text = text_text.text.toString(),
            users = usersAtUnity,
            vk = text_vk.text.toString(),
            img = url,
            imgmain = url2,
            sortword = text_sort.text.toString()
        )
    }
}