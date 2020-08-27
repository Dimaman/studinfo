package com.scg.studinfo.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.scg.studinfo.R
import com.scg.studinfo.models.User
import kotlinx.android.synthetic.main.activity_add_info.*

class AddInfoActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private var mEmail: String = ""
    private lateinit var mDatabase: DatabaseReference

    private lateinit var pref: SharedPreferences
    private lateinit var prefPers: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_info)
        mAuth = FirebaseAuth.getInstance()

        mDatabase = FirebaseDatabase.getInstance().reference
        //load from database
        icon_check.isEnabled = false
        mDatabase.child("timetable").addListenerForSingleValueEvent(ValueEventListenerAdapter {
            val groupList = it.children.map { it.key!! }
            group_input.setAdapter(ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, groupList))
        })


        prefPers = getSharedPreferences(PERSON_INFO, MODE_PRIVATE)
        pref = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        group_input.setText(prefPers.getString(personGroup, null))

        val savedInt = getSaveSetting(this)
        ch_box_razv.isSelected = savedInt[0]
        ch_box_nauka.isSelected = savedInt[1]
        ch_box_sport.isSelected = savedInt[2]
        ch_box_tvor.isSelected = savedInt[3]
        ch_box_work.isSelected = savedInt[4]
        ch_box_days.isSelected = savedInt[5]

        ch_box_razv.setOnClickListener { interSel(ch_box_razv, 0) }
        ch_box_nauka.setOnClickListener {interSel(ch_box_nauka, 1) }
        ch_box_sport.setOnClickListener {interSel(ch_box_sport, 2) }
        ch_box_tvor.setOnClickListener {interSel(ch_box_tvor, 3) }
        ch_box_work.setOnClickListener {interSel(ch_box_work, 4) }
        ch_box_days.setOnClickListener {interSel(ch_box_days, 5) }

        group_input.threshold = 3

        mDatabase.child("users").child(mAuth.currentUser!!.uid)
            .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                val cache_user = it.getValue(User::class.java)
                mEmail = cache_user!!.email
                icon_check.isEnabled = true
            })
        icon_check.setOnClickListener { saveInfo() }
    }

    private fun interSel(btn: ImageButton, ind: Int) {
        btn.isSelected = !btn.isSelected
        val editor = pref.edit()
        editor.putBoolean(getStrSaveSetting()[ind], btn.isSelected)
        editor.apply()
    }

    fun saveInfo() {
        if (validateBtn(group_input.text.toString(),name_input.text.toString())) {
            val user =
                User(email = mEmail, group = group_input.text.toString(),
                    name = name_input.text.toString())

            mDatabase.child("users").child(mAuth.currentUser!!.uid).setValue(user)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(Intent(this, TimetableActivity::class.java))
                        finish()
                    } else {
                        showToast("Произошло что-то страшное, повторите позже")
                    }
                }
        } else {
            showToast("Введите все данные")
        }
    }
}
