package com.composablecode.voyagerstudy.application.adapters

import com.composablecode.voyagerstudy.application.infra.database.DatabaseManager
import com.composablecode.voyagerstudy.application.ports.outgoing.TweetRepository
import com.composablecode.voyagerstudy.application.utils.mappers.TweetMapper
import com.composablecode.voyagerstudy.domain.entity.Tweet

class TweetRepositoryImpl(
    private val database: DatabaseManager,
    private val tweetMapper: TweetMapper
) :
    TweetRepository {
    override fun findAllTweets(): List<Tweet> {
        val tweets = database.queries.selectAllTweets().executeAsList()
        return tweetMapper.mapToImplModelList(tweets)
    }

}