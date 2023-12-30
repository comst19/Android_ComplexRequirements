package com.comst.blindapp.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import com.comst.blindapp.R
import com.comst.blindapp.databinding.ActivityMainBinding
import com.comst.blindapp.domain.model.Content
import com.comst.blindapp.presenter.ui.list.ListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val adapter by lazy { ListAdapter(Handler()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@MainActivity
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(
                DividerItemDecoration(this@MainActivity, LinearLayout.VERTICAL)
            )
        }
    }

    fun onClickAdd(){
        InputActivity.start(this)
    }

    inner class Handler {
        fun onClickItem(item : Content){
            InputActivity.start(this@MainActivity, item)
        }

        fun onLongClickItem(item : Content) : Boolean{
            AlertDialog.Builder(this@MainActivity)
                .setTitle("정말 삭제 하시겠습니까?")
                .setPositiveButton("네"){ _, _ ->

                }
                .setNegativeButton("아니오"){ _, _ ->

                }
                .show()

            return false
        }
    }
}