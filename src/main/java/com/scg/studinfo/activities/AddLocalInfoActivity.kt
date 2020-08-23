package com.scg.studinfo.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import com.scg.studinfo.R
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_add_local_info.*

class AddLocalInfoActivity : AppCompatActivity() {
    private lateinit var mFirebase: FireBaseHelper

    private lateinit var pref: SharedPreferences
    private lateinit var prefPers: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_local_info)

        prefPers = getSharedPreferences(PERSON_INFO, MODE_PRIVATE)
        pref = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        mFirebase = FireBaseHelper(this)
        mFirebase.database.child("timetable").addListenerForSingleValueEvent(ValueEventListenerAdapter {
            val groupList = it.children.map { it.key!! }
            group_input.setAdapter(ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, groupList))
        })

        ch_box_razv.setOnClickListener { interSel(ch_box_razv, 0) }
        ch_box_nauka.setOnClickListener {interSel(ch_box_nauka, 1) }
        ch_box_sport.setOnClickListener {interSel(ch_box_sport, 2) }
        ch_box_tvor.setOnClickListener {interSel(ch_box_tvor, 3) }
        ch_box_work.setOnClickListener {interSel(ch_box_work, 4) }
        ch_box_days.setOnClickListener {interSel(ch_box_days, 5) }

        icon_check.setOnClickListener { saveInfo() }
    }

    private fun interSel(btn: ImageButton, ind: Int) {
        btn.isSelected = !btn.isSelected
        val editor = pref.edit()
        editor.putBoolean(getStrSaveSetting()[ind], btn.isSelected)
        editor.apply()
    }

    fun saveInfo() {
        if (validateBtn(group_input.text.toString())) {
           val editor = prefPers.edit()

            mFirebase.guestAdded(null) {
                editor.putString(personKey, it)
                editor.putString(personGroup, group_input.text.toString())
                editor.apply()
                mFirebase.guestAddedGroup(it, group_input.text.toString())
                startActivity(Intent(this, TimetableActivity::class.java))
                finish()
            }
        }
    }
}