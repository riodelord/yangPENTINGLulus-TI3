package com.yangPentingLulus.DCEMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_user.*
import kotlinx.android.synthetic.main.activity_login.*

class AddUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        fun printState(msg: String){
            Log.d("ActivityState",msg)
            Toast.makeText(applicationContext,msg, Toast. LENGTH_SHORT).show()
        }
        btnAdd.setOnClickListener{
            val usernameUser = adduser_username_field.editText?.text.toString()
            val emailUser = adduser_email_field.editText?.text.toString()
            val passwordUser = adduser_password_field.editText?.text.toString()
            if (usernameUser.isEmpty()) {
                adduser_username_field.error = "Username Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (emailUser.isEmpty()) {
                adduser_email_field.error = "Email Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (passwordUser.isEmpty()) {
                adduser_password_field.error = "Password Tidak Boleh Kosong"
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