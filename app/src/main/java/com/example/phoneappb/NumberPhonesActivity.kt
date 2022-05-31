package com.example.phoneappb

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.phoneappb.Adapters.PhonesNamesAdapter
import com.example.phoneappb.Cache.MySharedPreference
import com.example.phoneappb.Class.PhoneClass
import com.example.phoneappb.databinding.ActivityNumberPhonesBinding

class NumberPhonesActivity : AppCompatActivity() {

    private lateinit var bindingNP: ActivityNumberPhonesBinding

    var list = ArrayList<PhoneClass>()
    var listCache = ArrayList<PhoneClass>()

    lateinit var phonesNamesAdapter: PhonesNamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingNP = ActivityNumberPhonesBinding.inflate(layoutInflater)
        setContentView(bindingNP.root)

        MySharedPreference.init(this)

        listCache = MySharedPreference.obyekString

        phonesNamesAdapter = PhonesNamesAdapter(list)

        bindingNP.gridViewNumbers.adapter = phonesNamesAdapter

        val id = intent.getIntExtra("a", -1)

        bindingNP.gridViewNumbers.setOnItemClickListener { parent, view, position, id ->

            val intent = Intent(this, DataPhoneActivity::class.java)

            intent.putExtra("ab", list[position].features)


            startActivity(intent)

        }


        Toast.makeText(this, "$id", Toast.LENGTH_SHORT).show()

        for (i in 0 until listCache.size) {

            if (listCache[i].id == id) {

                list.add(PhoneClass(listCache[i].id, listCache[i].phoneName, listCache[i].features))


            }

        }

    }
}