package com.yangPentingLulus.DCEMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_add_user.*
import kotlinx.android.synthetic.main.activity_login.*

class AddUserActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        fun printState(msg: String){
            Log.d("ActivityState",msg)
            Toast.makeText(applicationContext,msg, Toast. LENGTH_SHORT).show()
        }
        btnAdd.setOnClickListener{
            val emailUser = adduser_email_field.editText?.text.toString()
            val passwordUser = adduser_password_field.editText?.text.toString()

            if (emailUser.isEmpty()) {
                adduser_email_field.error = "Email Tidak Boleh Kosong"
                return@setOnClickListener
            }
            if (passwordUser.isEmpty()) {
                adduser_password_field.error = "Password Tidak Boleh Kosong"
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(emailUser, passwordUser)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(baseContext, "Berhasil Menambahkan User.",
                            Toast.LENGTH_SHORT).show()
                        val moveWithDataIntent = Intent(this@AddUserActivity, ConfigActivity::class.java)
                        startActivity(moveWithDataIntent)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Gagal Menambahkan User.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
        btnCancel.setOnClickListener{
            val moveWithDataIntent = Intent(this@AddUserActivity, ConfigActivity::class.java)
            startActivity(moveWithDataIntent)
        }
    }
}