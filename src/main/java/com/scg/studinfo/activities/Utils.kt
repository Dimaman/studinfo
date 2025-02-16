package com.scg.studinfo.activities

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.graphics.Bitmap
import android.icu.util.Calendar
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.scg.studinfo.R
import com.scg.studinfo.models.Unity


class ValueEventListenerAdapter(val handler: (DataSnapshot) -> Unit) : ValueEventListener {
    override fun onCancelled(p0: DatabaseError) {

    }

    override fun onDataChange(data: DataSnapshot) {
        handler(data)
    }
}

@GlideModule
class CustomGlideModule : AppGlideModule()

fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}


const val stringVersion = "1.1.17"

//Сохраненные данные
val PERSON_INFO = "PERSON_INFO"
val APP_PREFERENCES = "mysettings"

val personGroup = "person_group"
val personFac = "person_fac"
val personKey = "person_key"

fun getStrSaveSetting(): MutableList<String> {
    val strCache = mutableListOf<String>()
    strCache.add(0, "ch_box_razv")
    strCache.add(1, "ch_box_nauka")
    strCache.add(2, "ch_box_sport")
    strCache.add(3, "ch_box_tvor")
    strCache.add(4, "ch_box_work")
    strCache.add(5, "ch_box_days")
    return strCache
}
fun getSaveSetting(activity: Activity): MutableList<Boolean> {
    val pref = activity.getSharedPreferences("mysettings", MODE_PRIVATE)

    val cache = mutableListOf<Boolean>()
    cache.add(pref.getBoolean(getStrSaveSetting()[0], false))
    cache.add(pref.getBoolean(getStrSaveSetting()[1], false))
    cache.add(pref.getBoolean(getStrSaveSetting()[2], false))
    cache.add(pref.getBoolean(getStrSaveSetting()[3], false))
    cache.add(pref.getBoolean(getStrSaveSetting()[4], false))
    cache.add(pref.getBoolean(getStrSaveSetting()[5], false))
    return cache
}

//загрузка новостей
var itemNews: String? = null
var imageNews: Bitmap? = null
val listFac = arrayListOf(
    "ИНГЭ",
    "ИКСиИБ",
    "ИПиПП",
    "ИЭУБ",
    "ИСТИ",
    "ИМА",
    "ИТК")
var selUnityActiv = 0
var selUnity: Unity? = null

//добавление объединения
var usersAtUnity = mutableListOf<String>()

fun getDatetime(): Calendar {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = System.currentTimeMillis()
    return calendar
}
fun getDatetime(time: Long): Calendar {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = time
    return calendar
}

fun weekDayRus(time: Long): String {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = time
    val firstPart = when (calendar.get(Calendar.DAY_OF_WEEK)) {
        2 -> "понедельник"
        3 -> "вторник"
        4 -> "среда"
        5 -> "четверг"
        6 -> "пятница"
        7 -> "суббота"
        else -> "воскресенье"
    }
    val secondPart = calendar.get(Calendar.DAY_OF_MONTH)
    val thirdPart = when (calendar.get(Calendar.MONTH)) {
        0 -> "января"
        1 -> "февраля"
        2 -> "марта"
        3 -> "апреля"
        4 -> "мая"
        5 -> "июня"
        6 -> "июля"
        7 -> "августа"
        8 -> "сентября"
        9 -> "октября"
        10 -> "ноября"
        else -> "декабря"
    }
    return "$firstPart, $secondPart $thirdPart"
}

fun validateBtn (text1: String, text2: String) = text1.isNotEmpty() && text2.isNotEmpty()
fun validateBtn (text1: String) = text1.isNotEmpty()

fun coordinateBtnAndInputs(btn: Button, vararg inputs : EditText) {
    val watcher = object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            btn.isEnabled = inputs.all { it.text.isNotEmpty() }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }
    inputs.forEach { it.addTextChangedListener(watcher) }
    btn.isEnabled = inputs.all { it.text.isNotEmpty() }
}

fun ImageView.loadCircleImage(photoUrl: String?){
    if(!(context as Activity).isDestroyed)
        GlideApp.with(this).load(photoUrl).fallback(R.drawable.reg_icon).into(this)
}

fun ImageView.loadImage(image: String, centr: Boolean) {
    if(centr){
        GlideApp.with(this).load(image).centerCrop().into(this)
    }
    else{
        GlideApp.with(this).load(image).into(this)
    }
}

fun Editable.toStringOrNull(): String? {
    val str = toString()
    return if(str.isEmpty()) null else str
}

fun showPopup(context: Context, view: View, menu: Int): PopupMenu {
    val popup = PopupMenu(context, view)
    popup.menuInflater.inflate(menu, popup.menu)
    popup.show()
    return popup
}