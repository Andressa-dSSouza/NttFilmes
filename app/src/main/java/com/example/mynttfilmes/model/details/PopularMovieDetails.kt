package com.example.mynttfilmes.model.details

data class PopularMovieDetails(
    val backdrop_path: String?,
    val release_date: String,
    val title: String,
    val overview: String,
    val genres: List<Genres>
)
