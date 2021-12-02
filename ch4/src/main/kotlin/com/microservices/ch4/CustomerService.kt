package com.microservices.ch4

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CustomerService {
    fun getCustomer(id : Int) : Mono<Customer>?
    fun searchCustomer(nameFilter: String) : Flux<Customer>
}