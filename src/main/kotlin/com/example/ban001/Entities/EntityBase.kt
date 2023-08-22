package com.example.ban001.Entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.Date

enum class StatusInfo{
    Active,
    Pending,
    Deleted,
}

@Entity
public open class EntityBase{
    @GeneratedValue
    @Id
    var id: Int  = 0;
    var createdAt: Date = Date()
    var updatedAt: Date? = Date();
    var Status: StatusInfo = StatusInfo.Active;
}