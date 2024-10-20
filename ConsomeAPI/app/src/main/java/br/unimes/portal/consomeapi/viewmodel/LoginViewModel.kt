package br.unimes.portal.consomeapi.viewmodel

import androidx.lifecycle.ViewModel
import br.unimes.portal.consomeapi.model.User

class LoginViewModel:ViewModel() {
    private val usuarios = mutableListOf<User>()

    fun cadastrar(user:User):String{
        usuarios.add(user)
        return "Cadastro Realizado"
    }
    fun logar(user: User):String{
        val retorno = usuarios.find {it.login==user.login && it.senha==user.senha}
        if (retorno!=null){
            return "Login Realizado com Sucesso!"
        }else {
            return "Não Encontrado!"
        }
    }

}