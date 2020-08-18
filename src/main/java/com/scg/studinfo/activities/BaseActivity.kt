package com.scg.studinfo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.scg.studinfo.R
import kotlinx.android.synthetic.main.bot_nav_view.*

abstract class BaseActivity(private val navNumber: Int) : AppCompatActivity(){



    fun setupBottomNavigation() {
        bottom_navigation_view.setTextVisibility(false)
        bottom_navigation_view.enableAnimation(false)
        for (i in 0 until bottom_navigation_view.menu.size()) {
            bottom_navigation_view.setIconTintList(i, null)
        }
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            val nextActivity =
                when (it.itemId) {
                    R.id.nav_item_timetable -> TimetableActivity::class.java
                    R.id.nav_item_activity -> ActivityActivity::class.java
                    R.id.nav_item_profile -> ProfileActivity::class.java
                    else -> null
                }
            if (nextActivity != null) {
                val intent = Intent(this, nextActivity)
                intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(intent)
                finish()
                overridePendingTransition(0,0)
                true
            } else {
                false
            }

        }
        bottom_navigation_view.menu.getItem(navNumber).isChecked = true
    }

    override fun onResume() {
        super.onResume()
        if(bottom_navigation_view != null){
            bottom_navigation_view.menu.getItem(navNumber).isChecked = true
        }
    }
}
