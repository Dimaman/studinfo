package com.scg.studinfo.activities

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.scg.studinfo.R
import com.scg.studinfo.models.FeedPost
import com.scg.studinfo.models.User
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_item_news.*
import java.util.*

class ItemNewsActivity : AppCompatActivity() {
    private lateinit var mFirebase: FireBaseHelper
    private lateinit var prefPers: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_news)

        image_news.clipToOutline = true

        icon_back.setOnClickListener {
            finishAfterTransition()
        }
        icon_eye.visibility = View.INVISIBLE
        text_views.visibility = View.INVISIBLE
        budu_btn.visibility = View.INVISIBLE

        prefPers = getSharedPreferences(PERSON_INFO, MODE_PRIVATE)
        mFirebase = FireBaseHelper(this)
        image_news.setImageBitmap(imageNews)
        imageNews = null
        if (mFirebase.isLogged) {
            mFirebase.checkRole {
                if (it == "admin") {
                    icon_eye.visibility = View.VISIBLE
                    text_views.visibility = View.VISIBLE
                }
            }
        }
        mFirebase.database.child("posts-guests/{$itemNews/guests}")
            .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                val guests = it.children.map { it.value as String }
                val newGuests = guests as MutableList
                if (!guests.contains(prefPers.getString(personKey, null)))
                    newGuests.add(prefPers.getString(personKey, null)!!)
                text_views.text = newGuests.size.toString()
                mFirebase.database.child("posts-guests/$itemNews/guests").setValue(newGuests)
            })
        mFirebase.database.child("feed-posts").child(itemNews!!)
            .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                val itemPost = it.getValue(FeedPost::class.java)
                title_news.text = itemPost!!.title
                if (itemPost.checkBtn != null && itemPost.checkBtn) {
                    budu_btn.visibility = View.VISIBLE
                }
                if(itemPost.startTime!! < System.currentTimeMillis()) {
                    budu_btn.setOnClickListener {
                        val rickroll = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
                        )
                        startActivity(rickroll)
                    }
                } else {
                    budu_btn.setOnClickListener { checkBudu() }

                }
                text_news.text = itemPost.text
                text_toolbar_up.text = timeText(itemPost.startTime)
            })
    }

    fun checkBudu() {
        if (mFirebase.isLogged) {
            mFirebase.currentUserReference()
                .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                    val user = it.getValue(User::class.java)!!
                    mFirebase.database.child("posts-guests/$itemNews/budu/${mFirebase.chUid()}/name")
                        .setValue(user.name).addOnCompleteListener {
                            if (it.isSuccessful) {
                                mFirebase.database.child("posts-guests/$itemNews/budu/${mFirebase.chUid()}/group")
                                    .setValue(user.group)
                                    .addOnCompleteListener {
                                        if (it.isSuccessful) {
                                            showToast("Вы записались на мероприятие")
                                        }
                                    }
                            }
                        }
                })
        } else {
            startActivity(Intent(this, InfoToActivityActivity::class.java))
        }
    }

    fun timeText(time: Long): String {
        val cal = Calendar.getInstance()
        var str = ""
        if (cal.get(Calendar.MONTH) < 8)
            str = "0"
        cal.timeInMillis = time
        return "${cal.get(Calendar.DAY_OF_MONTH)}.$str${cal.get(Calendar.MONTH) + 1}.${cal.get(
            Calendar.YEAR
        )}"
    }
}