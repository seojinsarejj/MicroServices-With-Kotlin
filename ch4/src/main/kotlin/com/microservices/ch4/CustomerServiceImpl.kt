package com.microservices.ch4

import com.microservices.ch4.Customer.Telephone
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono
import reactor.kotlin.core.publisher.toMono
import java.util.concurrent.ConcurrentHashMap

@Component
class CustomerServiceImpl : CustomerService {
    companion object {
        val initialCustomers = arrayOf(Customer(1,"Kotlin"),
        Customer(2,"Spring"),
        Customer(3,"Microservice", Telephone("+44","7123456789")))
    }
    val customers = ConcurrentHashMap<Int,Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int) = customers[id]?.toMono()

    override fun searchCustomer(nameFilter: String): Flux<Customer> =
        customers.filter {
            it.value.name.contains(nameFilter, true)
        }.map(Map.Entry<Int, Customer>::value).toFlux()

    override fun createCustomer(customerMono: Mono<Customer>): Mono<*> {
        return customerMono.subscribe {
            customers[it.id] = it
        }.toMono()
    }

}