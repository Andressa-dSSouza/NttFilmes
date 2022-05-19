package com.example.mynttfilmes.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mynttfilmes.api.IFilmClient
import com.example.mynttfilmes.databinding.ActivityFilmDetailsBinding
import com.example.mynttfilmes.model.details.PopularMovieDetails
import com.example.mynttfilmes.model.tranding.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FilmDetailsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFilmDetailsBinding.inflate(layoutInflater)
    }
    private val movieId by lazy {
        intent.getIntExtra("movieId", 0)
    }
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val movieService by lazy {
        retrofit.create(IFilmClient::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getMovieDetails()
    }

    private fun getMovieDetails(){
        val pedeOsDetalhesDaApi = movieService.getPopularMovieDetails(movieId)
        pedeOsDetalhesDaApi.enqueue(object: Callback<PopularMovieDetails>{
            override fun onResponse(
                call: Call<PopularMovieDetails>,
                response: Response<PopularMovieDetails>
            ) {
                val detalhes = response.body()
                setupInfor(detalhes!!)
            }

            override fun onFailure(call: Call<PopularMovieDetails>, t: Throwable) {
                println("nonono")
            }

        }) }

    private fun setupInfor(detalhes: PopularMovieDetails){
        binding.filmDescricao.text = detalhes.overview
        binding.filmName.text = detalhes.title
        binding.filmData.text = detalhes.release_date
        binding.filmGenero.text = detalhes.genres[0].name
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/${detalhes.backdrop_path}")
            .into(binding.foto1)

    }

    private fun setData(filmSelected: Result?) {
        filmSelected?.let { film ->
            binding.filmName.text = film.title
            binding.filmGenero.text = film.status
            binding.filmData.text = film.release_date
            binding.filmDescricao.text = film.overview
        }
    }
}

