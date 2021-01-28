package com.yangPentingLulus.DCEMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    auth = Firebase.auth

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

            auth.signInWithEmailAndPassword(emailUser, passwordUser)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val moveWithDataIntent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(moveWithDataIntent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Login Gagal",
                            Toast.LENGTH_SHORT).show()

                    }

                }

        }
    }
}