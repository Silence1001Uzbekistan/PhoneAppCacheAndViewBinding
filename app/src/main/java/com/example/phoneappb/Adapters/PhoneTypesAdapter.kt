package com.example.phoneappb.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.phoneappb.R

class PhoneTypesAdapter(var list: List<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): String {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var itemView: View
        if (convertView == null) {

            itemView = LayoutInflater.from(parent!!.context).inflate(R.layout.item, parent, false)

        } else {

            itemView = convertView

        }

        itemView.findViewById<TextView>(R.id.textItem).text = list[position]

        return itemView

    }
}