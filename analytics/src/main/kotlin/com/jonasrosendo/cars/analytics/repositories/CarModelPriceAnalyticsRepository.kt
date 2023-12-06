package com.jonasrosendo.cars.analytics.repositories

import com.jonasrosendo.cars.analytics.entities.CarModelPriceAnalyticsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarModelPriceAnalyticsRepository : JpaRepository<CarModelPriceAnalyticsEntity, Long> {

}