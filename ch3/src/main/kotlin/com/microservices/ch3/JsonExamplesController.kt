package com.microservices.ch3

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JsonExamplesController {
    @GetMapping(value = ["/json"])
    fun getJson() = SimpleObject("hi","kotlin")
}