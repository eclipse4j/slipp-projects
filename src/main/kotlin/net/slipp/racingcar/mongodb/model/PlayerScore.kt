package net.slipp.racingcar.mongodb.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection="playerScore")
class PlayerScore(
        @Id
        val name: String,
        @Field
        val score: String?
)