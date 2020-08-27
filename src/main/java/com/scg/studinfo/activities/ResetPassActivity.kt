package com.scg.studinfo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scg.studinfo.R
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_reset_pass.*

class ResetPassActivity : AppCompatActivity() {
    private lateinit var mFirebase: FireBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pass)

        mFirebase = FireBaseHelper(this)

        coordinateBtnAndInputs(reset_pass, email_input)

        reset_pass.setOnClickListener {
            mFirebase.auth.sendPasswordResetEmail(email_input.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        showToast("На вашу почту пришло письмо с дальнейшими указаниями")
                        finish()
                    } else {
                        showToast("Произошла ошибка, возможно вы неправильно написали email")
                    }
                }
        }
    }
}