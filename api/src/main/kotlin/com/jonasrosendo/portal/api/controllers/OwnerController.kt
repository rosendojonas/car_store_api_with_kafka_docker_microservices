package com.jonasrosendo.portal.api.controllers

import com.jonasrosendo.portal.api.dto.OwnerPostDTO
import com.jonasrosendo.portal.api.services.OwnerPostService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/owners")
class OwnerController(
    private val ownerPostService: OwnerPostService,
) {
    private val LOG: Logger = LoggerFactory.getLogger(OwnerController::class.java)

    @PostMapping
    fun createOwnerCar(@RequestBody ownerPostDTO: OwnerPostDTO): ResponseEntity<*>? {
        LOG.info("USANDO API REST - Criando Novo Usuário: {}", ownerPostDTO)
        ownerPostService.createOwner(ownerPostDTO)
        return ResponseEntity<Any>(HttpStatus.CREATED)
    }

}