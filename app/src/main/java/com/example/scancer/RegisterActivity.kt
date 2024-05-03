package com.example.scancer

import android.os.Bundle
import android.util.Patterns
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.scancer.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.regisButton.setOnClickListener {
            val email = binding.editemail.text.toString()
            val password = binding.editpassword.text.toString()

            if (email.isEmpty()){
                binding.editemail.error = "Email Wajib Diisi"
                binding.editemail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.editemail.error = "Email Tidak Valid"
                binding.editemail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()){
                binding.editpassword.error = "Password Wajib Diisi"
                binding.editpassword.requestFocus()
                return@setOnClickListener
            }

            if (password.length<6){
                binding.editpassword.error = "Password Minimal 6 karakter"
                binding.editpassword.requestFocus()
                return@setOnClickListener
            }

        }

    }
}