package com.scg.studinfo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scg.studinfo.R
import kotlinx.android.synthetic.main.activity_admin.*

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        add_unity_btn.setOnClickListener { startActivity(Intent(this, AddUnityActivity::class.java)) }
        users_btn.setOnClickListener { startActivity(Intent(this, UsersActivity::class.java)) }
        stats_btn.setOnClickListener { startActivity(Intent(this, StatsAppActivity::class.java)) }
    }

}