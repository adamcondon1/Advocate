package com.x18392911.final.advocate.recommendations

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.x18392911.final.advocate.recommendations.R


class Payement : AppCompatActivity() {

//Button to pay with Google Pay and gateway api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payement)

        var Pay = findViewById(R.id.btnSuccess) as Button

        Pay.setOnClickListener {
            val intent = Intent  (this, SuccessActivity::class.java)
            startActivity(intent)
        }
    }
}