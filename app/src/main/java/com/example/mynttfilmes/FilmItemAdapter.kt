package com.example.mynttfilmes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mynttfilmes.databinding.FilmListItemBinding
import com.example.mynttfilmes.model.Filme

class FilmItemAdapter: ListAdapter<Filme, FilmItemAdapter.FilmItemViewHolder>(DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmItemViewHolder {
        val binding = FilmListItemBinding
            .inflate(LayoutInflater.from(parent.context),parent, false)
        return FilmItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmItemViewHolder, position: Int) {
        holder
    }

    class FilmItemViewHolder
        (private val binding: FilmListItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(filme: Filme){
            binding.name.text = filme.name
            binding.diaMesAno.text =
        }
        }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Filme>() {
            override fun areItemsTheSame(oldItem: Filme, newItem: Filme): Boolean {
                return oldItem.id == newItem.id            }

            override fun areContentsTheSame(oldItem: Filme, newItem: Filme): Boolean {
                return oldItem == newItem
            }

        }
    }


}