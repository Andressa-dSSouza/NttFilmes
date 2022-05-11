package com.example.mynttfilmes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mynttfilmes.databinding.ActivityMainBinding
import com.example.mynttfilmes.model.mockFilms

class MainActivity : AppCompatActivity() {

    private val binder by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binder.root)

        val filmItemAdapter = FilmItemAdapter()

        binder.filmListRecyclerView.adapter = filmItemAdapter

        filmItemAdapter.submitList(mockFilms())

    }
}