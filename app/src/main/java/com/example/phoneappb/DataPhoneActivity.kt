package com.example.phoneappb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phoneappb.Cache.MySharedPreference
import com.example.phoneappb.Class.PhoneClass
import com.example.phoneappb.databinding.ActivityDataPhoneBinding

class DataPhoneActivity : AppCompatActivity() {

    private lateinit var bindingD: ActivityDataPhoneBinding

    var listData = ArrayList<PhoneClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingD = ActivityDataPhoneBinding.inflate(layoutInflater)
        setContentView(bindingD.root)


    }

    override fun onStart() {
        super.onStart()

        MySharedPreference.init(this)


        listData = MySharedPreference.obyekString

        val idB = intent.getStringExtra("ab")

        bindingD.dataText.text = idB


    }

}