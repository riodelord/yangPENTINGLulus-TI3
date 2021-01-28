package com.yangPentingLulus.DCEMS

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class SplashScreenActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth?.currentUser
        Handler(Looper.getMainLooper()).postDelayed({

            if (currentUser != null) {
                startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            }
            else {
                startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
            }
            finish()
        }, 3000)
    }
}