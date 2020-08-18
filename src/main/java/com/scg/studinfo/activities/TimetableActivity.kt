package com.scg.studinfo.activities

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.scg.studinfo.R
import com.scg.studinfo.models.TimetableItem
import com.scg.studinfo.models.TimetableWeek
import com.scg.studinfo.models.User
import com.scg.studinfo.utils.FireBaseHelper
import com.scg.studinfo.views.UpdateVersionDialogFragment
import kotlinx.android.synthetic.main.activity_timetable.*
import kotlinx.android.synthetic.main.item_timetable.view.*
import kotlinx.android.synthetic.main.fragment_timetable.view.*
import kotlinx.android.synthetic.main.fragment_timetable_now.view.*
import kotlinx.android.synthetic.main.item_week.view.day_of_week_now
import kotlinx.android.synthetic.main.item_week.view.res_timetable_id


class TimetableActivity : BaseActivity(1) {
    private lateinit var mFirebase : FireBaseHelper

    private val NOTIFY_ID = 101

    // Идентификатор канала
    private val CHANNEL_ID = "channel"


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)
        setupBottomNavigation()
        mFirebase = FireBaseHelper(this)

        val viewPager: ViewPager = findViewById(R.id.timetable_viewpager)
        viewPager.adapter = TimeTableFragmentPagerAdapter(supportFragmentManager)


        val tabLayout: TabLayout = sliding_tabs
        tabLayout.setupWithViewPager(viewPager)
        val tabLTab = tabLayout.getTabAt(1)
        tabLTab!!.select()



            //уведомления
            /*createNotificationChannel()
            buildNotification()*/

    }

    private fun buildNotification() {
        val builder =
            NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_bse2)
                .setContentTitle("Напоминание")
                .setContentText("Пора покормить кота")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notificationManager =
            NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFY_ID, builder.build())
    }

    override fun onStart() {
        super.onStart()
        checkAuth()
    }

    private fun checkAuth () {
        if(mFirebase.auth.currentUser == null){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        } else {
            mFirebase.openApp()
            checkVersion()
        }
    }



    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Name"
            val descriptionText = "Descriptio"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }



    private val timeNow = System.currentTimeMillis()

    private fun weekDay(time: Long): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = time
        val numWeek = calendar.get(Calendar.DAY_OF_WEEK)
        return when (numWeek) {
            2 -> "monday"
            3 -> "tuesday"
            4 -> "wednesday"
            5 -> "thursday"
            6 -> "friday"
            7 -> "saturday"
            else -> "sunday"
        }
    }



    private fun checkVersion() {
        mFirebase.database.child("version").addListenerForSingleValueEvent(ValueEventListenerAdapter {

            if(!(stringVersion == it.value.toString()))
            {
                UpdateVersionDialogFragment(it.value.toString()).show(supportFragmentManager, "upd")
            }
        })
    }


}

class TimeTableFragmentPagerAdapter(fm: FragmentManager?) :
    FragmentPagerAdapter(fm!!) {
    val PAGE_COUNT = 3
    private val tabTitles =
        arrayOf("Нечетная неделя", "Сегодня", "Четная неделя")
    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getItem(position: Int): Fragment {

        return TimetableFragment.newInstance(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // генерируем заголовок в зависимости от позиции
        return tabTitles[position]
    }

}

class TimetableFragment : Fragment() {
    private var mPage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (getArguments() != null) {
            mPage = getArguments()!!.getInt(ARG_PAGE)
        }
    }

    val listRus = listOf(
        "понедельник",
        "вторник",
        "среда",
        "четверг",
        "пятница",
        "суббота"
    )

    val listts: List<String> = listOf(
        "monday",
        "tuesday",
        "wednesday",
        "thursday",
        "friday",
        "saturday"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val timetableCh = mutableListOf<TimetableWeek>()
        val timetableNech = mutableListOf<TimetableWeek>()
        val view: View
        val mFirebase = FireBaseHelper(activity!!)

        if (mPage == 1) {
            view = inflater.inflate(R.layout.fragment_timetable_now, container, false)
            view.day_of_week_now.text = weekDayRus()
            view.holiday_text.text = "Загрузка"
        }
        else {
            view = inflater.inflate(R.layout.fragment_timetable, container, false)
        }
        mFirebase.currentUserReference()
            .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                val mUser = it.getValue(User::class.java)!!
                mFirebase.database.child("timetable/${mUser.group}")
                    .addListenerForSingleValueEvent(ValueEventListenerAdapter {
                        for (pos in 0..5) {
                            val itemnch = it.child("нечет/" + listts[pos]).children.map {
                                it.getValue(TimetableItem::class.java)!!
                                    .copy(para = it.key)
                            }.sortedBy { it.para }
                            val itemch = it.child("чет/" + listts[pos]).children.map {
                                it.getValue(TimetableItem::class.java)!!
                                    .copy(para = it.key)
                            }.sortedBy { it.para }
                            if (itemnch.isNotEmpty()) timetableNech.add(
                                TimetableWeek(
                                    itemnch,
                                    listRus[pos]
                                )
                            )
                            if (itemnch.isNotEmpty()) timetableCh.add(
                                TimetableWeek(
                                    itemch,
                                    listRus[pos]
                                )
                            )
                        }
                        val timeDay = if (getDatetime().get(Calendar.DAY_OF_WEEK) == 1) 6 else getDatetime().get(Calendar.DAY_OF_WEEK) - 2
                        val itemNow = it.child(
                            "${
                            chetNechet(System.currentTimeMillis())}/${listts[getDatetime().get(
                                Calendar.DAY_OF_WEEK
                            ) - 2]}"
                        ).children.map {
                            it.getValue(TimetableItem::class.java)!!
                                .copy(para = it.key)
                        }.sortedBy {
                            it.para
                        }
                        if (mPage == 1) {
                            if (itemNow != null && itemNow.isNotEmpty()) {
                                view.holiday_view.visibility = View.INVISIBLE
                                view.holiday_text.visibility = View.INVISIBLE
                                view.res_timetable_id.adapter = TimetableItemAdapter(itemNow)
                                view.res_timetable_id.layoutManager =
                                    LinearLayoutManager(inflater.context)
                            } else view.holiday_text.text = "Выходной"
                        }
                        else if(mPage == 0) {
                            view.week_recycler.adapter = TimetableAdapter(timetableNech, inflater.context)
                            view.week_recycler.layoutManager = LinearLayoutManager(inflater.context)
                        }
                        else {
                            view.week_recycler.adapter = TimetableAdapter(timetableCh, inflater.context)
                            view.week_recycler.layoutManager = LinearLayoutManager(inflater.context)
                        }
                        //select today day of week
                        /*val timeOfWeek = calNow().get(Calendar.DAY_OF_WEEK) - 2
                            if(timeOfWeek < view.week_recycler.adapter!!.itemCount) {
                                view.week_recycler.smoothScrollToPosition(timeOfWeek)
                            }*/
                    })
            })
        return view
    }

    companion object {
        const val ARG_PAGE = "ARG_PAGE"
        fun newInstance(page: Int): TimetableFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val fragment = TimetableFragment()
            fragment.setArguments(args)
            return fragment
        }
    }
}

class TimetableAdapter (private val itemsT: List<TimetableWeek>, private val context: Context) :RecyclerView.Adapter<TimetableAdapter.ViewHolder>() {
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetableAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_week, parent, false)
        return ViewHolder(view)
    }



    override fun getItemCount(): Int = itemsT.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.day_of_week_now.text = itemsT[position].day
        holder.view.res_timetable_id.adapter = TimetableItemAdapter(itemsT[position].listTt!!)
        holder.view.res_timetable_id.layoutManager = LinearLayoutManager(context)
    }




}

class TimetableItemAdapter(private val itemsT: List<TimetableItem>) :RecyclerView.Adapter<TimetableItemAdapter.ViewHolder>() {
    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_timetable, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemsT.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.time_par.text = timeText(itemsT[position].para!!)
        holder.view.item_text.text = itemsT[position].item
        holder.view.cab_text.text = itemsT[position].cabinet
        holder.view.text_teacher.text = itemsT[position].teacher
    }

    private fun timeText(para: String): String {
        return when (para) {
            "1par" -> "8:00\n9:30"
            "2par" -> "9:40\n11:10"
            "3par" -> "11:20\n12:50"
            "4par" -> "13:00\n14:30"
            "5par" -> "14:40\n16:10"
            "6par" -> "16:20\n17:50"
            "7par" -> "18:00\n19:30"
            else -> "19:40\n21:10"
        }
    }

    private fun paraInd(para: String): Int {
        return when (para) {
            "1par" -> 0
            "2par" -> 1
            "3par" -> 2
            "4par" -> 3
            "5par" -> 4
            "6par" -> 5
            "7par" -> 6
            else -> 7
        }
    }
}