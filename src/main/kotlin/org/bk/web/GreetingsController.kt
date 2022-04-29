package org.bk.web

import org.bk.web.model.Message
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingsController {

    @GetMapping("/greetings")
    fun greetings(): Message {
        LOGGER.info("Greetings invoked. Responding with hello")
        return Message("hello")
    }

    @GetMapping("/greetings/{payload}")
    fun greetings(@PathVariable("payload") payload: String): Message {
        LOGGER.info("Greetings invoked. Responding with $payload")
        return Message(payload)
    }

    @GetMapping("/greetings/exception")
    fun greetingsWithException(): Message {
        LOGGER.info("Greetings invoked. About to throw an exception")
        throw RuntimeException("Throwing an explicit exception")
    }

    companion object {
        val LOGGER = LoggerFactory.getLogger(GreetingsController::class.java)
    }
}