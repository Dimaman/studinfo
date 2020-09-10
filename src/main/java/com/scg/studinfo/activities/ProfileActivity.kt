package com.scg.studinfo.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.scg.studinfo.R
import com.scg.studinfo.models.User
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity(2) {
    private lateinit var mUser: User
    private lateinit var mFireBase: FireBaseHelper

    //настройки


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupBottomNavigation()

        sel_unity_btn.setOnClickListener { goUnityList() }

        adm_menu_btn.setOnClickListener { goAdminActivity() }

        //кнопка пользователей
        adm_menu_btn.visibility = View.INVISIBLE
        adm_menu_btn_text.visibility = View.INVISIBLE


        mFireBase = FireBaseHelper(this)

        if(mFireBase.isLogged) {
            mFireBase.currentUserReference()
                .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                    mUser = it.getValue(User::class.java)!!
                    mFireBase.checkRole {
                        if (it == "admin") {
                            adm_menu_btn.visibility = View.VISIBLE
                            adm_menu_btn_text.visibility = View.VISIBLE
                        }
                    }
                })
        }
        icon_setting.setOnClickListener { goEdit() }

    }

    private fun goEdit() {
        if (mFireBase.isLogged) {
            startActivity(Intent(this, EditInfoActivity::class.java))
        } else {
            startActivity(Intent(this, EditlocalInfoActivity::class.java))
        }
    }
    private fun goUnityList() {
        startActivity(Intent(this, ListUnityActivity::class.java))
    }

    private fun goAdminActivity() {
        startActivity(Intent(this, AdminActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
    }


}
