package org.jonasrosendo.store.car.services

import org.jonasrosendo.store.car.dto.OwnerDTO
import org.jonasrosendo.store.car.entities.OwnerEntity
import org.jonasrosendo.store.car.repositories.OwnerRepository
import org.springframework.stereotype.Service

@Service
class OwnerServiceImpl(
    private val ownerRepository: OwnerRepository
) : OwnerService{

    override fun createOwnerPost(ownerDTO: OwnerDTO) {
        val owner = OwnerEntity(
            name = ownerDTO.name,
            type = ownerDTO.type,
            phone = ownerDTO.phone
        )
        ownerRepository.save(owner)
    }

}