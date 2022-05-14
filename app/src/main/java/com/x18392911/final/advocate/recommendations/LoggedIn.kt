package com.x18392911.final.advocate.recommendations

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.x18392911.final.advocate.recommendations.Cart.MainActivity4
import com.x18392911.final.advocate.recommendations.R
import com.x18392911.final.advocate.ui.MapsActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_logged_in.*

/**
 * The main app dashboard used to navigate to all other activities
 */
class LoggedIn : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)

        //Buttons for Activities go here

        btnRecommendations.setOnClickListener {
            val intent = Intent  (this, MainActivity::class.java)
            startActivity(intent)
        }

        btnProfile.setOnClickListener {
            val intent = Intent  (this, Profile::class.java)
            startActivity(intent)
        }

        btnMaps.setOnClickListener {
            val intent = Intent  (this, MapsActivity::class.java)
            startActivity(intent)
        }

        btnLiveData.setOnClickListener {
            val intent = Intent  (this, LiveDataHome::class.java)
            startActivity(intent)
        }

        btnMovies.setOnClickListener {
            val intent = Intent  (this, Movies::class.java)
            startActivity(intent)
        }

        btnFree.setOnClickListener {
            val intent = Intent  (this, MainActivity4::class.java)
            startActivity(intent)
        }

        val sharedPref=this?.getPreferences(Context.MODE_PRIVATE)?:return
        logout.setOnClickListener {
            sharedPref.edit().remove("Email").apply()
            var intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}