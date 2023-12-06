package com.jonasrosendo.portal.api.services

import com.jonasrosendo.portal.api.clients.CarPostStoreClient
import com.jonasrosendo.portal.api.dto.CarDTO
import org.springframework.stereotype.Service

@Service
class CarPostServiceImpl(
    private val carPostStoreClient: CarPostStoreClient
) : CarPostService {

    override fun findCarsForSale(): List<CarDTO> {
        return carPostStoreClient.getCarForSale()
    }

    override fun changeCarForSale(id: Long, carDTO: CarDTO) {
        carPostStoreClient.updateCarForSaleClient(carDTO, id)
    }

    override fun removeCarForSale(id: Long) {
        carPostStoreClient.deleteCarForSaleClient(id)
    }
}