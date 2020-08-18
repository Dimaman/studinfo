package com.scg.studinfo.views

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.scg.studinfo.R
import kotlinx.android.synthetic.main.dialog_pass.view.*

class PasswordDialog : DialogFragment() {
    private lateinit var mListener: Listener

    interface Listener {
        fun onPassConfim(pass: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as Listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity!!.layoutInflater.inflate(R.layout.dialog_pass, null)
        return AlertDialog.Builder(context).setView(view)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                mListener.onPassConfim(view.d_pass_input.text.toString())
            }
            .setNegativeButton(android.R.string.cancel, null)
            .setTitle("Введите ваш пароль")
            .create()
    }
}