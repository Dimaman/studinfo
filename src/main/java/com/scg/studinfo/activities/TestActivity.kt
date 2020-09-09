package com.scg.studinfo.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.scg.studinfo.R
import com.scg.studinfo.models.Unity
import com.scg.studinfo.utils.FireBaseHelper
import com.tbuonomo.creativeviewpager.adapter.CreativePagerAdapter
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {
    private lateinit var mFirebase: FireBaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        mFirebase = FireBaseHelper(this)

        icon_back.setOnClickListener { finish() }

        mFirebase.uploadUnity {
            creativeViewPagerView.setCreativeViewPagerAdapter(UnityCreativeListAdapter(it, this))
        }
    }
}

class UnityCreativeListAdapter(private val lUnity: List<Unity>, private val context: Context) :
    CreativePagerAdapter {

    override fun instantiateHeaderItem(inflater: LayoutInflater, container: ViewGroup, position: Int): View {
        // Inflate page layout
        val headerRoot = inflater.inflate(R.layout.fragment_info_unity, container, false)

        // Bind the views
        val title: TextView = headerRoot.findViewById(R.id.name_unity)
        val text: TextView = headerRoot.findViewById(R.id.text_unity)
        val image: ImageView = headerRoot.findViewById(R.id.main_image_unity)

        image.clipToOutline = true
        title.text = lUnity[position].name
        text.text = lUnity[position].text
        image.loadCircleImage(lUnity[position].imgmain)


        return headerRoot
    }

    override fun instantiateContentItem(inflater: LayoutInflater, container: ViewGroup, position: Int): View {
        // Inflate the header view layout
        val contentRoot = inflater.inflate(R.layout.fragment_img_unity, container,
            false)

        // Bind the views
        val imageView = contentRoot.findViewById<ImageView>(R.id.up_image_unity)

        imageView.loadCircleImage(lUnity[position].img)
        return contentRoot
    }

    override fun getCount(): Int = lUnity.size

}
