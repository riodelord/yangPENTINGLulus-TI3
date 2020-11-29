package com.yangPentingLulus.DCEMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_user.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.inputEmail
import kotlinx.android.synthetic.main.activity_login.inputPassword

class AddUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        fun printState(msg: String){
            Log.d("ActivityState",msg)
            Toast.makeText(applicationContext,msg, Toast. LENGTH_SHORT).show()
        }
        btnAdd.setOnClickListener{
            val usernameUser = inputUsername.text.toString()
            val emailUser = inputPassword.text.toString()
            val passwordUser = inputEmail.text.toString()
            if (usernameUser.isEmpty()) {
                inputUsername.error = "Username Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (emailUser.isEmpty()) {
                inputEmail.error = "Email Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (passwordUser.isEmpty()) {
                inputPassword.error = "Password Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if(usernameUser=="admin" && emailUser=="admin@gmail.com") {
                fun printState(msg: String) {
                    Log.d("ActivityState", msg)
                    Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
                    printState("User/Email sudah terdaftar")
                }
            }
            printState("User Berhasil Ditambahkan")
            val moveWithDataIntent = Intent(this@AddUserActivity, LoginActivity::class.java)
            startActivity(moveWithDataIntent)
        }
        btnCancel.setOnClickListener{
            val moveWithDataIntent = Intent(this@AddUserActivity, ConfigActivity::class.java)
            startActivity(moveWithDataIntent)
        }
    }
}