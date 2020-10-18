package com.scg.studinfo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scg.studinfo.R
import com.scg.studinfo.models.GuestsActiv
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_stats_news.*
import kotlinx.android.synthetic.main.feed_guests.view.*

class StatsNewsActivity : AppCompatActivity() {
    private lateinit var mFirebase: FireBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats_news)

        mFirebase = FireBaseHelper(this)

        icon_back.setOnClickListener { finish() }

        mFirebase.database.child("posts-guests/$itemNews/budu")
            .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                val guests = it.children.map { it.getValue(GuestsActiv::class.java)!! }
                guest_recycler.adapter = GuestsNewsAdapter(guests)
                guest_recycler.layoutManager = LinearLayoutManager(this)
            })
    }
}

class GuestsNewsAdapter(private val listGuest: List<GuestsActiv>) : RecyclerView.Adapter<GuestsNewsAdapter.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        view = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_guests, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listGuest.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.nick_text.text = listGuest[position].name
        holder.view.group_text.text = listGuest[position].group
    }
}