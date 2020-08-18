package com.scg.studinfo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.scg.studinfo.R
import com.scg.studinfo.models.Unity
import com.scg.studinfo.utils.FireBaseHelper
import kotlinx.android.synthetic.main.activity_list_unity_at_activ.*

class ListUnityAtActivActivity : AppCompatActivity(), UnityListAdapter.Listener {
    private lateinit var mFirebase: FireBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_unity_at_activ)

        mFirebase = FireBaseHelper(this)

        icon_back.setOnClickListener { finish() }

        mFirebase.currentUserReference().addListenerForSingleValueEvent(ValueEventListenerAdapter{
            val user = mFirebase.getUser(it)
            mFirebase.uploadUnity {
                val endList = mutableListOf<Unity>()
                for (item in user.unity!!){
                    for (unit in it) {
                        if(item == unit.uid)
                            endList.add(unit)
                    }
                }
                unity_resycle.adapter = UnityListAdapter(endList, this)
                unity_resycle.layoutManager = LinearLayoutManager(this)
            }
        })
    }

    override fun loadUnity(unity: Unity) {
        /*Ничего*/
    }

    override fun loadUnityActiv(pos: Int) {
        selUnityActiv = pos
        finish()
    }
}
