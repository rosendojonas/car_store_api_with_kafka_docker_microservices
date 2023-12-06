package com.jonasrosendo.portal.api.services

import com.jonasrosendo.portal.api.dto.CarPostDTO
import org.springframework.stereotype.Service

@Service
interface CarPostService {

    fun findCarsForSale(): List<CarPostDTO>

    fun changeCarForSale(id: Long, carPostDTO: CarPostDTO)

    fun removeCarForSale(id: Long)
}