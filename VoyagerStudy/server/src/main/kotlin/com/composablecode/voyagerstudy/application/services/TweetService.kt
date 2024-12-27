package com.composablecode.voyagerstudy.application.services

import com.composablecode.voyagerstudy.application.ports.incoming.TweetQueryPort
import com.composablecode.voyagerstudy.application.ports.outgoing.TweetRepository
import com.composablecode.voyagerstudy.domain.entity.Tweet


class TweetService(private val tweetRepository: TweetRepository) : TweetQueryPort {
    override fun getAllTweets(): List<Tweet> {
        return tweetRepository.findAllTweets()
    }
}