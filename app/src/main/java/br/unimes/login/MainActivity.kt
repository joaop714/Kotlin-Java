package br.unimes.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtPass = findViewById<EditText>(R.id.edt_senha)
        val btnEntrar = findViewById<Button>(R.id.btn_button)

        btnEntrar.setOnClickListener{
            val email = edtEmail.text.toString()
            val pass = edtPass.text.toString().toInt()
            if(email.equals("joao")&&pass==123){
                val intent = Intent(this,UsuarioActivity::class.java)
                startActivity(intent)
                }else{
                Toast.makeText(this, "Dados Incorretos!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}