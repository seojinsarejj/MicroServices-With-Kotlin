package com.microservices.ch3

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {
    @Autowired
    lateinit var customers : ConcurrentHashMap<Int, Customer>

    @GetMapping(value = ["/customers"])
    fun getCustomers() = customers.map(Map.Entry<Int, Customer>::value).toList()

    @GetMapping(value = ["/customer/{id}"])
    fun getCustomer(@PathVariable id : Int) = customers[id]

    @PostMapping(value = ["/customer"])
    fun createCustomer(@RequestBody customer: Customer) {
        customers[customer.id] = customer
    }

    @DeleteMapping(value = ["/customer/{id}"])
    fun deleteCustomer(@PathVariable id : Int) = customers.remove(id)

    @PutMapping(value = ["/customer/{id}"])
    fun updateCustomer(@PathVariable id : Int, @RequestBody customer: Customer) {
        customers.remove(id)
        customers[customer.id] = customer
    }

}

