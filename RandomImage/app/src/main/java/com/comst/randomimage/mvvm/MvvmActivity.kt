package com.comst.randomimage.mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.comst.randomimage.databinding.ActivityMvvmBinding
import com.comst.randomimage.mvvm.repository.ImageRepositoryImpl

class MvvmActivity : AppCompatActivity() {

    private val viewmodel : MvvmViewModel by viewModels {
        MvvmViewModel.MvvmViewModelFactory(ImageRepositoryImpl())
    }

    private lateinit var binding : ActivityMvvmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.lifecycleOwner = this
            it.view = this
            it.viewModel = viewmodel
        }
    }

    fun loadImage(){
        viewmodel.loadRandomImage()
    }
}