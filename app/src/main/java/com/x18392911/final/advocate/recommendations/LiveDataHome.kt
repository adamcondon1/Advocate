package com.x18392911.final.advocate.recommendations

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.x18392911.final.advocate.MainAPIActivity
import com.x18392911.final.advocate.recommendations.R

class LiveDataHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_home)

        //home page with buttons to navigate to livedata
        var Popular = findViewById(R.id.btnPopular) as Button
        var TopRated = findViewById(R.id.btnTopRated) as Button
        var Upcoming = findViewById(R.id.btnUpcoming) as Button
        var Tip = findViewById(R.id.btnPay) as Button




        Popular.setOnClickListener {
            val intent = Intent  (this, MainAPIActivity::class.java)
            startActivity(intent)
        }

        TopRated.setOnClickListener {
            val intent = Intent  (this, MainAPIActivity2::class.java)
            startActivity(intent)
        }

        Upcoming.setOnClickListener {
            val intent = Intent  (this, MainAPIActivity3::class.java)
            startActivity(intent)
        }

        Tip.setOnClickListener {
            val intent = Intent  (this, Payement::class.java)
            startActivity(intent)
        }
    }
}