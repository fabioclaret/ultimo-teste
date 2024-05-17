package com.android.appdefilmes.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.appdefilmes.R
import com.android.appdefilmes.databinding.ActivityFormCadastroBinding
import com.google.firebase.auth.FirebaseAuth

class FormCadastro : AppCompatActivity() {
    lateinit var binding:ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("#ffffff")

        binding.editEmail.requestFocus()

        binding.btnVamosLa.setOnClickListener {
            val email = binding.editEmail.text.toString()
            if (!email.isEmpty()) {

                Toast.makeText(this,"Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()
                binding.layoutSenha.visibility = View.VISIBLE
                binding.btnVamosLa.visibility = View.GONE
                binding.btnContinuar.visibility = View.VISIBLE
                binding.layoutEmail.boxStrokeColor = Color.parseColor("#ff018786")
                binding.txtTitulo.text = "Um mundo de séries e filmes \nilimitados espera por você"
                binding.txtDescricao.text = "Crie uma conta para saber mais sobre \no nosso App de Filmes"
                binding.containerHead.visibility = View.VISIBLE
                binding.layoutEmail.helperText = ""

            }else{
                binding.layoutEmail.helperText = "O campo Email é obrigatório!"
                binding.layoutEmail.boxStrokeColor = Color.parseColor("#ff0000")
            }

                binding.btnContinuar.setOnClickListener {
                    val email = binding.editEmail.text.toString()
                    val senha = binding.editSenha.text.toString()

                    if(!email.isEmpty() && !senha.isEmpty()){
                        cadastrarUsuario(email, senha)
                    }else if(senha.isEmpty()){
                        binding.layoutSenha.boxStrokeColor = Color.parseColor("ff0000")
                        binding.layoutSenha.helperText = "O campo senha é obrigatório!"
                        binding.layoutEmail.boxStrokeColor = Color.parseColor("#ff18786")
                    }else if(email.isEmpty()){
                        binding.layoutEmail.boxStrokeColor = Color.parseColor("#ff0000")
                        binding.layoutEmail.helperText = "O campo email é obrigatório!"
                    }
                }

        }
    }

    private fun cadastrarUsuario(email: String, senha: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha).addOnCompleteListener {
                cadastro->
            if(cadastro.isSuccessful){
                Toast.makeText(this,"Cadastro realizado com sucesso",Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener {
                erro->
            Toast.makeText(this,"Erro ao cadastrar usuario",Toast.LENGTH_LONG).show()

        }
    }
}

























