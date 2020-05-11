package com.e.pantomime.game

class WordsRepository {
    private val words = mapOf(
        Category.MOVIES to listOf(
            "Harry Potter",
            "Lord of The Rings",
            "The Matrix",
            "Titanic",
            "The Avengers",
            "Star Wars",
            "Ready Player One",
            "Back to the Future",
            "Indiana Jones",
            "Rocky",
            "Braveheart",
            "Inception",
            "Wall-E",
            "Ghostbusters",
            "Gladiator",
            "Monty Python and The Holy Grail",
            "Avatar",
            "The Lion King",
            "Mary Poppins",
            "West Side Story",
            "Amelie",
            "Good Will Hunting"
        ),

        Category.PEOPLE to listOf(
            "Tom Hanks",
            "Queen Elizabeth II",
            "Woody Allen",
            "Barack Obama",
            "Marilyn Monroe",
            "Beyonce",
            "Madonna",
            "Elvis",
            "Will Smith",
            "Taylor Swift",
            "Ellen DeGeneres",
            "Michael Jordan",
            "Steven Spielberg",
            "Adele",
            "Dwayne Johnson",
            "Rihana",
            "Britney Spears",
            "Elton John",
            "Alfred Hitchcock",
            "Elon Musk",
            "Leonardo DiCaprio",
            "Miley Cyrus"
        ),

        Category.ANIMALS to listOf(
            "Lion",
            "Ape",
            "Elephant",
            "Giraffe",
            "Snake",
            "Eagle",
            "Wolf",
            "Mouse",
            "Panther",
            "Pig",
            "Chipmunk",
            "Dolphin",
            "Whale",
            "Seal",
            "Deer",
            "Dog",
            "Cat",
            "Hamster",
            "Horse"
        )
    )

    fun getCategoryWords(category: Category) : List<String> {
        return words[category] ?: error("No category found")
    }
}