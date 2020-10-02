package com.scg.studinfo.activities

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.drawToBitmap
import com.scg.studinfo.R
import com.scg.studinfo.models.FeedPost
import com.scg.studinfo.utils.CameraHelper
import com.scg.studinfo.utils.FireBaseHelper
import com.scg.studinfo.utils.GetDominatorColor
import com.scg.studinfo.views.CalendarDialog
import com.theartofdev.edmodo.cropper.CropImage
import kotlinx.android.synthetic.main.activity_add_activ.*
import java.util.*


class AddActivActivity() : AppCompatActivity(), CalendarDialog.ListenerCalendar {
    private lateinit var mFirebase: FireBaseHelper
    private lateinit var mCamera: CameraHelper
    private lateinit var mUri: Uri
    private lateinit var getDominatorColor: GetDominatorColor
    private var dominColor = 0
    private var setUinty = ""
    private var kolvoUnity = 0
    private var sortUnity: String? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_activ)

        mFirebase = FireBaseHelper(this)
        mCamera = CameraHelper(this)
        mCamera.takePicture()

        getDominatorColor = GetDominatorColor()

        image_unity.setOnClickListener { selectUnity() }
        unity_text.setOnClickListener { selectUnity() }
        unity_view.setOnClickListener { selectUnity() }

        text_toolbar_up.setOnClickListener { }

        post_image.setOnClickListener { mCamera.takePicture() }

        icon_exit.setOnClickListener { finish() }

        cal_ic.setOnClickListener { CalendarDialog().show(supportFragmentManager, "cal_d") }

        icon_add_post.setOnClickListener { share() }

        sort_check.setOnClickListener { sort_check.isSelected = !sort_check.isSelected }

        ch_box_razv.setOnClickListener {ch_box_razv.isSelected = !ch_box_razv.isSelected }
        ch_box_sport.setOnClickListener {ch_box_sport.isSelected = !ch_box_sport.isSelected }
        ch_box_days.setOnClickListener {ch_box_days.isSelected = !ch_box_days.isSelected }
        ch_box_nauka.setOnClickListener {ch_box_nauka.isSelected = !ch_box_nauka.isSelected }
        ch_box_tvor.setOnClickListener {ch_box_tvor.isSelected = !ch_box_tvor.isSelected }
        ch_box_work.setOnClickListener {ch_box_work.isSelected = !ch_box_work.isSelected }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == mCamera.REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                mUri = data!!.data!!
                CropImage.activity(mUri)
                    .setAspectRatio(8,5)
                    .start(this)
                GlideApp.with(this).load(mUri).centerCrop().into(post_image)
            } else {
                finish()
            }
        }
        else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            if (resultCode == Activity.RESULT_OK) {
                mUri = result.uri
                GlideApp.with(this).load(mUri).centerCrop().into(post_image)
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                val error = result.error
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mFirebase.currentUserReference().addListenerForSingleValueEvent(ValueEventListenerAdapter {
            val user = mFirebase.getUser(it)
            if (user.unity != null) {
                kolvoUnity = user.unity.size
                mFirebase.database.child("unity/${user.unity[selUnityActiv]}")
                    .addListenerForSingleValueEvent(
                        ValueEventListenerAdapter {
                            val unity = mFirebase.getUnity(it)
                            sortUnity = unity.sortword
                            if(unity.sortword.isNullOrEmpty()){
                                sort_check.isEnabled = false
                                sort_check.isSelected = true
                            }
                            unity_text.text = unity.name
                            image_unity.loadCircleImage(unity.img)
                            setUinty = unity.uid!!
                        })
            } else{
                showToast("Вас не добавили в СМИ объединения")
                finish()
            }
        })

    }

    private fun selectUnity() {
        if(kolvoUnity > 1)
            startActivity(Intent(this, ListUnityAtActivActivity::class.java))
    }

    private fun share() {
        if(title_activ.text.toString() == "Rick Astley"
            && text_active.text.toString() == "Never Gonna Give You Up"){
            val rickroll = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
            )
            startActivity(rickroll)
            return
        }
        if(checkTexts()) {
            return
        }
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Выкладываем...")
        progressDialog.setCancelable(false)
        progressDialog.show()
        icon_add_post.isEnabled = false
        val uid = mFirebase.chUid()
        mFirebase.uploadPostPhoto(null, mUri) {
            mFirebase.getUrl("users/${uid}/images/${mUri.lastPathSegment}") {
                val url = it.toString()
                dominColor = getDominatorColor.getDominantColor(post_image.drawToBitmap())
                mFirebase.addPostToDatabase(
                    feedPost(
                        setUinty,
                        url,
                        "users/${uid}/images/${mUri.lastPathSegment}"
                    )
                ) {
                    progressDialog.dismiss()
                    finish()
                    showToast("Ваше сообщение выложено в новости")
                }
            }
        }
    }

    private fun  checkTexts():Boolean {
        if (title_activ.text.isEmpty()) {
            showToast("Введите название")
            return true
        }
        if (text_active.text.isEmpty()) {
            showToast("Введите описание")
            return true
        }
        if (cal_text.text.isEmpty()) {
            showToast("Введите дату")
            return true
        }
        if (cal_text.text.toString()[2] != '.' || cal_text.text.toString()[5] != '.') {
            showToast("Неправильно введена дата")
            return true
        }
        return false
    }

    private fun feedPost(uid: String, url: String, img: String): FeedPost {
        val cache = mutableListOf<Boolean>()
        cache.add(ch_box_razv.isSelected)
        cache.add(ch_box_nauka.isSelected)
        cache.add(ch_box_sport.isSelected)
        cache.add(ch_box_tvor.isSelected)
        cache.add(ch_box_work.isSelected)
        cache.add(ch_box_days.isSelected)
        val dateIs = cal_text.text.split('.')
        val dateCal = Calendar.getInstance()
        dateCal.set(dateIs[2].toInt(), dateIs[1].toInt() - 1, dateIs[0].toInt())
        return FeedPost(
            user = mFirebase.chUid(),
            uid = uid,
            title = title_activ.text.toString(),
            image = url,
            startTime = dateCal.timeInMillis,
            text = text_active.text.toString(),
            sortWord = if(sort_check.isSelected) null else sortUnity,
            img = img,
            kategories = cache.toList(),
            domColor = dominColor
        )
    }

    override fun onTimeConfim(selDate: Long?) {
        if (selDate != null) {
            val day :String = if(getDatetime(selDate).get(Calendar.DAY_OF_MONTH) < 10)
                "0" + getDatetime(selDate).get(Calendar.DAY_OF_MONTH) else getDatetime(selDate).get(Calendar.DAY_OF_MONTH).toString()
            val month = if(getDatetime(selDate).get(Calendar.MONTH) + 1 < 10) "0" + (getDatetime(selDate).get(Calendar.MONTH) + 1)
            else (getDatetime(selDate).get(Calendar.MONTH) + 1).toString()
            val year = getDatetime(selDate).get(Calendar.YEAR)
            cal_text.setText("$day.$month.$year")
        }
    }
}