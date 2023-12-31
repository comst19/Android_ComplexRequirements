package com.umc.mediasearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.mediasearchapp.databinding.FragmentSearchBinding
import com.umc.mediasearchapp.list.ListAdapter

class SearchFragment : Fragment(){
    private var _binding : FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { ListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            recyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun searchKeyword(text : String){

    }
}