package org.jonasrosendo.store.car.repositories

import org.jonasrosendo.store.car.entities.CarEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository : JpaRepository<CarEntity, Long> {

}
