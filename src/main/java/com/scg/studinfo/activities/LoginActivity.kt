package com.scg.studinfo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.google.firebase.auth.FirebaseAuth
import com.scg.studinfo.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        coordinateBtnAndInputs(login_btn, email_input, password_input)
        registration_btn.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        view_pass.setOnClickListener {
            view_pass.isSelected = !view_pass.isSelected
            if (view_pass.isSelected) password_input.inputType = EditorInfo.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            if (!view_pass.isSelected) password_input.inputType = EditorInfo.TYPE_TEXT_VARIATION_PASSWORD + 1
        }

        login_btn.setOnClickListener{
            login_btn.isEnabled = false
            registration_btn.isEnabled = false
            val email = email_input.text.toString()
            val pass = password_input.text.toString()
            if(validateBtn(email_input.text.toString(), password_input.text.toString())) {
                mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if(it.isSuccessful){
                        startActivity(Intent(this, TimetableActivity::class.java))
                        finish()
                    }
                }
            } else {
                showToast("Введите email и пароль")
                login_btn.isEnabled = true
                registration_btn.isEnabled = true
            }
        }

        mAuth = FirebaseAuth.getInstance()
    }


}
