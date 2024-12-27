package com.composablecode.voyagerstudy.application.utils.mappers

import com.composablecode.core.mapper.BaseMapper
import com.composablecode.voyagerstudy.domain.entity.Tweet
import com.composablecode.voyagerstudy.Tweet as TweetDto


class TweetMapper : BaseMapper<TweetDto, Tweet> {
    override fun mapToImplModel(from: TweetDto): Tweet {
        return Tweet(
            id = from.id,
            userId = from.userID,
            userName = from.userName,
            text = from.text,
            likeQty = from.likeQty,
            identifier = from.identifier,
            image = from.image,
            createdAt = EpochMillisMapper.toEpochMillis(from.createdAt)
        )
    }

    override fun mapFromImplModel(to: Tweet): TweetDto {
        return TweetDto(
            id = to.id,
            userName = to.userName,
            text = to.text,
            userID = to.userId,
            likeQty = to.likeQty,
            identifier = to.identifier,
            image = to.image,
            createdAt = EpochMillisMapper.fromEpochMillis(to.createdAt)
        )
    }

    override fun mapToImplModelList(fromList: List<TweetDto>): List<Tweet> {
        return fromList.map {
            mapToImplModel(it)
        }
    }

    override fun mapFromImplModelList(toList: List<Tweet>): List<TweetDto> {
        return toList.map {
            mapFromImplModel(it)
        }
    }

}