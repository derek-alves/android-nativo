package com.composablecode.voyagerstudy.application.infra.routes

import com.composablecode.voyagerstudy.application.ports.incoming.TweetQueryPort
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route


fun Route.tweetRoutes(tweetQueryPort: TweetQueryPort) {
    route("/tweets") {
        get {
            try {
                val tweets = tweetQueryPort.getAllTweets()
                call.respond(tweets)

            } catch (e: Exception) {
                call.respond(
                    HttpStatusCode.InternalServerError,
                )
            }
        }
    }
}