package com.fabien.trivia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform