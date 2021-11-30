package com.microservices.ch3

import java.util.concurrent.ConcurrentHashMap

class CustomerServiceImpl : CustomerService {
    companion object {
        val initialCustomers = arrayOf(Customer(1,"Kotlin"),
            Customer(2, "Spring"),
            Customer(3, "Microservice"))
    }
    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int) = customers[id]

    override fun createCustomer(customer: Customer) {
        customers[customer.id] = customer
    }

    override fun deleteCustomer(id: Int) {
        customers.remove(id)
    }

    override fun updateCustomer(id: Int, customer: Customer) {
        deleteCustomer(id)
        createCustomer(customer)
    }

    override fun searchCustomer(nameFilter: String): List<Customer> =
        customers.filter {
            it.value.name.contains(nameFilter, true)
        }.map(Map.Entry<Int, Customer>::value).toList()
}