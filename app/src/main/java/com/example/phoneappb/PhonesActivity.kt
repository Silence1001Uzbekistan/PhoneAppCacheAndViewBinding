package com.example.phoneappb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneappb.Adapters.PhoneTypesAdapter
import com.example.phoneappb.databinding.ActivityPhonesBinding

class PhonesActivity : AppCompatActivity() {

    private lateinit var bindingPS: ActivityPhonesBinding

    var list = ArrayList<String>()

    lateinit var phoneTypesAdapter: PhoneTypesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingPS = ActivityPhonesBinding.inflate(layoutInflater)
        setContentView(bindingPS.root)

        phoneTypesAdapter = PhoneTypesAdapter(list)

        bindingPS.gridViewPS.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this, NumberPhonesActivity::class.java)

            intent.putExtra("a",position)

            startActivity(intent)

        }

        bindingPS.gridViewPS.adapter = phoneTypesAdapter

        loadData()

    }

    private fun loadData() {

        list.add("Iphone")
        list.add("Samsung")
        list.add("Mi")
        list.add("Sony")
        list.add("Huawei")
        list.add("Artel")

    }

}