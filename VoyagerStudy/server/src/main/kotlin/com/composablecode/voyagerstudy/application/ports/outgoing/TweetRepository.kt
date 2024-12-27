package com.composablecode.voyagerstudy.application.ports.outgoing

import com.composablecode.voyagerstudy.domain.entity.Tweet

interface TweetRepository {
    fun findAllTweets(): List<Tweet>
}