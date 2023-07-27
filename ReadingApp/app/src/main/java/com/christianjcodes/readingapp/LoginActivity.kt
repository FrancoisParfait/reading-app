package com.christianjcodes.readingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    var username: EditText? = null
    var password: EditText? = null
    var loginbtn: Button? = null
    var dB: DBHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        username = findViewById<View>(R.id.username1) as EditText
        password = findViewById<View>(R.id.password1) as EditText
        loginbtn = findViewById<View>(R.id.signinbtn1) as Button
        dB = DBHandler(this)

        loginbtn!!.setOnClickListener {
            val user = username!!.text.toString()
            val pass = password!!.text.toString()
            if (user == "" || pass == "") {
                Toast.makeText(this@LoginActivity, "Please fill out all the fields!", Toast.LENGTH_SHORT).show()
            } else {
                val checkUserPass = dB!!.checkUsernamePassword(user, pass)
                if (checkUserPass) {
                    Toast.makeText(this@LoginActivity, "Sign in successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LoginActivity, "Invalid login.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}