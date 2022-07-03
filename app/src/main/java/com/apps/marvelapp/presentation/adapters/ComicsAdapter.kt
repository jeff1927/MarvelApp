package com.apps.marvelapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.apps.marvelapp.databinding.GeneralItemLayoutBinding
import com.apps.marvelapp.domain.constants.COMICS_IMAGE_SIZE
import com.apps.marvelapp.domain.models.ComicModel
import com.bumptech.glide.Glide

class ComicsAdapter: PagingDataAdapter<ComicModel,ComicsAdapter.ComicsViewHolder>(ComicDifferCallBack()) {

    class ComicsViewHolder (val binding: GeneralItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        val comic = getItem(position)
        holder.binding.apply {
            comic?.let {
                tvTitle.text = comic.title
                tvDescription.text = comic.description
                Glide.with(this.root).load(it.ImagePath + COMICS_IMAGE_SIZE + it.imageExt).into(ivItemImage)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val view = GeneralItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ComicsViewHolder(view)
    }


}

class ComicDifferCallBack : DiffUtil.ItemCallback<ComicModel>() {
    override fun areItemsTheSame(oldItem: ComicModel, newItem: ComicModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ComicModel, newItem: ComicModel): Boolean {
        return oldItem == oldItem
    }

}
