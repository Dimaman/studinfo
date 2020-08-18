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
import kotlinx.android.synthetic.main.activity_edit_unity.*

class EditUnityActivity : AppCompatActivity() {

    private lateinit var mFirebase: FireBaseHelper
    private lateinit var mCamera: CameraHelper
    private lateinit var mUri: Uri
    private var newPicture = false


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
            unity_image.loadUserPhoto(unity.img)
            if(unity.users != null)
            {
                usersAtUnity = unity.users as MutableList<String>
                persons_btn.text = "Участники: ${usersAtUnity.size}"
            }
            else persons_btn.text = "Участники: 0"
        }

        test.text = "test 1"
        test.setOnClickListener {
            var tets = "test 1"
            val tetw = ifDeletedUsers()
            for (item in tetw){
                tets += item
            }
            test.text = tets
        }


        icon_exit.setOnClickListener { finish() }
        unity_image.setOnClickListener {
            newPicture = true
            mCamera.takePicture()
        }
        icon_done.setOnClickListener { editUnity() }


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

    fun updateInfo(unity: Unity): MutableMap<String, Any?> {
        val updatesMap = mutableMapOf<String, Any?>()
        if(unity.name != selUnity!!.name) updatesMap["name"] = unity.name
        if (unity.shortname != selUnity!!.shortname) updatesMap["shortname"] = unity.shortname
        if(unity.text != selUnity!!.text) updatesMap["text"] = unity.text
        updatesMap["users"] = usersAtUnity
        if(newPicture) updatesMap["img"] = unity.img
        return updatesMap
    }

    override fun onResume() {
        super.onResume()
        persons_btn.text = "Участники: " + usersAtUnity.size
    }
    fun editUnity() {
        icon_done.isEnabled = false
        if(newPicture)
            mFirebase.uploadPostPhoto("unity/images/${mUri.lastPathSegment}", mUri) {
                mFirebase.getUrl("unity/images/${mUri.lastPathSegment}") {
                    val url = it.toString()
                    mFirebase.updateUnity(selUnity!!.uid!!, updateInfo(setUnity(url))) {
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
        else {
            mFirebase.updateUnity(selUnity!!.uid!!, updateInfo(setUnity(null))) {
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

    fun setUnity(url: String?): Unity {
        return Unity(
            text_name.text.toString(),
            text_fullname.text.toString(),
            text_text.text.toString(),
            usersAtUnity,
            url
        )
    }
}

