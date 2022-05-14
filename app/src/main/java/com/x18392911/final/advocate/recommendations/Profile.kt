package com.x18392911.final.advocate.recommendations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.x18392911.final.advocate.recommendations.R

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val username = intent.getStringExtra("USERNAME")
        val password = intent.getStringExtra("PASSWORD")


    }
}