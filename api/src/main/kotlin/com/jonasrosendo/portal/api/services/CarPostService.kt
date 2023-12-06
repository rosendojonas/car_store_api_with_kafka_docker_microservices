package com.jonasrosendo.portal.api.services

import com.jonasrosendo.portal.api.dto.CarDTO
import org.springframework.stereotype.Service

@Service
interface CarPostService {

    fun findCarsForSale(): List<CarDTO>

    fun changeCarForSale(id: Long, carDTO: CarDTO)

    fun removeCarForSale(id: Long)
}