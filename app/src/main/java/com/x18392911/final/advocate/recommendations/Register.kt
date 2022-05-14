package com.x18392911.final.advocate.recommendations

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.x18392911.final.advocate.recommendations.utils.Sqlite_Database
import com.x18392911.final.advocate.recommendations.R
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    //vars
    var name: String = ""
    var email: String = ""
    var pasword: String = ""

    //sql lite dec
    var dbHandler  = Sqlite_Database(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        var nameEdit = findViewById(R.id.NameRegister)as EditText
        var emailEdit = findViewById(R.id.EmailRegister) as EditText
        var passEdit = findViewById(R.id.PasswordRegister) as EditText
        var RegisterBtn = findViewById(R.id.RegisterBtn) as Button
        var LoginBtn = findViewById(R.id.LoginBtn) as Button

        LoginBtn.setOnClickListener {
            val intent = Intent  (this, LoginScreen::class.java)
            startActivity(intent)
        }

        RegisterBtn.setOnClickListener()
        {

            name = nameEdit.text.toString()
            email = emailEdit.text.toString()
            pasword = passEdit.text.toString()

            //adding restrictions for valid email
            //preventing sql injection and getting good data into tables
            if (name.isEmpty())
            {
                nameEdit.setError("Enter Name")
                return@setOnClickListener
            }
            else if (email.isEmpty())
            {
                emailEdit.setError("Enter Email")
                return@setOnClickListener
            }
            else if (pasword.isEmpty())
            {
                passEdit.setError("Enter Password")
                return@setOnClickListener
            }
            if (email.contains("#$!?~}{)(£%")){
                emailEdit.setError("Remove Potential Malicous Symbols")
                return@setOnClickListener
            }

            if (pasword.length < 6) {
                passEdit.setError("Password must be at least 6 characters")
                return@setOnClickListener
            }

            Log.d("Register", "name: " + name)
            Log.d("Register", "email: " + email)
            Log.d("Register", "pass: " + pasword)

            dbHandler.addUser(UserModel(name, email, pasword))

            Toast.makeText(applicationContext, "User Registered", Toast.LENGTH_SHORT).show()


        }

    }
}
