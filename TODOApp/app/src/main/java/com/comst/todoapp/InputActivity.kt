package com.comst.todoapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.comst.todoapp.databinding.ActivityInputBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInputBinding
    private val viewModel : InputViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_input)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this@InputActivity

        viewModel.doneEvent.observe(this){
            Toast.makeText(this, "완료!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}