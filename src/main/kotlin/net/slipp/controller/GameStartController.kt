package net.slipp.controller


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GameStartController {

    @GetMapping("/game/on")
    fun on():String {
        return "On!"
    }
}
