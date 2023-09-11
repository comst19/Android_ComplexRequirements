package com.comst.randomimage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.comst.randomimage.databinding.ActivityMainBinding
import com.comst.randomimage.mvc.MvcActivity
import com.comst.randomimage.mvp.MvpActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }
    }

    fun openMvc(){

        startActivity(Intent(this, MvcActivity::class.java))
    }

    fun openMvp(){
        startActivity(Intent(this, MvpActivity::class.java))

    }

    fun openMvvm(){

    }

    fun openMvi(){

    }
}