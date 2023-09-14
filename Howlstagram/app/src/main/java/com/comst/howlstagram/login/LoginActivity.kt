package com.comst.howlstagram.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.comst.howlstagram.R
import com.comst.howlstagram.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
//    private lateinit var loginViewModel : LoginViewModel
    private val loginViewModel : LoginViewModel by viewModels()

    // 회원가입 관리 변수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
//        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.viewModel = loginViewModel
        binding.activity = this
        binding.lifecycleOwner = this
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



    fun findId(){
        println("findId")
        loginViewModel.showFindIdActivity.value = true
    }

    // 구글 로그인이 성공한 결과값 받는 함수
    var googleLoginResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->

        val data = result.data
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        val account = task.getResult(ApiException::class.java)
        loginViewModel.firebaseAuthWithGoogle(account.idToken)
    }
}