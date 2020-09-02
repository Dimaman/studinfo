package com.scg.studinfo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scg.studinfo.R
import com.scg.studinfo.models.User
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_users.*
import kotlinx.android.synthetic.main.item_user.view.*
import java.util.*

class UsersActivity : AppCompatActivity() {
    private lateinit var mFirebase: FireBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        mFirebase = FireBaseHelper(this)

        icon_back.setOnClickListener { finish() }

        //загрузка пользователей
        mFirebase.database.child("users")
            .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                val user = it.children.map { it.getValue(User::class.java)!!
                    .copy(uid = it.key) }
                users_resycle.adapter = UsersListAdapter(mFirebase, user, this, this)
                users_resycle.layoutManager = LinearLayoutManager(this)
            })
    }
}


class UsersListAdapter(private val mFirebase: FireBaseHelper, private val itemsU: List<User>, private val context: UsersActivity,
                       private val activ: UsersActivity
) : RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemsU.size



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.nick_text.text = itemsU[position].name
        holder.view.group_text.text = itemsU[position].group

        mFirebase.database.child("online/users/${itemsU[position].uid}")
            .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                if (it.getValue() != null) {
                    val time = Date(it.getValue() as Long)
                    holder.view.time_open
                        .text = "$time"
                }
            })
        mFirebase.checkRole(itemsU[position].uid!!) {
            holder.view.role_btn.text = it ?: "User"
        }
        holder.view.role_btn.setOnClickListener {
            showPop(itemsU[position].uid!!, holder.view.role_btn, holder)

        }

    }

    fun showPop(uid: String, btn: View, holder: ViewHolder) {
        val popMenu = showPopup(context, btn, R.menu.roles_users)
        popMenu.setOnMenuItemClickListener {
            return@setOnMenuItemClickListener when (it.itemId) {
                R.id.role_admin -> {
                    edRoleUser(uid, "admin", holder)
                    true
                }
                R.id.role_moder -> {
                    edRoleUser(uid, "moder", holder)
                    true
                }
                R.id.role_user -> {
                    edRoleUser(uid, null, holder)
                    true
                }
                else -> false
            }
        }
    }

    private fun edRoleUser(uid: String, role: String?, holder: ViewHolder) {
        val cachePosts: MutableList<User> = mutableListOf(User())
        cachePosts.clear()
        cachePosts.addAll(itemsU)
        mFirebase.database.child("private/users/$uid/role").setValue(role).addOnCompleteListener {
            activ.showToast("Изменено")
            holder.view.role_btn.text = role ?: "USER"
        }
    }
}