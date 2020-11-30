package com.yangPentingLulus.DCEMS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yangPentingLulus.DCEMS.activities.MapsActivity
import kotlinx.android.synthetic.main.activity_add_user.*
import kotlinx.android.synthetic.main.activity_config.*

class ConfigActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        btnBack.setOnClickListener{
            val moveWithDataIntent = Intent(this@ConfigActivity, MainActivity::class.java)
            startActivity(moveWithDataIntent)
        }
        btnSave.setOnClickListener{
            val moveWithDataIntent = Intent(this@ConfigActivity, ConfigActivity::class.java)
            startActivity(moveWithDataIntent)

        }
        btnAddUser.setOnClickListener{
            val moveWithDataIntent = Intent(this@ConfigActivity, AddUserActivity::class.java)
            startActivity(moveWithDataIntent)
        }
        btnMaps.setOnClickListener{
            val moveWithDataIntent = Intent(this@ConfigActivity, MapsActivity::class.java)
            startActivity(moveWithDataIntent)
        }
    }
}