package com.jonasrosendo.cars.analytics.services

import com.jonasrosendo.cars.analytics.dto.CarDTO
import org.springframework.stereotype.Service

@Service
interface AnalyticsService {

    fun saveAnalytics(carDTO: CarDTO)
}