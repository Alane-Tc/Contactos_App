package com.tecmilenio.contactos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_contact.*

class EditContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_contact)

        Btn_Seatch.setOnClickListener(){
            Search_Name();
        }

        Btn_remove.setOnClickListener(){
            if (nameSearch.text.isEmpty()){
                showMessageError();
            }else{
                removeContact()
            }
        }

    }

    private fun Search_Name(){
        val admin = DataBaseContacts(this, "admin", null, 1)
        val db = admin.writableDatabase;
        var fila = db.rawQuery("select number_contact, phone_contact, email_contact from contacto where name_contact='${nameSearch.text}'", null)
        if (fila.moveToFirst()){
            show_results2.setText("Telefono: "+fila.getString(1))
            show_results4.setText("Email: "+fila.getString(2))
        }else{
            Toast.makeText(this, "No existe el contacto", Toast.LENGTH_SHORT).show()
            db.close()
        }
    }

    private fun removeContact(){
        val admin = DataBaseContacts(this, "admin", null, 1)
        val db = admin.writableDatabase;
        val cant = db.delete("contacto", "name_contact='${nameSearch.text}'", null);
        db.close()
        nameSearch.setText("")
        if (cant ==1){
            Toast.makeText(this, "Se borró el contacto correctamente", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "No existe este Contacto", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showMessageError(){
        Toast.makeText(this, "Error, verifique los campos o si el contacto existe", Toast.LENGTH_SHORT).show()
    }

}