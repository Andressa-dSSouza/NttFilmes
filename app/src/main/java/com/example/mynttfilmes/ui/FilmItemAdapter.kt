package com.example.mynttfilmes.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mynttfilmes.databinding.FilmListItemBinding
import com.example.mynttfilmes.model.tranding.Result

class FilmItemAdapter: ListAdapter<com.example.mynttfilmes.model.tranding.Result, FilmItemAdapter.FilmItemViewHolder>(
    DIFF_CALLBACK
){

    var onClickListener: ((filmId: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmItemViewHolder {
        val binding = FilmListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent, false)
        return FilmItemViewHolder(binding, onClickListener)
    }

    override fun onBindViewHolder(holder: FilmItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class FilmItemViewHolder(
        private val binding: FilmListItemBinding,
        private val onClickListener: ((filmId: Int) -> Unit)?
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(film: Result){
            binding.filmName.text = film.title

            Glide.with(binding.root)
                .load("https://image.tmdb.org/t/p/${film.posterPath}")
                .into(binding.foto1)


            binding.root.setOnClickListener {
                onClickListener?.invoke(film.id)
            }

            }
        }
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<com.example.mynttfilmes.model.tranding.Result>() {
            override fun areItemsTheSame(oldItem: com.example.mynttfilmes.model.tranding.Result, newItem: com.example.mynttfilmes.model.tranding.Result): Boolean {
                return oldItem.id == newItem.id            }

            override fun areContentsTheSame(oldItem: com.example.mynttfilmes.model.tranding.Result, newItem: com.example.mynttfilmes.model.tranding.Result): Boolean {
                return oldItem == newItem
            }

        }
    }
    }