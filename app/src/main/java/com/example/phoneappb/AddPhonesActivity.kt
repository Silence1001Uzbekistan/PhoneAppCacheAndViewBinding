package com.example.phoneappb

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.phoneappb.Cache.MySharedPreference
import com.example.phoneappb.Class.PhoneClass
import com.example.phoneappb.databinding.ActivityAddPhonesBinding

class AddPhonesActivity : AppCompatActivity() {

    private lateinit var bindingA: ActivityAddPhonesBinding

    var list = ArrayList<PhoneClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingA = ActivityAddPhonesBinding.inflate(layoutInflater)
        setContentView(bindingA.root)

        MySharedPreference.init(this)

        val id = intent.getIntExtra("number", -1)

        when (id) {
            0 -> Toast.makeText(this, "Iphone", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(this, "Samsung", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(this, "Mi", Toast.LENGTH_SHORT).show()
            3 -> Toast.makeText(this, "Sony", Toast.LENGTH_SHORT).show()
            4 -> Toast.makeText(this, "Huawei", Toast.LENGTH_SHORT).show()
            5 -> Toast.makeText(this, "Artel", Toast.LENGTH_SHORT).show()
        }

        bindingA.buttonSave.setOnClickListener {

            if (bindingA.phoneNameA.text.trim().isNotEmpty() && bindingA.phoneFeaturesA.text.trim()
                    .isNotEmpty()
            ) {

                list = MySharedPreference.obyekString

                val name = bindingA.phoneNameA.text.toString()
                val features = bindingA.phoneFeaturesA.text.toString()

                list.add(PhoneClass(id, name, features))

                MySharedPreference.obyekString = list

                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()

                finish()

            } else {
                Toast.makeText(this, "To'g'ri kiriting", Toast.LENGTH_SHORT).show()
            }

        }

    }
}