package com.mvvmdatabinding.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mvvmdatabinding.databinding.ItemHerosBinding
import com.mvvmdatabinding.model.Heros

class HerosAdapter(private val herosList: ArrayList<Heros.HerosItem>) :
    RecyclerView.Adapter<HerosAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHerosBinding.inflate(inflater, parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(herosList[position])
    }

    override fun getItemCount(): Int {
        return herosList.size
    }

    class VH(private val binding: ItemHerosBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Heros.HerosItem) {
            binding.tvName.text = data.name
            binding.tvBio.text = data.bio
            Glide.with(binding.root.context).load(data.imageurl)
                .into(binding.ivImage)
        }
    }
}