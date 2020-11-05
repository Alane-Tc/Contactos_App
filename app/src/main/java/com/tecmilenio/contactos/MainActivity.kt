package com.tecmilenio.contactos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
