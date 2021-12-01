package com.microservices.ch4

interface CustomerService {
    fun getCustomer(id : Int) : Customer?
    fun searchCustomer(nameFilter: String) : List<Customer>
}