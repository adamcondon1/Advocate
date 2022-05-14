package com.x18392911.final.advocate.freerecommendations

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.x18392911.final.advocate.recommendations.R


class HomeRecommendations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_recommendations)

        val Movie1 = findViewById(R.id.btnMovie1) as Button
        val Movie2 = findViewById(R.id.btnMovie2) as Button
        val Movie3 = findViewById(R.id.btnMovie3) as Button
        val Movie4 = findViewById(R.id.btnMovie4) as Button
        val Movie5 = findViewById(R.id.btnMovie5) as Button
        val Movie6 = findViewById(R.id.btnMovie6) as Button
        val Movie7 = findViewById(R.id.btnMovie7) as Button
        val Movie8 = findViewById(R.id.btnMovie8) as Button
        val Movie9 = findViewById(R.id.btnMovie9) as Button
        val Movie10 = findViewById(R.id.btnMovie10) as Button
        val Dislike1 = findViewById(R.id.dislike1) as Button
        val Dislike2 = findViewById(R.id.btndMovie2) as Button
        val Dislike3 = findViewById(R.id.btndMovie3) as Button
        val Dislike4 = findViewById(R.id.btndMovie4) as Button
        val Dislike5 = findViewById(R.id.btndMovie5) as Button
        val Dislike6 = findViewById(R.id.btndMovie6) as Button
        val Dislike7 = findViewById(R.id.btndMovie7) as Button
        val Dislike8 = findViewById(R.id.btndMovie8) as Button
        val Dislike9 = findViewById(R.id.btndMovie9) as Button
        val Dislike10 = findViewById(R.id.btndMovie10) as Button

        Movie1.setOnClickListener {
            val intent = Intent  (this, CrimeRecommendations::class.java)
            startActivity(intent)
        }

        Dislike1.setOnClickListener(View.OnClickListener {
            Movie1.visibility = View.GONE
            Dislike1.visibility = View.GONE
        })

        Movie2.setOnClickListener {
            val intent = Intent  (this, ActionRecommendations::class.java)
            startActivity(intent)
        }

        Dislike2.setOnClickListener(View.OnClickListener {
            Movie2.visibility = View.GONE
            Dislike2.visibility = View.GONE
        })

        Movie3.setOnClickListener {
            val intent = Intent  (this, FamilyRecommendations::class.java)
            startActivity(intent)
        }

        Dislike3.setOnClickListener(View.OnClickListener {
            Movie3.visibility = View.GONE
            Dislike3.visibility = View.GONE
        })

        Movie4.setOnClickListener {
            val intent = Intent  (this, RomanceRecommendations::class.java)
            startActivity(intent)
        }

        Dislike4.setOnClickListener(View.OnClickListener {
            Movie4.visibility = View.GONE
            Dislike4.visibility = View.GONE
        })

        Movie5.setOnClickListener {
            val intent = Intent  (this, ThrillerRecommendations::class.java)
            startActivity(intent)
        }

        Dislike5.setOnClickListener(View.OnClickListener {
            Movie5.visibility = View.GONE
            Dislike5.visibility = View.GONE
        })

        Movie6.setOnClickListener {
            val intent = Intent  (this, DramaRecommendation::class.java)
            startActivity(intent)
        }

        Dislike6.setOnClickListener(View.OnClickListener {
            Movie7.visibility = View.GONE
            Dislike7.visibility = View.GONE
        })

        Movie7.setOnClickListener {
            val intent = Intent  (this, MusicRecommendations::class.java)
            startActivity(intent)
        }

        Dislike7.setOnClickListener(View.OnClickListener {
            Movie7.visibility = View.GONE
            Dislike7.visibility = View.GONE
        })

        Movie8.setOnClickListener {
            val intent = Intent  (this, ComedyRecommendations::class.java)
            startActivity(intent)
        }

        Dislike8.setOnClickListener(View.OnClickListener {
            Movie8.visibility = View.GONE
            Dislike8.visibility = View.GONE
        })

        Movie9.setOnClickListener {
            val intent = Intent  (this, HorrorRecommendations::class.java)
            startActivity(intent)
        }

        Dislike9.setOnClickListener(View.OnClickListener {
            Movie9.visibility = View.GONE
            Dislike9.visibility = View.GONE
        })

        Movie10.setOnClickListener {
            val intent = Intent  (this, HistoryRecommendatons::class.java)
            startActivity(intent)
        }

        Dislike10.setOnClickListener(View.OnClickListener {
            Movie10.visibility = View.GONE
            Dislike10.visibility = View.GONE
        })

    }
}