package com.scg.studinfo.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.scg.studinfo.R
import com.scg.studinfo.models.User
import kotlinx.android.synthetic.main.fragment_registry_email.*
import kotlinx.android.synthetic.main.fragment_registry_pass.*

class RegisterActivity : AppCompatActivity(), EmailFragment.Listener, PassFragment.Listener {
    private var mEmail: String? = null
    private lateinit var mAuth : FirebaseAuth
    private lateinit var mDB: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        mDB = FirebaseDatabase.getInstance().reference

        if(savedInstanceState == null)
        supportFragmentManager.beginTransaction().add(R.id.frame_layout, EmailFragment()).commit()
    }

    override fun onNext(email: String) {
        if (email.isNotEmpty()) {
            mEmail = email
            mAuth.fetchSignInMethodsForEmail(email).addOnCompleteListener{
                if(it.isSuccessful) {
                    if(it.result!!.signInMethods?.isEmpty() != false) {
                        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, PassFragment())
                            .addToBackStack(null)
                            .commit()
                    } else {
                        showToast("Этот Email уже зарегестрирован")
                    }
                } else {
                    showToast("Произошло что-то страшное, повторите позже")
                }
            }

        } else {
            showToast("Введите email")
        }
    }

    override fun onReg(pass: String, pass2: String) {

        if(pass.isNotEmpty() && pass == pass2){
            val email = mEmail
            if (email != null) {
                mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            val user = User(email = email)
                            val reference = mDB.child("users")
                                .child(it.result!!.user!!.uid)
                            reference.setValue(user)
                                .addOnCompleteListener {
                                    if (it.isSuccessful) {
                                        startActivity(Intent(this,
                                            AddInfoActivity::class.java))
                                        finish()
                                    } else {
                                        showToast("Произошло что-то страшное, повторите позже")
                                    }
                                }
                        } else {
                            showToast("Произошло что-то страшное, повторите позже")
                        }
                    }
            }
        } else {
            showToast("Введите корректный пароль")
        }
    }
}

//1 - Email, next btn
class EmailFragment: Fragment() {
    private lateinit var mListener: Listener

    interface Listener {
        fun onNext (email: String)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_registry_email, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        coordinateBtnAndInputs(next_btn, email_input)
        next_btn.setOnClickListener{
            val email = email_input.text.toString()
            mListener.onNext(email)
        }
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as Listener
    }
}

//2 - password, correctred password, register button
class PassFragment : Fragment() {
    private lateinit var mListener: Listener

    interface Listener {
        fun onReg (pass: String, pass2: String)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_registry_pass, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        coordinateBtnAndInputs(reg_btn, pass_input, con_pass_input)
        reg_btn.setOnClickListener {
            reg_btn.isEnabled = false
            val pass = pass_input.text.toString()
            val pass2 = con_pass_input.text.toString()
            mListener.onReg(pass, pass2)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as Listener
    }
}