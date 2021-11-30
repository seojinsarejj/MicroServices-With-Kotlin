package com.microservices.ch3

data class Customer (var id: Int = 0, var name: String = "", var telephone: Telephone) {
    data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
}