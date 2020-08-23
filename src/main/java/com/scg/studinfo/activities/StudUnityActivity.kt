package com.scg.studinfo.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.scg.studinfo.R
import com.scg.studinfo.models.FeedPost
import com.scg.studinfo.models.User
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_stud_unity.*
import kotlinx.android.synthetic.main.fragment_unity_news.view.*
import kotlinx.android.synthetic.main.fragment_unity_text.view.*


class StudUnityActivity : AppCompatActivity() {
    private lateinit var mFirebase: FireBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stud_unity)

        edit_unity_btn.visibility = View.INVISIBLE
        edit_unity_btn_text.visibility = View.INVISIBLE


        edit_unity_btn.setOnClickListener { editUnity() }
        edit_unity_btn_text.setOnClickListener { editUnity() }

        if(selUnity?.vk == null || selUnity?.vk == "") vk_btn.visibility = View.INVISIBLE

        vk_btn.setOnClickListener {
            val goVK = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://vk.me/${selUnity!!.vk}")
            )
            startActivity(goVK)
        }

        mFirebase = FireBaseHelper(this)

        if(mFirebase.isLogged) {
            mFirebase.currentUserReference()
                .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                    val user = it.getValue(User::class.java)!!
                    if (user.roles == "admin") {
                        edit_unity_btn.visibility = View.VISIBLE
                        edit_unity_btn_text.visibility = View.VISIBLE
                    }
                })
        }

        unity_image.loadUserPhoto(selUnity!!.img)
        title_unity.text = selUnity!!.name
        if (selUnity?.users != null) {
            num_people.text = selUnity!!.users!!.size.toString()
        }
        else num_people.text = "0"
        val viewPager: ViewPager = findViewById(R.id.viewpager)
        viewPager.adapter = SampleFragmentPagerAdapter(selUnity!!.text!!, supportFragmentManager,
            this)

        // Передаём ViewPager в TabLayout
        val tabLayout: TabLayout = findViewById(R.id.sliding_tabs)
        tabLayout.setupWithViewPager(viewPager)


    }

    private fun editUnity() {
        startActivity(Intent(this, EditUnityActivity::class.java))
    }
}

class PageFragment : Fragment() {
    private var mPage = 0
    private var mDescription: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getArguments() != null) {
            mPage = getArguments()!!.getInt(ARG_PAGE)
            mDescription = getArguments()!!.getString(TXT_PAGE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View
        if(mPage == 0) {
            view = inflater.inflate(R.layout.fragment_unity_text, container, false)
            view.description_unity.text = mDescription
        }
        else if(mPage == 1) {
            val mFirebase = FireBaseHelper(activity!!)
            view = inflater.inflate(R.layout.fragment_unity_news, container, false)
            mFirebase.database.child("users")
                .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                    val users = it.children.map {
                        it.getValue(User::class.java)!!
                            .copy(uid = it.key)
                    }
                    mFirebase.database.child("feed-posts")
                        .addValueEventListener(ValueEventListenerAdapter {
                            val posts = it.children.map {
                                it.getValue(FeedPost::class.java)!!.copy(uidNews = it.key)
                            }
                                .sortedByDescending { it.timestampDate() }
                            val sortPosts: MutableList<FeedPost> = mutableListOf(FeedPost())
                            sortPosts.clear()
                            for (item in posts) {
                                if(selUnity!!.uid == item.uid)
                                    if (!item.isDelete)
                                        sortPosts.add(item)
                            }
                            mFirebase.uploadUnity {
                                view.res_news.adapter = FeedAdapter(
                                    sortPosts,
                                    posts,
                                    activity!!,
                                    it,
                                    context!!
                                )
                                view.res_news.layoutManager = LinearLayoutManager(context!!)
                            }
                        })
                })
        }
        else {
            view = inflater.inflate(R.layout.fragment_unity_text, container, false)
            view.description_unity.text = "Fragment #$mPage"
        }
        return view
    }

    companion object {
        const val TXT_PAGE = "TXT_PAGE"
        const val ARG_PAGE = "ARG_PAGE"
        fun newInstance(page: Int): PageFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = PageFragment()
            fragment.setArguments(args)
            return fragment
        }
        fun newInstance(text: String, page: Int): PageFragment {
            val args = Bundle()
            args.putString(TXT_PAGE, text)
            args.putInt(ARG_PAGE, page)
            val fragment = PageFragment()
            fragment.setArguments(args)
            return fragment
        }
    }
}

class SampleFragmentPagerAdapter(private val text: String, fm: FragmentManager?,
                                 private val context: Context) :
    FragmentPagerAdapter(fm!!) {
    val PAGE_COUNT = 2
    private val tabTitles =
        arrayOf("Описание", "Новости")
    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getItem(position: Int): Fragment {
        if(position == 0) {
            return PageFragment.newInstance(text, position)
        }
        return PageFragment.newInstance(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // генерируем заголовок в зависимости от позиции
        return tabTitles[position]
    }

}
