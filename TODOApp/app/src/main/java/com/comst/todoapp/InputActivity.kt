package com.comst.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.comst.todoapp.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityInputBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
        // 액션바 좌측 상단에 백키
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}