package com.scg.studinfo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scg.studinfo.R
import com.scg.studinfo.models.FeedGuest
import com.scg.studinfo.models.FeedPost
import com.scg.studinfo.models.Unity
import com.scg.studinfo.models.User
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_stats_app.*
import java.util.*

class StatsAppActivity : AppCompatActivity() {
    private lateinit var mFirebase: FireBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats_app)

        mFirebase = FireBaseHelper(this)

        mFirebase.database.child("guest").addListenerForSingleValueEvent(ValueEventListenerAdapter { guests ->
            mFirebase.database.child("online/users")
                .addListenerForSingleValueEvent(ValueEventListenerAdapter { onlineUsers ->
                    val listUsers = onlineUsers.children.map { it.value!! as Long }
                    val listGuests = guests.children.map { it.getValue(FeedGuest::class.java)!! }
                    guests_text.text = "${listGuests.count()}"
                    var onliners = 0
                    for (item in listGuests) {
                        if (item.online != null)
                            if (getToday() < item.online) onliners++
                    }
                    for (item in listUsers){
                        if (getToday() < item) onliners++
                    }
                    today_text.text = "$onliners"
                })
        })

        mFirebase.database.child("users").addListenerForSingleValueEvent(ValueEventListenerAdapter { users ->
            val listUsers = users.children.map { it.getValue(User::class.java)!!.copy(uid = it.key) }
            users_text.text = "${listUsers.count()}"
        })

        mFirebase.database.child("unity").addListenerForSingleValueEvent(ValueEventListenerAdapter{
            val listUnity = it.children.map { it.getValue(Unity::class.java)!!.copy(uid = it.key) }
            news_text.text = "${listUnity.count()}"
        })

        mFirebase.database.child("unity").addListenerForSingleValueEvent(ValueEventListenerAdapter{
            val listUnity = it.children.map { it.getValue(Unity::class.java)!!.copy(uid = it.key) }
            unity_text.text = "${listUnity.count()}"
        })

        mFirebase.database.child("feed-posts").addListenerForSingleValueEvent(ValueEventListenerAdapter{
            val listPosts = it.children.map { it.getValue(FeedPost::class.java)!!.copy(uidNews = it.key) }
            var deletes = 0
            news_text.text = "${listPosts.count()}"
            for (item in listPosts){
                if(item.isDelete) deletes++
            }
            del_news_text.text = "$deletes"
        })
    }

    private fun getToday(): Long {
        val cal = Calendar.getInstance()
        cal.timeInMillis = System.currentTimeMillis()
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0 )
        return cal.timeInMillis
    }
}