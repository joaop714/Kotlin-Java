package br.unimes.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_usuario)
        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtIdade = findViewById<EditText>(R.id.edt_idade)
        val edtmail = findViewById<EditText>(R.id.edt_mail)
        val edtTel = findViewById<EditText>(R.id.edt_telefone)
        val edtPix = findViewById<EditText>(R.id.edt_pix)
        val btnAtualizar = findViewById<Button>(R.id.btn_atualizar)
        val bntSalvar = findViewById<Button>(R.id.btn_salvar)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)

        edtNome.setText(intent.getStringExtra("nome_usuario"))

        btnAtualizar.setOnClickListener{
            edtNome.isEnabled = true
            edtmail.isEnabled = true
            edtTel.isEnabled = true
            edtIdade.isEnabled = true
            edtPix.isEnabled = true
        }

        bntSalvar.setOnClickListener{
            edtNome.isEnabled = false
            edtmail.isEnabled = false
            edtTel.isEnabled = false
            edtIdade.isEnabled = false
            edtPix.isEnabled = false
        }


        fabVolta.setOnClickListener {
            finish()
        }
    }
}