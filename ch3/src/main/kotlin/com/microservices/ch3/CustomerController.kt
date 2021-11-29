package com.microservices.ch3

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {
    @Autowired
    lateinit var customers : ConcurrentHashMap<Int, Customer>

    @RequestMapping(value = ["/customers"], method = arrayOf(RequestMethod.GET))
    fun getCustomers() = customers.map(Map.Entry<Int, Customer>::value).toList()

    @RequestMapping(value = ["/customer/{id}"],method = arrayOf(RequestMethod.GET))
    fun getCustomer(@PathVariable id : Int) = customers[id]

    @RequestMapping(value = ["/customer"], method = arrayOf(RequestMethod.POST))
    fun createCustomer(@RequestBody customer: Customer) {
        customers[customer.id] = customer
    }

    @RequestMapping(value = ["/customer/{id}"], method = arrayOf(RequestMethod.DELETE))
    fun deleteCustomer(@PathVariable id : Int) = customers.remove(id)

}

