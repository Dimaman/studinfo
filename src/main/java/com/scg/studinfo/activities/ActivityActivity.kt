package com.scg.studinfo.activities

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.drawToBitmap
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scg.studinfo.R
import com.scg.studinfo.models.FeedPost
import com.scg.studinfo.models.Unity
import com.scg.studinfo.models.User
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_activity.*
import kotlinx.android.synthetic.main.feed_item.view.*
import kotlinx.android.synthetic.main.feed_split_item.view.*


class ActivityActivity : BaseActivity(0) {
    private lateinit var mFirebase: FireBaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity)
        setupBottomNavigation()


        icon_add_new.visibility = View.INVISIBLE

        mFirebase = FireBaseHelper(this)
        //val mUid = mFirebase.auth.currentUser!!.uid
        if(mFirebase.auth.currentUser != null) {
            mFirebase.currentUserReference()
                .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                    val user = it.getValue(User::class.java)!!.copy(uid = it.key)
                    if (user.roles == "admin" || user.roles == "moder") {
                        icon_add_new.visibility = View.VISIBLE
                    }
                })
        }

        mFirebase.database.child("feed-posts")
            .addValueEventListener(ValueEventListenerAdapter {
                val posts = it.children.map {
                    it.getValue(FeedPost::class.java)!!.copy(uidNews = it.key)
                }
                    .sortedByDescending { it.timestampDate() }
                val sortPosts: MutableList<FeedPost> = mutableListOf(FeedPost())
                val sortOldPosts: MutableList<FeedPost> = mutableListOf(FeedPost())
                sortPosts.clear()
                sortOldPosts.clear()
                for (item in posts) {
                    if (!item.isDelete) {
                        val cacheSave = getSaveSetting(this)
                        if (checkBtn(cacheSave.toList())) {
                            if (item.kategories != null) {
                                if (checkBtn(cacheSave.toList(), item.kategories)) {
                                    if (item.startTime != null) {
                                        if (item.startTime > System.currentTimeMillis()) {
                                            sortPosts.add(item)
                                        } else sortOldPosts.add(item)
                                    } else sortOldPosts.add(item)
                                }
                            }
                        } else {
                            if (item.startTime != null) {
                                if (item.startTime > System.currentTimeMillis()) {
                                    sortPosts.add(item)
                                } else sortOldPosts.add(item)
                            } else sortOldPosts.add(item)
                        }
                    }
                }
                sortPosts.sortByDescending { it.startTime }
                val lastListPosts = mutableListOf(FeedPost())
                lastListPosts.clear()
                lastListPosts.add(FeedPost(uidNews = "split", uid = "Актуальное"))
                lastListPosts.addAll(sortPosts)
                lastListPosts.add(FeedPost(uidNews = "split", uid = "Нектуальное"))
                lastListPosts.addAll(sortOldPosts)
                mFirebase.uploadUnity {

                    feed_recycler.adapter = FeedAdapter(
                        lastListPosts, posts, this, it, this
                    )
                    feed_recycler.layoutManager = LinearLayoutManager(this)
                }
            })

        icon_add_new.setOnClickListener { addImageMenu() }
    }

    fun addImageMenu() {
        startActivity(Intent(this, AddActivActivity()::class.java))
    }

    fun checkBtn(li: List<Boolean>, lii: List<Boolean>): Boolean {
        for (i in 0..5) {
            if (li[i] == lii[i] && li[i]) return true
        }
        return false
    }
    fun checkBtn(li: List<Boolean>): Boolean {
        for (i in 0..5) {
            if (li[i]) return true
        }
        return false
    }
}

class FeedAdapter (private val posts: List<FeedPost>,
                   private val allPosts: List<FeedPost>, private val activ: Activity,
                   private val unity: List<Unity>, private val context: Context)
    : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view: View
        if(viewType == 1)
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.feed_split_item, parent, false)
        else
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.feed_item, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val firebase = FireBaseHelper(activ)
        if(getItemViewType(position) == 0) {
            holder.view.image_activ.loadImage(posts[position].image!!, true)
            correctGradient(holder.view, position)
            if (posts[position].startTime != null) {
                if (posts[position].startTime!! < System.currentTimeMillis()) {
                    holder.view.image_activ.colorFilter =
                        ColorMatrixColorFilter(ColorMatrix().apply { setSaturation(0f) })
                    holder.view.domination_color_bg.background.colorFilter =
                        ColorMatrixColorFilter(ColorMatrix().apply { setSaturation(0f) })
                }
            }
            else {
                holder.view.image_activ.colorFilter =
                    ColorMatrixColorFilter(ColorMatrix().apply { setSaturation(0f) })
                holder.view.domination_color_bg.background.colorFilter =
                    ColorMatrixColorFilter(ColorMatrix().apply { setSaturation(0f) })
            }
            holder.view.title_activ.text = posts[position].title
            holder.view.activ_who.text =
                unity.findLast { it.uid == posts[position].uid }!!.shortname
            if (firebase.isLogged) {
                firebase.currentUserReference()
                    .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                        val user = it.getValue(User::class.java)!!.copy(uid = it.key)
                        holder.view.icon_edit_post.isEnabled = user.roles == "admin"
                    })
            } else {
                holder.view.icon_edit_post.isEnabled = false
            }
            holder.view.icon_edit_post.setOnClickListener {
                openPopmenu(holder.view.icon_edit_post, posts[position].uidNews!!)
            }
            holder.view.image_activ.loadImage(posts[position].image!!, true)
            holder.view.title_activ.text = posts[position].title
            holder.view.activ_who.text =
                unity.findLast { it.uid == posts[position].uid }!!.shortname
            holder.view.domination_color_bg.setOnClickListener { openView(position, holder.view) }
            holder.view.image_activ.setOnClickListener { openView(position, holder.view) }
            holder.view.title_activ.setOnClickListener { openView(position, holder.view) }
        } else {
            holder.view.text_actual.text = posts[position].uid
        }
    }



    override fun getItemViewType(position: Int): Int {
        return if(posts[position].uidNews == "split") 1
        else 0
    }

    private fun openView(position: Int, view: View) {
        itemNews = posts[position].uidNews
        imageNews = view.image_activ.drawToBitmap()
        /*activ.startActivity(Intent(activ, ItemNewsActivity::class.java))*/
        var bundle: Bundle? = null
        val v: View = view.findViewById(R.id.image_activ)
        val options = ActivityOptions.makeSceneTransitionAnimation(
            activ,
            v,
            activ.getString(R.string.image_news_item)
        )
        bundle = options.toBundle()
        val intent = Intent(activ, ItemNewsActivity::class.java)
        if (bundle == null) {
            activ.startActivity(intent)
        } else {
            activ.startActivity(intent, bundle)
        }
    }

    private fun openPopmenu(icon: View, uid: String) {
        val popMenu = showPopup(context, icon, R.menu.item_feed_menu)
        popMenu.setOnMenuItemClickListener {
            return@setOnMenuItemClickListener when (it.itemId) {
                R.id.delete_news -> {
                    deleteNew(uid)
                    true
                }
                else -> false
            }
        }
    }

    private fun deleteNew(uid: String) {
        val mFirebase = FireBaseHelper(activ)
        val cachePosts: MutableList<FeedPost> = mutableListOf(FeedPost())
        cachePosts.clear()
        cachePosts.addAll(allPosts)
        for (post in cachePosts) {
            if(post.uidNews == uid)
            {
                post.isDelete = true
            }
        }
        val updatesMap = mutableMapOf<String, Any?>()
        for (item in cachePosts) {
            updatesMap["${item.uidNews}"] = item
        }
        mFirebase.updateInfo("feed-posts", updatesMap) {
            activ.showToast("Удалено")
        }
    }

    private fun correctGradient(view: View, position: Int) {
        view.clipToOutline = true
        view.image_activ.clipToOutline = true
        val colors = intArrayOf(
            Color.parseColor("#00000000"),
            posts[position].domColor!!,
            posts[position].domColor!!,
            posts[position].domColor!!
        )
        val drawBg = (GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors))
        drawBg.cornerRadius = 40f
        view.domination_color_bg.background = drawBg
    }
}

