package com.example.mynttfilmes.model

data class Filme(

    val id: Int,
    val title: String,
    val original_title: String,
    val status: String,
    val adult: String,
    val original_language: String,
    val overview: String,
    val release_date: String,



)

fun mockFilms(): List0f = List0f(

    Filme(
        id = 1,
        title = "Corra",
        original_title = "Rum",
        status = "Suspense",
        adult = "Sim",
        original_language = "En",
        overview = "Individuo conhece moça e vai em uma viagem conhecer a familia",
        release_date = "2020"
    ),
    Filme(
        id = 2,
        title = "Vermelho",
        original_title = "Red",
        status = "Animação",
        original_language = "En",
        overview = "Adolecente vira panda vermelho",
        release_date = "2020",
        adult = "Não"
    ),
    Filme(
        id = 3,
        title = "",
        original_title = "Gente Grande",
        status = "Comedia",
        original_language = "En",
        overview = "Pais que esqueceram de crescer mas tem familia",
        release_date = "2020",
        adult = "Não"
)

)

class List0f(filme: Filme, filme1: Filme, filme2: Filme) {

}

