package com.comst.howlstagram.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.comst.howlstagram.R
import com.comst.howlstagram.databinding.FragmentDetailViewBinding
import com.comst.howlstagram.databinding.ItemDetailBinding
import com.comst.howlstagram.model.ContentModel
import com.google.firebase.firestore.FirebaseFirestore


class DetailViewFragment : Fragment() {

    lateinit var binding : FragmentDetailViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_view, container, false)

        binding.detailviewRecyclerveiw.adapter = DetailViewRecyclerviewAdapter()
        binding.detailviewRecyclerveiw.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }

    inner class DetailViewHolder(var binding : ItemDetailBinding) : RecyclerView.ViewHolder(binding.root)

    inner class DetailViewRecyclerviewAdapter() : RecyclerView.Adapter<DetailViewHolder>(){

        var firestore = FirebaseFirestore.getInstance()
        var contentModels = arrayListOf<ContentModel>()
        init {
            firestore.collection("images").addSnapshotListener { value, error ->
                contentModels.clear()
                for (item in value!!.documents){
                    var contentModel = item.toObject(ContentModel::class.java)
                    contentModels.add(contentModel!!)
                }
                notifyDataSetChanged()
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
            var view = ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return DetailViewHolder(view)
        }

        override fun getItemCount(): Int {
            return contentModels.size
        }

        override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {

            var contentModel = contentModels[position]
            holder.binding.profileTextview.text = contentModel.userId
            holder.binding.explainTextview.text = contentModel.explain
            holder.binding.likeTextview.text = "Like " + contentModel.favoriteCount
            Glide.with(holder.itemView.context).load(contentModel.imgUrl).into(holder.binding.contentImageview)
        }

    }
}