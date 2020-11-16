package com.example.praktikum6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactlist.PhoneData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createPhoneData()
        rv_part.layoutManager = LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter = ContactAdapter(testData, {phoneItem : PhoneData -> phoneItemClicked(phoneItem)})
    }
    private fun phoneItemClicked(phoneItem : PhoneData) {
        val showDetailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_PHONE_NUMBER, phoneItem.phone.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.lahir)
        showDetailActivityIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, phoneItem.alamat)
        showDetailActivityIntent.putExtra(Intent.EXTRA_EMAIL, phoneItem.email)
        startActivity(showDetailActivityIntent)
    }
    private fun createPhoneData() : List<PhoneData> {
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData(98765,"Cahyo", "Surabaya, 12 Juni 2000", "Jl. Tambak Asri, Surabaya", "cahyoj6@gmail.com"))
        partList.add(PhoneData(87654,"Mega", "Surabaya, 24 Mei 2001", "Jl. Diponegoro, Surabaya", "megasari@gmail.com"))
        partList.add(PhoneData(76543,"Tono", "Nganjuk, 07 Oktober 1995", "Jl. Sukarno, Gresik", "tono123@gmail.com"))
        partList.add(PhoneData(65432,"Putri", "Kediri, 07 Januari 1990", "Jl. Jaguar, Surabaya", "putriputri@gmail.com"))
        partList.add(PhoneData(54321,"Adam", "Jombang, 29 Oktober 2008", "Jl. Mawar, Surabaya", "adamlevigne@gmail.com"))
        return partList
    }
}