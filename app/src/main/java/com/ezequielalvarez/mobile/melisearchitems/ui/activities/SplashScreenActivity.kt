package com.ezequielalvarez.mobile.melisearchitems.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.ezequielalvarez.mobile.melisearchitems.R



class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen)


        Handler().postDelayed({
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }, 2000)



    }
}