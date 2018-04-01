package net.slipp.racingcar.mongodb.repository

import net.slipp.racingcar.mongodb.model.PlayerScore
import org.springframework.data.mongodb.repository.MongoRepository

interface PlayerScoreRepository: MongoRepository<PlayerScore, String>{

}