package com.example.phoneappb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phoneappb.Adapters.PhoneTypesAdapter
import com.example.phoneappb.databinding.ActivityPhoneTypesBinding

class PhoneTypesActivity : AppCompatActivity() {

    private lateinit var bindingT: ActivityPhoneTypesBinding

    var list = ArrayList<String>()

    lateinit var phoneTypesAdapter: PhoneTypesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingT = ActivityPhoneTypesBinding.inflate(layoutInflater)
        setContentView(bindingT.root)

        phoneTypesAdapter = PhoneTypesAdapter(list)

        bindingT.gridViewT.adapter = phoneTypesAdapter

        bindingT.gridViewT.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this, AddPhonesActivity::class.java)

            intent.putExtra("number",position)

            startActivity(intent)

        }

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