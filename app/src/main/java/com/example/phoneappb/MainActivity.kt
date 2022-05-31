package com.example.phoneappb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneappb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingM: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingM = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingM.root)

        bindingM.addphonesM.setOnClickListener {

            val intent = Intent(this, PhoneTypesActivity::class.java)

            startActivity(intent)

        }

        bindingM.phonesM.setOnClickListener {

            val intent = Intent(this, PhonesActivity::class.java)

            startActivity(intent)

        }

    }
}