package com.comst.howlstagram.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.comst.howlstagram.R
import com.comst.howlstagram.databinding.ActivityInputNumberBinding

class InputNumberActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInputNumberBinding
    val inputNumberViewModel : InputNumberViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_input_number)
        binding.viewModel = inputNumberViewModel
        binding.lifecycleOwner = this
        setObserve()
    }

    fun setObserve(){
        inputNumberViewModel.nextPage.observe(this){
            if (it){
                finish()
                // 이메일 인증이 된 사용자만 로그인 가능
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }
}