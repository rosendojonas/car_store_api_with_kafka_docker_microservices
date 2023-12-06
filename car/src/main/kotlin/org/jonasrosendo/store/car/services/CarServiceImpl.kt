package org.jonasrosendo.store.car.services

import org.jonasrosendo.store.car.dto.CarDTO
import org.jonasrosendo.store.car.entities.CarEntity
import org.jonasrosendo.store.car.mapper.toDto
import org.jonasrosendo.store.car.mapper.toEntity
import org.jonasrosendo.store.car.repositories.CarRepository
import org.springframework.stereotype.Service

@Service
class CarServiceImpl(
    private val carRepository: CarRepository,
) : CarService {

    override fun createNewCar(carDTO: CarDTO) {
        val carPostEntity: CarEntity = carDTO.toEntity()
        carRepository.save(carPostEntity)
    }

    override fun getAllCars(): List<CarDTO> {
        return carRepository.findAll().map { it.toDto() }
    }

    override fun updateCar(carDTO: CarDTO, id: Long) {
        val carEntity = carRepository.findById(id).orElseThrow { throw NoSuchElementException() }
        val updatedCarEntity = with(carEntity) {
            copy(
                model = carDTO.model ?: model,
                brand = carDTO.brand ?: brand,
                price = carDTO.price,
                description = carDTO.description ?: description,
                engineVersion = carDTO.engineVersion ?: engineVersion,
                phone = carDTO.phone ?: phone
            )
        }

        carRepository.save(updatedCarEntity)
    }

    override fun deleteCar(id: Long) {
        carRepository.deleteById(id)
    }
}