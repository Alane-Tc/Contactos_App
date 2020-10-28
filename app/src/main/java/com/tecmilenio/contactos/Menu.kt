package com.tecmilenio.contactos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Add_contact.setOnClickListener(){
            val intent: Intent = Intent(this, Add::class.java);
            startActivity(intent);
        }

        Show_contact.setOnClickListener(){
            val intent: Intent = Intent(this, EditContact::class.java);
            startActivity(intent);
        }
    }
}