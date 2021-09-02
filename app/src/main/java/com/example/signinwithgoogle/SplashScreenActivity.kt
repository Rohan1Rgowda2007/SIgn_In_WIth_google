package com.example.signinwithgoogle

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.signinwithgoogle.databinding.ActivitySplashScreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        supportActionBar?.hide()

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser

        Handler().postDelayed({
            if (currentUser == null){
                startActivity(Intent(this@SplashScreenActivity , LoginActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this@SplashScreenActivity,MainActivity::class.java))
                finish()
            }
        },2000)
    }
}