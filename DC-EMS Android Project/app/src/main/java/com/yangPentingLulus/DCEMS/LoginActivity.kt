package com.yangPentingLulus.DCEMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener{
            val emailUser = inputEmail.text.toString()
            val PasswordUser = inputPassword.text.toString()
            if (emailUser.isEmpty()) {
                inputEmail.error = "Email Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (PasswordUser.isEmpty()) {
                inputPassword.error = "Password Tidak Boleh Kosong"
                return@setOnClickListener
            }
            val moveWithDataIntent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(moveWithDataIntent)
        }
    }
}