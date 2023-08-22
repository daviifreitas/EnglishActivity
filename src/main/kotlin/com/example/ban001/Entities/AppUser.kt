package com.example.ban001.Entities

import jakarta.persistence.Entity

data class Address(var Country: String, var State: String, var City: String, var street: String, var number: Int){}

@Entity
class AppUser : EntityBase() {
    var fullname: String = "";
    var phoneNumber: String = "000-000";
    var city: String = "";
    var state: String = "";
    var country: String = "";
}