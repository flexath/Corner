package com.flexath.corner.features.auth.presentation.screens.model

import com.flexath.corner.R

object WriterCardDummyList {
    val writerList = listOf(
        Writer(
            id = 1,
            name = "Cristiano Ronaldo",
            description = "One of the greatest footballers of all time, 5-time Ballon d'Or winner, and 5-time Champions League winner.",
            isFollowed = false,
            coverPhoto = R.drawable.welcome_2
        ),
        Writer(
            id = 1,
            name = "Lionel Messi",
            description = "Widely regarded as the best football player in the world, 8-time Ballon d'Or winner and multiple Champions League winner.",
            isFollowed = false,
            coverPhoto = R.drawable.welcome_1
        ),
        Writer(
            id = 1,
            name = "Mbappe",
            description = "French professional footballer, known for his incredible speed and goal-scoring abilities. World Cup winner in 2018.",
            isFollowed = false,
            coverPhoto = R.drawable.welcome_4
        ),
        Writer(
            id = 1,
            name = "Neymar Jr",
            description = "Brazilian football star, known for his flair, dribbling skills, and goal-scoring prowess. Multiple domestic league titles winner.",
            isFollowed = false,
            coverPhoto = R.drawable.welcome_3
        ),
        Writer(
            id = 1,
            name = "Erling Haaland",
            description = "Norwegian football prodigy, known for his remarkable goal-scoring record and physical presence on the field.",
            isFollowed = false,
            coverPhoto = R.drawable.welcome_5
        ),
        Writer(
            id = 1,
            name = "Toni Kroos",
            description = "German midfielder, known for his exceptional passing, vision, and leadership. Multiple Champions League winner with Real Madrid.",
            isFollowed = false,
            coverPhoto = R.drawable.welcome_6
        ),
        Writer(
            id = 1,
            name = "Luka Modric",
            description = "Croatian midfielder, renowned for his playmaking abilities, Ballon d'Or winner in 2018, and key player for Real Madrid's successes.",
            isFollowed = false,
            coverPhoto = R.drawable.welcome_7
        ),
        Writer(
            id = 1,
            name = "Bruno Fernandes",
            description = "Portuguese midfielder, known for his creativity, goal-scoring, and set-piece prowess. Key player for Manchester United.",
            isFollowed = false,
            coverPhoto = R.drawable.welcome_1
        ),
        Writer(
            id = 1,
            name = "Vinicius Junior",
            description = "Brazilian winger, known for his pace, dribbling, and impact at Real Madrid. One of the brightest young talents in football.",
            isFollowed = false,
            coverPhoto = R.drawable.welcome_2
        ),
        Writer(
            id = 1,
            name = "Bellingham",
            description = "English midfielder, known for his versatility, maturity, and leadership on the field at a young age.",
            isFollowed = false,
            coverPhoto = R.drawable.welcome_3
        )
    )
}

data class Writer(
    val id: Int,
    val name: String,
    val description: String,
    val isFollowed: Boolean,
    val coverPhoto: Int
)