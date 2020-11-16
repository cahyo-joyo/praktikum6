package com.example.praktikum6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_phone_detail.*

class PhoneDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_detail)

        var intentThatStartedThisActivity = getIntent()

        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            var partId = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_PHONE_NUMBER)
            var partlahir = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            var partalamat = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_COMPONENT_NAME)
            var partemail = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_EMAIL)
            tv_item_id.text = partId
            tv_item_lahir.text = partlahir
            tv_item_alamat.text = partalamat
            tv_item_email.text = partemail
        }
    }
}