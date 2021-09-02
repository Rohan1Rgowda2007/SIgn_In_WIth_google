package com.example.signinwithgoogle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.signinwithgoogle.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.LogOutButton.setOnClickListener {
            val firebaseAuthentication = FirebaseAuth.getInstance()
            firebaseAuthentication.signOut()
            Toast.makeText(this,"Sign out successfully",Toast.LENGTH_LONG).show()

            //intenting it to login Activity

            val intenting = Intent(this@MainActivity,LoginActivity::class.java)
            startActivity(intenting)
            finish()
        }

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser
        mBinding.id.text = currentUser?.uid

        mBinding.emailAdress.text = currentUser?.email

        mBinding.userName.text = currentUser?.displayName

        Glide.with(this).load(currentUser?.photoUrl).into(mBinding.imageView);


    }
}