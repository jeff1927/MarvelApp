package com.apps.marvelapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.apps.marvelapp.databinding.GeneralItemLayoutBinding
import com.apps.marvelapp.domain.constants.HEROES_IMAGE_SIZE
import com.apps.marvelapp.domain.models.CharacterModel
import com.bumptech.glide.Glide

class HeroesAdapter: PagingDataAdapter<CharacterModel, HeroesAdapter.HeroViewHolder>(HeroDifferCallBack()){

    class HeroViewHolder (val binding: GeneralItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = GeneralItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = getItem(position)
        holder.binding.apply {
            hero?.let {
                tvTitle.text = hero.name
                tvDescription.text = hero.bio
                Glide.with(this.root).load(it.imagePath + HEROES_IMAGE_SIZE + it.imageExt).into(ivItemImage)
            }

        }
    }
}

class HeroDifferCallBack: DiffUtil.ItemCallback<CharacterModel>() {
    override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem == newItem
    }

}
