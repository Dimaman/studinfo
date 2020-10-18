package com.scg.studinfo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scg.studinfo.R
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_info_to_activity.*

class InfoToActivityActivity : AppCompatActivity() {
    private lateinit var mFirebase: FireBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_to_activity)
        mFirebase = FireBaseHelper(this)
        icon_check.setOnClickListener { addInfoPersonToActivity() }
    }

    fun addInfoPersonToActivity() {
        if(validateBtn(name_input.text.toString())){
            val prefPers = getSharedPreferences(PERSON_INFO, MODE_PRIVATE)
            mFirebase.database.child("posts-guests/$itemNews/budu/${prefPers.getString(personKey, null)}/name")
                .setValue(name_input.text).addOnCompleteListener {
                    if (it.isSuccessful) {
                        mFirebase.database.child("posts-guests/$itemNews/budu/${prefPers.getString(
                            personKey, null)}/group")
                            .setValue(prefPers.getString(personGroup, ""))
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    showToast("Вы записались на мероприятие")
                                    finish()
                                }
                            }
                    }
                }

        }
    }
}