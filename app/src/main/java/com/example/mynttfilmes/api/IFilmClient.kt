package com.example.mynttfilmes.api

import com.example.mynttfilmes.model.details.PopularMovieDetails
import com.example.mynttfilmes.model.tranding.MovieTranding
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

const val API_KEY = "?api_key=a034c4194854399aebc4095f72a19e0f&page=1&language=pt-BR"

interface IFilmClient {
    @GET("3/trending/movie/week$API_KEY")
     fun getMovies() : Call<MovieTranding>

     @GET("3/movie/{movie_id}$API_KEY")
     fun getPopularMovieDetails(@Path("movie_id") movieId: Int): Call<PopularMovieDetails>

     //TODO: CRIAR UMA FUNÇÃO QUE CONSUMA A PARTE DOS DETALHES DE UM FILME
}