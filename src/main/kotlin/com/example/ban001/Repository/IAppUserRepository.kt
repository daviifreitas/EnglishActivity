package com.example.ban001.Repository

import com.example.ban001.Entities.AppUser
import org.hibernate.service.spi.InjectService
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IAppUserRepository: CrudRepository<AppUser, Int> {
}