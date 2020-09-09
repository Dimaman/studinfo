package com.scg.studinfo.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.scg.studinfo.R
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.*
import com.scg.studinfo.utils.FireBaseHelper
import com.scg.studinfo.views.PasswordDialog
import com.scg.studinfo.models.User
import kotlinx.android.synthetic.main.activity_edit_info.*


class EditInfoActivity : AppCompatActivity(), PasswordDialog.Listener {
    private lateinit var mUser: User
    private lateinit var mPendingEmail: User
    private lateinit var mFirebaseHelper: FireBaseHelper

    private lateinit var pref: SharedPreferences
    private lateinit var prefPers: SharedPreferences

    private val APP_PREFERENCES = "mysettings"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_info)

        mFirebaseHelper = FireBaseHelper(this)


        icon_check.isEnabled = false
        name_input.isEnabled = false
        group_input.isEnabled = false
        email_input.isEnabled = false

        //интересы
        prefPers = getSharedPreferences(PERSON_INFO, MODE_PRIVATE)
        pref = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

        getSavedInter()

        ch_box_razv.setOnClickListener { interSel(ch_box_razv, 0) }
        ch_box_nauka.setOnClickListener {interSel(ch_box_nauka, 1) }
        ch_box_sport.setOnClickListener {interSel(ch_box_sport, 2) }
        ch_box_tvor.setOnClickListener {interSel(ch_box_tvor, 3) }
        ch_box_work.setOnClickListener {interSel(ch_box_work, 4) }
        ch_box_days.setOnClickListener {interSel(ch_box_days, 5) }

        icon_out.setOnClickListener {
            mFirebaseHelper.auth.signOut()
            goOut()
            startActivity(Intent(this, TimetableActivity::class.java))
            finish()
        }

        fac_input.setAdapter(ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listFac))
        fac_input.setText(prefPers.getString(personFac, null))

        //загрузка данных
        mFirebaseHelper.currentUserReference()
            .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                mUser = it.getValue(User::class.java)!!
                name_input.setText(mUser.name, TextView.BufferType.EDITABLE)
                group_input.setText(mUser.group, TextView.BufferType.EDITABLE)
                email_input.setText(mUser.email, TextView.BufferType.EDITABLE)
                name_input.isEnabled = true
                group_input.isEnabled = true
                email_input.isEnabled = true
                icon_check.isEnabled = true
            })

        var groupList: List<String>
        mFirebaseHelper.database.child("timetable").addListenerForSingleValueEvent(ValueEventListenerAdapter{
            groupList = it.children.map { it.key!! }
            group_input.setAdapter(ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, groupList))
        })
        
        group_input.threshold = 3

        //клик на "применить"
        icon_check.setOnClickListener {
            mPendingEmail =
                User(
                    email = email_input.text.toString(),
                    group = group_input.text.toString(),
                    name = name_input.text.toString(),
                    uid = null
                )
            val error = validate(mPendingEmail)
            if (error == null) {
                if(mPendingEmail.email == mUser.email) {
                    updateUser(mPendingEmail)
                } else {
                    PasswordDialog().show(supportFragmentManager, "pass_d")
                }

            } else showToast(error)
        }
        //клик на закрытие
        icon_exit.setOnClickListener {
            finish()
        }
    }

    private fun interSel(btn: ImageButton, ind: Int) {
        btn.isSelected = !btn.isSelected
        val editor = pref.edit()
        editor.putBoolean(getStrSaveSetting()[ind], btn.isSelected)
        editor.apply()
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

    private fun goOut() {
        val editor = pref.edit()
        val cache = getStrSaveSetting()
        for(item in cache) {
            editor.putBoolean(item, false)
        }
        editor.apply()
    }

    private fun updateUser(user: User) {
        val updatesMap = mutableMapOf<String, Any?>()
        if(user.name != mUser.name) updatesMap["name"] = user.name
        if (user.email != mUser.email) updatesMap["email"] = user.email
        if(user.group != mUser.group) updatesMap["group"] = user.group

        mFirebaseHelper.updateUser(updatesMap) {
            val saveIs = prefPers.edit()
            saveIs.putString(personGroup, user.group)
            saveIs.putString(personFac, fac_input.text.toString())
            saveIs.apply()
            showToast("Сохранено")
            finish()
        }

    }

    private fun validate(user: User): String? =
        when {
            user.name.isEmpty() -> "Введите Имя"
            user.email.isEmpty() -> "Введите email"
            user.group.isEmpty() -> "Введите группу"
            else -> null
        }

    override fun onPassConfim(pass: String) {
        if(pass.isEmpty()){
            showToast("Ошибка, вы не введи пароль")
            return
        }
        val credential = EmailAuthProvider.getCredential(mUser.email, pass)
        mFirebaseHelper.reauthenticate(credential) {
            mFirebaseHelper.fetchSignInMethodsForEmail(mPendingEmail.email) {
                mFirebaseHelper.updateEmail(mPendingEmail.email) {
                    updateUser(mPendingEmail)
                }
            }
        }
    }
}

