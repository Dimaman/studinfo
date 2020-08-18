package com.scg.studinfo.activities

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scg.studinfo.R
import com.scg.studinfo.models.User
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_add_persons_at_unity.*
import kotlinx.android.synthetic.main.item_add_user.view.*

class AddPersonsAtUnityActivity :  AppCompatActivity(), AddUsersListAdapter.Listener {
    private lateinit var mFirebase: FireBaseHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_persons_at_unity)

        mFirebase = FireBaseHelper(this)

        mFirebase.database.child("users")
            .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                val user = it.children.map { it.getValue(User::class.java)!!
                    .copy(uid = it.key) }
                users_resycle.adapter = AddUsersListAdapter(user, this)
                users_resycle.layoutManager = LinearLayoutManager(this)
            })

        icon_back.setOnClickListener { finish() }
    }

    override fun SelectUsers(usersId: String) {
        usersAtUnity.add(usersId)
    }

    override fun UnSelectUsers(usersId: String) {
        usersAtUnity.remove(usersId)
    }
}


class AddUsersListAdapter(private val itemsU: List<User>, private val context: Context
                          //private val activ: Activity
) : RecyclerView.Adapter<AddUsersListAdapter.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    private lateinit var mListener: Listener


    interface Listener {
        fun SelectUsers(usersId: String)
        fun UnSelectUsers(usersId: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddUsersListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_add_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemsU.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mListener = context as Listener
    }

    override fun onBindViewHolder(holder: AddUsersListAdapter.ViewHolder, position: Int) {
        holder.view.nick_text.text = itemsU[position].name
        holder.view.group_text.text = itemsU[position].group
        for (item in usersAtUnity){
            if(itemsU[position].uid == item){
                holder.view.add_btn.isSelected = true
            }
        }
        holder.view.add_btn.setOnClickListener {
            if(holder.view.add_btn.isSelected) {
                holder.view.add_btn.isSelected = false
                mListener.UnSelectUsers(itemsU[position].uid!!)
            }
            else {
                holder.view.add_btn.isSelected = true
                mListener.SelectUsers(itemsU[position].uid!!)
            }
        }
    }

}