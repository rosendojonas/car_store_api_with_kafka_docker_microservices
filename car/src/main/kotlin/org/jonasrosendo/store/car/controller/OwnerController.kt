package org.jonasrosendo.store.car.controller

import org.jonasrosendo.store.car.dto.OwnerDTO
import org.jonasrosendo.store.car.services.OwnerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/owners")
class OwnerPostController(
    private val ownerService: OwnerService
) {
    @PostMapping
    fun createOwner(@RequestBody ownerDTO: OwnerDTO): ResponseEntity<*> {
        ownerService.createOwnerPost(ownerDTO)
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}