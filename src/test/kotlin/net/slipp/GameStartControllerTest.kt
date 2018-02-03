package net.slipp

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameStartControllerTest {
    @Autowired
    lateinit var webClient : WebTestClient

    @Test
    fun helloWorld() {
        webClient.get().uri("/game/on")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith {
                    Assertions.assertThat(String(it.responseBody)).isEqualTo("On!")
                }
    }
}

