package com.scg.studinfo.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import com.scg.studinfo.R
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_edit_local_info.*



class EditlocalInfoActivity : AppCompatActivity() {
    private lateinit var mFirebase: FireBaseHelper

    private lateinit var pref: SharedPreferences
    private lateinit var prefPers: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_local_info)

        prefPers = getSharedPreferences(PERSON_INFO, MODE_PRIVATE)
        pref = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        mFirebase = FireBaseHelper(this)

        mFirebase.database.child("timetable").addListenerForSingleValueEvent(ValueEventListenerAdapter {
            val groupList = it.children.map { it.key!! }
            group_input.setAdapter(ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, groupList))
        })

        getSavedInter()

        group_input.setText(prefPers.getString(personGroup, null))

        ch_box_razv.setOnClickListener { interSel(ch_box_razv, 0) }
        ch_box_nauka.setOnClickListener {interSel(ch_box_nauka, 1) }
        ch_box_sport.setOnClickListener {interSel(ch_box_sport, 2) }
        ch_box_tvor.setOnClickListener {interSel(ch_box_tvor, 3) }
        ch_box_work.setOnClickListener {interSel(ch_box_work, 4) }
        ch_box_days.setOnClickListener {interSel(ch_box_days, 5) }

        icon_check.setOnClickListener {
            mFirebase.guestAddedGroup(prefPers.getString(personKey, "test")!!, group_input.text.toString())
            finish()
        }
        icon_exit.setOnClickListener { finish() }

        icon_in.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    fun getSavedInter() {
        val cache = getSaveSetting(this)
        ch_box_razv.isSelected = cache[0]
        ch_box_nauka.isSelected = cache[1]
        ch_box_sport.isSelected = cache[2]
        ch_box_tvor.isSelected = cache[3]
        ch_box_work.isSelected = cache[4]
        ch_box_days.isSelected = cache[5]
    }

    private fun interSel(btn: ImageButton, ind: Int) {
        btn.isSelected = !btn.isSelected
        val editor = pref.edit()
        editor.putBoolean(getStrSaveSetting()[ind], btn.isSelected)
        editor.apply()
    }
}