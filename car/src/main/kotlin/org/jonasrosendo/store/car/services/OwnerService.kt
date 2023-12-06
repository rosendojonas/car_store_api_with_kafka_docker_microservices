package org.jonasrosendo.store.car.services

import org.jonasrosendo.store.car.dto.OwnerDTO
import org.springframework.stereotype.Service


@Service
interface OwnerService {
    fun createOwnerPost(ownerDTO: OwnerDTO)
}
