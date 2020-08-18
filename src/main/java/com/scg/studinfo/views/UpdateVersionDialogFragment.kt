package com.scg.studinfo.views

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class UpdateVersionDialogFragment(private val str: String) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the Builder class for convenient dialog construction
        val builder: AlertDialog.Builder =
            AlertDialog.Builder(activity)
        builder.setMessage("Вышла новая версия $str")
            .setPositiveButton("Скачать",
                DialogInterface.OnClickListener { _, _ ->
                    val playMarket = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.scg.studinfo")
                    )
                    startActivity(playMarket)
                    activity!!.finish()
                })
            .setNegativeButton("Выйти",
                DialogInterface.OnClickListener { _, _ ->
                    activity!!.finish()
                })
        // Create the AlertDialog object and return it
        return builder.create()
    }
}