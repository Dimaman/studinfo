package com.scg.studinfo.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scg.studinfo.R
import com.scg.studinfo.models.Unity
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_list_unity.*
import kotlinx.android.synthetic.main.item_unity.view.*

class ListUnityActivity : AppCompatActivity(), UnityListAdapter.Listener {
    private lateinit var mFirebase: FireBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_unity)

        mFirebase = FireBaseHelper(this)

        icon_back.setOnClickListener { finish() }

        mFirebase.uploadUnity {
                unity_resycle.adapter = UnityListAdapter(it, this)
                unity_resycle.layoutManager = LinearLayoutManager(this)
            }
    }



    override fun loadUnity(unity: Unity) {
        selUnity = unity
        startActivity(Intent(this, StudUnityActivity::class.java))
    }

    override fun loadUnityActiv(pos: Int) {
        /*Ничего не должно происходить*/
    }
}


class UnityListAdapter(private val unity: List<Unity>, private val context: Context)
    : RecyclerView.Adapter<UnityListAdapter.ViewHolder>() {
    private lateinit var mListener: Listener

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    interface Listener {
        fun loadUnity(unity: Unity)
        fun loadUnityActiv(pos: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnityListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_unity, parent, false)
        return ViewHolder(view)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mListener = context as Listener
    }
    override fun getItemCount(): Int = unity.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.image_unity.loadUserPhoto(unity[position].img)
        holder.view.unity_text.text = unity[position].name
        holder.view.click.setOnClickListener {
            mListener.loadUnity(unity[position])
            mListener.loadUnityActiv(position)
        }
        holder.view.image_unity.setOnClickListener {
            mListener.loadUnity(unity[position])
            mListener.loadUnityActiv(position)
        }
        holder.view.unity_text.setOnClickListener {
            mListener.loadUnity(unity[position])
            mListener.loadUnityActiv(position)
        }
    }


}



