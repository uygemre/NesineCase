package com.uygemre.nesine.viewholder.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uygemre.nesine.constants.AppConstants.IMAGE_URL
import com.uygemre.nesine.databinding.ItemPostBinding
import com.uygemre.nesine.extensions.loadImage
import com.uygemre.nesine.recyclerview.DisplayItem
import com.uygemre.nesine.recyclerview.ViewHolder
import com.uygemre.nesine.recyclerview.ViewHolderBinder
import com.uygemre.nesine.recyclerview.ViewHolderFactory
import javax.inject.Inject

class PostViewHolder(private val binding: ItemPostBinding): ViewHolder<PostDTO>(binding) {

    override fun bind(item: PostDTO) {
        with(receiver = binding) {
            tvTitle.text = item.title
            tvBody.text = item.body
            ivPostLogo.loadImage(url = "${IMAGE_URL}${item.id}")
            rootItem.setOnClickListener {
                itemClickListener?.invoke(item, adapterPosition)
            }
        }
    }

    class HolderFactory @Inject constructor() : ViewHolderFactory {
        override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            PostViewHolder(
                ItemPostBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
    }

    class BinderFactory @Inject constructor() : ViewHolderBinder {
        override fun bind(holder: RecyclerView.ViewHolder, item: DisplayItem) {
            (holder as PostViewHolder).bind(item as PostDTO)
        }
    }
}