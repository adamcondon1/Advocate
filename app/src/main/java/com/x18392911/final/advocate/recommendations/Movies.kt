package com.x18392911.final.advocate.recommendations

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.x18392911.final.advocate.recommendations.R

class Movies : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        //Free Movies and their links
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
        val Movie11 = findViewById(R.id.btnMovie11) as Button
        val Movie12 = findViewById(R.id.btnMovie12) as Button
        val Movie13 = findViewById(R.id.btnMovie13) as Button
        val Movie14 = findViewById(R.id.btnMovie14) as Button
        val Movie15 = findViewById(R.id.btnMovie15) as Button
        val Movie16 = findViewById(R.id.btnMovie16) as Button
        val Movie17 = findViewById(R.id.btnMovie17) as Button
        val Movie18 = findViewById(R.id.btnMovie18) as Button
        val Movie19 = findViewById(R.id.btnMovie19) as Button
        val Movie20 = findViewById(R.id.btnMovie20) as Button
        val Movie21 = findViewById(R.id.btnMovie21) as Button
        val Movie22 = findViewById(R.id.btnMovie22) as Button
        val Movie23 = findViewById(R.id.btnMovie23) as Button
        val Movie24 = findViewById(R.id.btnMovie24) as Button
        val Movie25 = findViewById(R.id.btnMovie25) as Button
        val Movie26 = findViewById(R.id.btnMovie26) as Button
        val Movie27 = findViewById(R.id.btnMovie27) as Button
        val Movie28 = findViewById(R.id.btnMovie28) as Button
        val Movie29 = findViewById(R.id.btnMovie29) as Button
        val Movie30 = findViewById(R.id.btnMovie30) as Button



        Movie1.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=bDw-t5LwpXY&t=1394s"))
            startActivity(i)
        }

        Movie2.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Ehx6KiOVnjo"))
            startActivity(i)
        }

        Movie3.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=I59dVwteOfk&list=PL789B81DCFC1DE7A5&index=37"))
            startActivity(i)
        }
        Movie4.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=c1V16fXXAlA&list=PL789B81DCFC1DE7A5"))
            startActivity(i)
        }
        Movie5.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=j15eR-8vTl8&list=PL789B81DCFC1DE7A5&index=1"))
            startActivity(i)
        }
        Movie6.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=bofqQpTBu-I&list=PL789B81DCFC1DE7A5&index=3"))
            startActivity(i)
        }
        Movie7.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=DOflWHrLDBg"))
            startActivity(i)
        }
        Movie8.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=WpXHdqfsoVk"))
            startActivity(i)
        }
        Movie9.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=1q9NtNIINDA&list=PL789B81DCFC1DE7A5&index=9"))
            startActivity(i)
        }
        Movie10.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=_4qGvck4vpc&list=PL789B81DCFC1DE7A5&index=43"))
            startActivity(i)
        }
        Movie11.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=tRz7tFm28OE&list=PL789B81DCFC1DE7A5&index=52"))
            startActivity(i)
        }
        Movie12.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=lrSJ00DHuCM&list=PL789B81DCFC1DE7A5&index=54"))
            startActivity(i)
        }
        Movie13.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=FOaO4VEeqt4&list=PL789B81DCFC1DE7A5&index=55"))
            startActivity(i)
        }
        Movie14.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Gd7p7R5Q8Pw&list=PL789B81DCFC1DE7A5&index=59"))
            startActivity(i)
        }
        Movie15.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=2JHRR8t-s8s&list=PL789B81DCFC1DE7A5&index=58"))
            startActivity(i)
        }
        Movie16.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=va1lL_P1hUM&list=PL789B81DCFC1DE7A5&index=60"))
            startActivity(i)
        }
        Movie17.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=5w66mhN9iWw&list=PL789B81DCFC1DE7A5&index=88"))
            startActivity(i)
        }
        Movie18.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ImcUsUJwEzs&list=PL789B81DCFC1DE7A5&index=102"))
            startActivity(i)
        }
        Movie19.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Zqzn7KzOO3M&list=PL789B81DCFC1DE7A5&index=136"))
            startActivity(i)
        }
        Movie20.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=c25oZQrnXwc&list=PL789B81DCFC1DE7A5&index=160"))
            startActivity(i)
        }
        Movie21.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=VW4eGOO0jcQ"))
            startActivity(i)
        }
        Movie22.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=3t-amYRZXFM"))
            startActivity(i)
        }
        Movie23.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=RlfbRpZvT70"))
            startActivity(i)
        }
        Movie24.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=TT1txYFx-KI"))
            startActivity(i)
        }
        Movie25.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=l96oZJXXQkc&list=PLvxoVTAZ1duHy119gnyDHgWf04NpIcnaq"))
            startActivity(i)
        }
        Movie26.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=PCYLHTrZ_Z4"))
            startActivity(i)
        }
        Movie27.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=giE-U4zwPZU"))
            startActivity(i)
        }
        Movie28.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=59HHubgggRU"))
            startActivity(i)
        }
        Movie29.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=Xl1KWaOsDsc"))
            startActivity(i)
        }
        Movie30.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ha6NOfK_800" +
                    ""))
            startActivity(i)
        }
    }
}
