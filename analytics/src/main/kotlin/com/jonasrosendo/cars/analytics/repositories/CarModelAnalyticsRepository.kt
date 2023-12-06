package com.jonasrosendo.cars.analytics.repositories

import com.jonasrosendo.cars.analytics.entities.CarModelAnalyticsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarModelAnalyticsRepository : JpaRepository<CarModelAnalyticsEntity, Long> {
    fun findByModel(model: String?): List<CarModelAnalyticsEntity>

}