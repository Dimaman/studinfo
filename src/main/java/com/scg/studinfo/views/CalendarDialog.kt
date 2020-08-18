package com.scg.studinfo.views

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.scg.studinfo.R
import kotlinx.android.synthetic.main.dialog_calendar.view.*
import ru.cleverpumpkin.calendar.CalendarView
import java.util.*


class CalendarDialog : DialogFragment() {

    private lateinit var mListenerCalendar: ListenerCalendar

    interface ListenerCalendar {
        fun onTimeConfim(selectedDate: Long?)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListenerCalendar = context as ListenerCalendar
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity!!.layoutInflater.inflate(R.layout.dialog_calendar, null)
        view.calendar_view.setupCalendar(
            selectionMode = CalendarView.SelectionMode.SINGLE,
            firstDayOfWeek = Calendar.MONDAY

        )
        return AlertDialog.Builder(context).setView(view)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                mListenerCalendar.onTimeConfim(view.calendar_view.selectedDate?.timeInMillis)
            }
            .setNegativeButton(android.R.string.cancel, null)
            .create()
    }
    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        if (savedInstanceState == null) {
            calendar_view.setupCalendar(selectionMode = CalendarView.SelectionMode.SINGLE)
        }
    }*/
}

