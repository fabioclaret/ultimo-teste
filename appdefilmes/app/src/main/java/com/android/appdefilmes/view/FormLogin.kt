package com.android.appdefilmes.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.appdefilmes.R
import com.android.appdefilmes.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {
    lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("#000000")

        binding.btnEntrar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            when{
                email.isEmpty()->{
                    binding.containerEmail.helperText = "Prencha com o Email!"
                    binding.containerEmail.boxStrokeColor = Color.parseColor("#ff5722")
                }
                senha.isEmpty()->{
                    binding.containerSenha.helperText = "Preencha com a Senha!"
                    binding.containerSenha.boxStrokeColor = Color.parseColor("#ff5722")
                }
            }
        }
        binding.txtTeladeCadastro.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }
    }
}










