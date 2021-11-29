package com.microservices.ch3

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {
    @RequestMapping(value = ["/customer"], method = arrayOf(RequestMethod.GET))
    fun getCustomer() = "hello from a controller"
}