package com.christianjcodes.readingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {
    var dashboard: CardView? = null
    var currentReads: CardView? = null
    var completedReads: CardView? = null
    var readingList: CardView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        dashboard = findViewById<View>(R.id.my_dashboard) as CardView
        currentReads = findViewById<View>(R.id.current_reads) as CardView
        completedReads = findViewById<View>(R.id.completed_reads) as CardView
        readingList = findViewById<View>(R.id.reading_list) as CardView

        dashboard!!.setOnClickListener {
            val intent = Intent(applicationContext, DashActivity::class.java)
            startActivity(intent)
        }
        currentReads!!.setOnClickListener {
            val intent = Intent(applicationContext, CurrentReadsActivity::class.java)
            startActivity(intent)
        }
        completedReads!!.setOnClickListener {
            val intent = Intent(applicationContext, CompletedReadsActivity::class.java)
            startActivity(intent)
        }
        readingList!!.setOnClickListener {
            val intent = Intent(applicationContext, ReadingListActivity::class.java)
            startActivity(intent)
        }
    }
}