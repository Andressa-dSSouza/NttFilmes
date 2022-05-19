package com.example.mynttfilmes.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mynttfilmes.api.IFilmClient
import com.example.mynttfilmes.databinding.ActivityMainBinding
import com.example.mynttfilmes.model.tranding.MovieTranding
import com.example.mynttfilmes.model.tranding.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    val filmeItemAdapter by lazy{
        FilmItemAdapter()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val filmService: IFilmClient by lazy {
        retrofit.create(IFilmClient::class.java)
    }
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        filmeItemAdapter.onClickListener = { resultId ->
            goToFilmDetails(resultId)
        }
        binding.filmListRecyclerView.adapter = filmeItemAdapter

        getMoviesFromApi()
    }

    private fun getMoviesFromApi() {
         val call = filmService.getMovies()

         call.enqueue(object : Callback<MovieTranding> {
            override fun onResponse(call: Call<MovieTranding>, response: Response<MovieTranding>) {
                val movie = response.body()
                setupAdapter(movie!!.results)
            }

            override fun onFailure(call: Call<MovieTranding>, t: Throwable) {
                val film = t.message

            }
        })
    }
    fun setupAdapter(list: List<Result>) {
        filmeItemAdapter.submitList(list)
    }

    private fun goToFilmDetails(movieId: Int) {
        val intent = Intent(this, FilmDetailsActivity::class.java)
        intent.putExtra("movieId", movieId)
        startActivity(intent)

    }


}



