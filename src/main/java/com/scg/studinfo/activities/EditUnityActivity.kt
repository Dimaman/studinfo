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
    private lateinit var usersOnUnity: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_unity)

        mFirebase = FireBaseHelper(this)
        mCamera = CameraHelper(this)

        usersOnUnity = mutableListOf()
        usersOnUnity.addAll(selUnity!!.users!!)

        mFirebase.uploadUnity(selUnity!!.uid!!) {
            text_name.setText(it.shortname)
            text_fullname.setText(it.name)
            text_text.setText(it.text)
            text_vk.setText(it.vk)
            text_sort.setText(it.sortword)
            unity_image.loadCircleImage(it.img)
            bg_img_unity.loadCircleImage(it.imgmain)
            if (it.users != null) {
                usersAtUnity = it.users as MutableList<String>
                persons_btn.text = "Участники: ${usersAtUnity.size}"
            } else persons_btn.text = "Участники: 0"
            return@uploadUnity
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
            startActivity(
                Intent(
                    this,
                    AddPersonsAtUnityActivity::class.java
                )
            )
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
        if (unity.name != selUnity!!.name) updatesMap["name"] = unity.name
        if (unity.shortname != selUnity!!.shortname) updatesMap["shortname"] = unity.shortname
        if (unity.text != selUnity!!.text) updatesMap["text"] = unity.text
        if (unity.vk != selUnity!!.vk) updatesMap["vk"] = unity.vk
        updatesMap["users"] = usersAtUnity
        if (newImg) updatesMap["img"] = unity.img
        if (newImgBg) updatesMap["imgmain"] = unity.imgmain
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
        if (newImg)
            mFirebase.uploadPostPhoto("unity/images/${mUri.lastPathSegment}", mUri) {
                if (newImgBg) {
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
                                        mFirebase.uploadUnity(selUnity!!.uid!!) {
                                            selUnity = it
                                            showToast("Объединение было изменено")
                                            finish()
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
                                mFirebase.uploadUnity(selUnity!!.uid!!) {
                                    selUnity = it
                                    finish()
                                    showToast("Объединение было изменено")
                                }
                            }
                        }

                    }
                }
            }
        else if (newImgBg) {
            mFirebase.uploadPostPhoto("unity/images/${mUriImg.lastPathSegment}", mUriImg) {
                mFirebase.getUrl("unity/images/${mUriImg.lastPathSegment}") { imgUrl ->
                    progressDialog.dismiss()
                    val urlBg = imgUrl.toString()
                    mFirebase.updateUnity(
                        selUnity!!.uid!!,
                        updateInfo(setUnity(null, urlBg))
                    ) {
                        uploadUnityToUser {
                            mFirebase.uploadUnity(selUnity!!.uid!!) {
                                selUnity = it
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
                    mFirebase.uploadUnity(selUnity!!.uid!!) {
                        selUnity = it
                        finish()
                        showToast("Объединение было изменено")
                    }

                }
            }
        }
    }

    fun uploadUnityToUser(onSuccess: () -> Unit) {
        val uidU = selUnity!!.uid!!
        val delUsersList = mutableListOf<String>()
        val addUsersList = mutableListOf<String>()
        delUsersList.addAll(usersOnUnity)
        delUsersList.removeAll(usersAtUnity)
        addUsersList.addAll(usersAtUnity)
        addUsersList.removeAll(usersOnUnity)
        mFirebase.database.child("users")
            .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                val delUsersUnity = mutableListOf<MutableList<String>>()
                val addUsersUnity = mutableListOf<MutableList<String>>()
                for (id in 0 until delUsersList.size) {
                    if (it.child("${delUsersList[id]}/unity")
                            .getValue<MutableList<String>>() != null
                    )
                        delUsersUnity.add(
                            it.child("${delUsersList[id]}/unity").getValue<MutableList<String>>()!!
                        )
                    else delUsersUnity.add(mutableListOf())
                    if(delUsersUnity[id].contains(uidU))
                        delUsersUnity[id].remove(uidU)
                    mFirebase.database.child("users/${delUsersList[id]}/unity")
                        .setValue(delUsersUnity[id]).addOnCompleteListener {
                            if (!it.isSuccessful) {
                                showToast(it.exception!!.message!!)
                            }
                        }
                }
                for (id in 0 until addUsersList.size) {
                    if (it.child("${addUsersList[id]}/unity")
                            .getValue<MutableList<String>>() != null
                    )
                        addUsersUnity.add(
                            it.child("${addUsersList[id]}/unity").getValue<MutableList<String>>()!!
                        )
                    else addUsersUnity.add(mutableListOf())
                    if(!addUsersUnity[id].contains(uidU))
                        addUsersUnity[id].add(uidU)
                    mFirebase.database.child("users/${addUsersList[id]}/unity")
                        .setValue(addUsersUnity[id]).addOnCompleteListener {
                            if (!it.isSuccessful) {
                                showToast(it.exception!!.message!!)
                            }
                        }
                }
                onSuccess()
            })
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