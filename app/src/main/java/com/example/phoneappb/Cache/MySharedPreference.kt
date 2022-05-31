package com.example.phoneappb.Cache

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.phoneappb.Class.PhoneClass
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

object MySharedPreference {

    private const val NAME = "registration"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context){
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    @SuppressLint("CommitPrefEdits")
    private inline fun SharedPreferences.edit(operation:(SharedPreferences.Editor) -> Unit){
        val editor = edit()
        operation(editor)
        editor.apply()
    }


    var user:String?
        get() =  sharedPreferences.getString("user","{}")
        set(value) = sharedPreferences.edit {
            if (value != null){
                it.putString("user",value)
            }
        }

    var obyekString: ArrayList<PhoneClass>
        get() = gsonStringToArray(sharedPreferences.getString("obekt", "[]")!!)
        set(value) = sharedPreferences.edit {
            if (value != null) {
                it.putString("obekt", arrayToGsonString(value))
            }
        }

    private fun gsonStringToArray(gsonString: String): ArrayList<PhoneClass> {
        val type = object : TypeToken<ArrayList<PhoneClass>>() {}.type
        return Gson().fromJson(gsonString, type)
    }

    fun arrayToGsonString(arrayList: ArrayList<PhoneClass>): String? {
        return Gson().toJson(arrayList)
    }

}