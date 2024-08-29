package com.example.app

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var backPressedTime: Long = 0
    private lateinit var backToast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        //Hide Navbar in Android App
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.apply {
                hide(WindowInsets.Type.navigationBars()) // Hide only the navigation bar
                show(WindowInsets.Type.statusBars())
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    )
        }


        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (backPressedTime + 2000 > System.currentTimeMillis()) {
                    backToast.cancel()
                    finish()
                } else {
                    backToast = Toast.makeText(applicationContext, "Press back again to exit", Toast.LENGTH_SHORT)
                    backToast.show()
                }
                backPressedTime = System.currentTimeMillis()
            }
        })

    }
}