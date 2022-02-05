package com.apps.marvelapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.apps.marvelapp.databinding.HeroGridItemLayoutBinding
import com.apps.marvelapp.domain.models.HeroModel

class HeroesAdapter: ListAdapter<HeroModel, HeroesAdapter.HeroViewHolder> (HeroDifferCallBack()){

    class HeroViewHolder (val binding: HeroGridItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = HeroGridItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = getItem(position)
        holder.binding.apply {
            tvHeroName.text = hero.name
            tvBiographic.text = if (hero.bio.isNullOrBlank()) "No disponible" else hero.bio
        }
    }
}

class HeroDifferCallBack: DiffUtil.ItemCallback<HeroModel>() {
    override fun areItemsTheSame(oldItem: HeroModel, newItem: HeroModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HeroModel, newItem: HeroModel): Boolean {
        return true
    }

}
