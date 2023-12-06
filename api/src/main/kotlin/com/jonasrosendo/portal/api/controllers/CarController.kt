package com.jonasrosendo.portal.api.controllers

import com.jonasrosendo.portal.api.dto.CarPostDTO
import com.jonasrosendo.portal.api.message.KafkaProducerMessage
import com.jonasrosendo.portal.api.services.CarPostServiceImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/cars")
class CarController(
    private val carPostService: CarPostServiceImpl,
    private val kafkaProducerMessage: KafkaProducerMessage
) {
    private val LOG: Logger = LoggerFactory.getLogger(CarController::class.java)

    @PostMapping
    fun createCar(@RequestBody carPostDTO: CarPostDTO): ResponseEntity<*> {
        LOG.info("USANDO EVENTOS/MENSAGENS KAFKA - Producer Car Post information: {}", carPostDTO)
        kafkaProducerMessage.sendMessage(carPostDTO)
        return ResponseEntity<Any>(HttpStatus.CREATED)
    }

    @GetMapping
    fun getCars(): ResponseEntity<List<CarPostDTO>> {
        return ResponseEntity.status(HttpStatus.OK).body(carPostService.findCarsForSale())
    }

    @PutMapping("/{id}")
    fun updateCar(@RequestBody carPostDTO: CarPostDTO, @PathVariable("id") id: Long): ResponseEntity<*>? {
        carPostService.changeCarForSale(id, carPostDTO)
        return ResponseEntity<Any>(HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteCar(@PathVariable("id") id: Long): ResponseEntity<*>? {
        carPostService.removeCarForSale(id)
        return ResponseEntity<Any>(HttpStatus.OK)
    }

}