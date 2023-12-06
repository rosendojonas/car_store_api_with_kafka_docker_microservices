package org.jonasrosendo.store.car.services

import org.jonasrosendo.store.car.dto.CarDTO
import org.springframework.stereotype.Service

@Service
interface CarService {

    fun createNewCar(carDTO: CarDTO)
    fun getAllCars(): List<CarDTO>
    fun updateCar(carDTO: CarDTO, id: Long)
    fun deleteCar(id: Long)
}