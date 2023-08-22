package com.example.ban001.controller

import com.example.ban001.Entities.Address
import com.example.ban001.Entities.AppUser
import com.example.ban001.Repository.IAppUserRepository
import com.example.ban001.RequestModels.AppUserRequestModel
import jakarta.persistence.Entity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/appuser")
class AppUserController(val appUserRepository: IAppUserRepository) {

    @GetMapping("/view")
    fun viewTransfers() : HttpStatus{
        return HttpStatus.OK;
    }

    @PostMapping("/create")
    fun create(@RequestBody receiveUserRequestModelForCreate: AppUserRequestModel) : HttpStatus{
        val appUserFromRequestModelForCreate = AppUser()
        appUserFromRequestModelForCreate.fullname = appUserFromRequestModelForCreate.fullname;
        appUserFromRequestModelForCreate.phoneNumber = appUserFromRequestModelForCreate.phoneNumber;
        appUserRepository.save(appUserFromRequestModelForCreate);
        return HttpStatus.OK;
    }

    @GetMapping("/getById")
    fun getById(@RequestBody userId: Int) : AppUser? {
        val userGotById: Optional<AppUser> = appUserRepository.findById(userId)
        if(userGotById.isEmpty){
            return null;
        }
        val userById: AppUser = userGotById.get()
        return userById;
    }

    @PostMapping("/update")
    fun update(@RequestBody userId : Int, receiveUserRequestModelForUpdate : AppUserRequestModel) : HttpStatus{
        val optionalUserGotByIdValue: Optional<AppUser> = appUserRepository.findById(userId)

        if(optionalUserGotByIdValue.isEmpty)
            return HttpStatus.BAD_REQUEST;

        val userForUpdateFromOptionalValue: AppUser = optionalUserGotByIdValue.get()

        userForUpdateFromOptionalValue.city = receiveUserRequestModelForUpdate.City;
        userForUpdateFromOptionalValue.state = receiveUserRequestModelForUpdate.State
        userForUpdateFromOptionalValue.fullname = receiveUserRequestModelForUpdate.fullanme
        userForUpdateFromOptionalValue.phoneNumber = receiveUserRequestModelForUpdate.phoneNumber
        userForUpdateFromOptionalValue.updatedAt = Date()

        appUserRepository.save(userForUpdateFromOptionalValue);

        return HttpStatus.OK
    }

    @PostMapping("/delete")
    fun deleteById(@RequestBody userId : Int) : HttpStatus{
        val optionalUserGotByIdValue: Optional<AppUser> = appUserRepository.findById(userId)

        if(optionalUserGotByIdValue.isEmpty)
            return HttpStatus.BAD_REQUEST;

        val userForUpdateFromOptionalValue: AppUser = optionalUserGotByIdValue.get()

        appUserRepository.delete(userForUpdateFromOptionalValue);

        return HttpStatus.OK;
    }
}