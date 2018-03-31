package net.slipp.route

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameStartControllerTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun reativeIndex() {
        webTestClient.get().uri("/reactive/index")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith {
                    Assertions.assertThat(String(it.responseBody)).isEqualTo("Hello World")
                }
    }
    @Test
    fun reativeIndexHtml() {
        webTestClient.get().uri("/reactive/role")
                .accept(MediaType.TEXT_HTML)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith {
                    println(String(it.responseBody))
                }
    }
}

