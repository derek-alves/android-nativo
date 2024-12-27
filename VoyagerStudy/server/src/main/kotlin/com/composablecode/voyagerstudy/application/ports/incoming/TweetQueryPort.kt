package com.composablecode.voyagerstudy.application.ports.incoming

import com.composablecode.voyagerstudy.domain.entity.Tweet


interface TweetQueryPort {
    fun getAllTweets(): List<Tweet>
}