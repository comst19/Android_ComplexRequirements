package com.comst.howlstagram.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.comst.howlstagram.R
import com.comst.howlstagram.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
//    private lateinit var loginViewModel : LoginViewModel
    private val loginViewModel : LoginViewModel by viewModels()

    // 회원가입 관리 변수
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
//        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.viewModel = loginViewModel
        binding.activity = this
        binding.lifecycleOwner = this
        auth = FirebaseAuth.getInstance()
        setObserve()
    }

    fun setObserve(){
        loginViewModel.showInputNumberActivity.observe(this){
            if (it){
                finish()
                startActivity(Intent(this, InputNumberActivity::class.java))
            }
        }

        loginViewModel.showFindIdActivity.observe(this){
            if (it){
                startActivity(Intent(this, FindIdActivity::class.java))
            }
        }
    }

    fun loginWithSignupEmail(){
        println("Email")
        auth.createUserWithEmailAndPassword(loginViewModel.id.value.toString(), loginViewModel.password.value.toString()).addOnCompleteListener {
            if (it.isSuccessful){
                loginViewModel.showInputNumberActivity.value = true
            }else{
                // 아이디가 있을 경우
            }
        }
    }

    fun findId(){
        println("findId")
        loginViewModel.showFindIdActivity.value = true
    }
}