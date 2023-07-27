package com.christianjcodes.readingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var username: EditText? = null
    var password: EditText? = null
    var repassword: EditText? = null
    var signup: Button? = null
    var signin: Button? = null
    var DB: DBHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        username = findViewById<View>(R.id.username) as EditText
        password = findViewById<View>(R.id.password) as EditText
        repassword = findViewById<View>(R.id.repassword) as EditText
        signup = findViewById<View>(R.id.signupbtn) as Button
        signin = findViewById<View>(R.id.signinbtn) as Button
        DB = DBHandler(this)

        signup!!.setOnClickListener {
            val user = username!!.text.toString()
            val pass = password!!.text.toString()
            val repass = repassword!!.text.toString()

            if (user == "" || pass == "" || repass == "") {
                Toast.makeText(this@MainActivity, "Please fill out all the fields!", Toast.LENGTH_SHORT).show()
            } else if (pass == repass) {
                val checkUser = DB!!.checkUsername(user)
                if (!checkUser) {
                    val insert = DB!!.insertData(user, pass)
                    if (insert) {
                        Toast.makeText(this@MainActivity, "Registration successful!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@MainActivity, "Registration failed.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "User already exists! Please sign in.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@MainActivity, "Passwords do not match.", Toast.LENGTH_SHORT).show()
            }
        }
        signin!!.setOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}