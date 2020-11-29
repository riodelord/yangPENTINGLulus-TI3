package com.yangPentingLulus.DCEMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        fun printState(msg: String){
            Log.d("ActivityState",msg)
            Toast.makeText(applicationContext,msg, Toast. LENGTH_SHORT).show()
        }
        btnLogin.setOnClickListener{
            val emailUser = email_field.editText?.text.toString()
            val passwordUser = password_field.editText?.text.toString()
            if (emailUser.isEmpty()) {
                email_field.error = "Email Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (passwordUser.isEmpty()) {
                password_field.error = "Password Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(emailUser=="admin@gmail.com" && passwordUser=="admin"){
                val moveWithDataIntent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(moveWithDataIntent)
            }
            else{
                printState("Email/Password yang dimasukan salah")
            }
        }
    }
}