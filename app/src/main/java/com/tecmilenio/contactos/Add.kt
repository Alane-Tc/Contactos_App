package com.tecmilenio.contactos

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class Add : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        //Guardar contacto
        Btn_save.setOnClickListener(){
                saveContact();
        }
    }

    private fun saveContact(){
        val admin = DataBaseContacts(this,"admin", null, 1);
        val db = admin.writableDatabase;
        var fila = db.rawQuery("select number_contact from contacto where phone_contact ='${telephone_contact.text}'", null)
        if (name_contact.text.isEmpty() || telephone_contact.text.isEmpty() || email_contact.text.isEmpty()){
            Toast.makeText(this, "Error, verifique los campos", Toast.LENGTH_SHORT).show()
        }else if(fila.moveToFirst()){
            Toast.makeText(this, "Este número de teléfono ya existe", Toast.LENGTH_SHORT).show()
        }else{
            val register_contact = ContentValues();
            register_contact.put("name_contact", name_contact.text.toString());
            register_contact.put("phone_contact", telephone_contact.text.toString());
            register_contact.put("email_contact", email_contact.text.toString());
            db.insert("contacto", null, register_contact);
            db.close();
            name_contact.setText("");
            telephone_contact.setText("");
            email_contact.setText("");
            Toast.makeText(this, "Contacto registrado correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    }