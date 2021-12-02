package com.microservices.ch4

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
class CustomerController {
    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping(value = ["/customer/{id}"])
    fun getCustomer(@PathVariable id : Int): ResponseEntity<Mono<Customer>> {
        val customer = customerService.getCustomer(id)
        return ResponseEntity(customer, HttpStatus.OK)
    }

    @GetMapping(value = ["/customers"])
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String) =
        customerService.searchCustomer(nameFilter)

    @PostMapping(value = ["/customer"])
    fun createCustomer(@RequestParam customerMono: Mono<Customer>) =
        ResponseEntity(customerService.createCustomer(customerMono), HttpStatus.CREATED)

}