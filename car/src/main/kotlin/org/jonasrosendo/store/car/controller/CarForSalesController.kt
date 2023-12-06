package org.jonasrosendo.store.car.controller

import org.jonasrosendo.store.car.dto.CarDTO
import org.jonasrosendo.store.car.services.CarService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/sales")
class CarForSalesController(
    private val carService: CarService
) {
    @GetMapping
    fun getCarsForSale(): ResponseEntity<List<CarDTO>> {
        return ResponseEntity.status(HttpStatus.OK).body(carService.getAllCarForSale())
    }

    @PutMapping("/car/{id}")
    fun changeCarSale(@RequestBody carPostDTO: CarDTO, @PathVariable("id") id: Long): ResponseEntity<*> {
        carService.updateCar(carPostDTO, id)
        return ResponseEntity<Any>(HttpStatus.OK)
    }

    @DeleteMapping("/car/{id}")
    fun changeCarSale(@PathVariable("id") id: Long): ResponseEntity<*>? {
        carService.deleteCar(id)
        return ResponseEntity<Any>(HttpStatus.NO_CONTENT)
    }


}