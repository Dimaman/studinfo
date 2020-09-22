package com.scg.studinfo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scg.studinfo.R
import com.scg.studinfo.models.FeedPost
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_item_news.*
import java.util.*

class ItemNewsActivity : AppCompatActivity() {
    private lateinit var mFirebase: FireBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_news)

        image_news.clipToOutline = true

        mFirebase = FireBaseHelper(this)
        image_news.setImageBitmap(imageNews)
        imageNews = null
        mFirebase.database.child("feed-posts").child(itemNews!!)
            .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                val itemPost = it.getValue(FeedPost::class.java)
                title_news.text = itemPost!!.title
                text_news.text = itemPost.text
                if(itemPost.startTime != null)
                    time_text.text = timeText(itemPost.startTime)
            })
    }

    fun timeText(time: Long): String {
        val cal = Calendar.getInstance()
        var str = ""
        if (cal.get(Calendar.MONTH) < 9)
            str = "0"
        cal.timeInMillis = time
        return "${cal.get(Calendar.DAY_OF_MONTH)}/$str${cal.get(Calendar.MONTH) + 1}/${cal.get(
            Calendar.YEAR)}"
    }
}