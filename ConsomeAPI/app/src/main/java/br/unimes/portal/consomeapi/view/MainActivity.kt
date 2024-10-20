package br.unimes.portal.consomeapi.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.unimes.portal.consomeapi.databinding.ActivityMainBinding
import br.unimes.portal.consomeapi.model.User
import br.unimes.portal.consomeapi.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel = LoginViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener{
            val login = binding.edtMail.text.toString()
            val senha = binding.edtSenha.text.toString()
            val user = User(login,senha)
            val retorno = viewModel.logar(user)
            Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()
        }

        binding.btnCadatrar.setOnClickListener{
            val login = binding.edtMail.text.toString()
            val senha = binding.edtSenha.text.toString()
            val user = User(login,senha)
            val retorno = viewModel.cadastrar(user)
            Toast.makeText(this, retorno, Toast.LENGTH_SHORT).show()
        }




    }
}