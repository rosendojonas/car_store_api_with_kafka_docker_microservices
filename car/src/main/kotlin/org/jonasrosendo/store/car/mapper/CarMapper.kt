package org.jonasrosendo.store.car.mapper

import org.jonasrosendo.store.car.dto.CarDTO
import org.jonasrosendo.store.car.entities.CarEntity
import org.jonasrosendo.store.car.entities.OwnerEntity

fun CarEntity.toDto(): CarDTO =
    CarDTO(
        id = id,
        ownerId = ownerEntity.id,
        ownerName = ownerEntity.name,
        ownerType = ownerEntity.type,
        model = model,
        brand = brand,
        price = price,
        description = description,
        engineVersion = engineVersion,
        city = city,
        createdDate = createdDate,
        phone = ownerEntity.phone
    )

fun CarDTO.toEntity(): CarEntity =
    CarEntity(
        id = id,
        ownerEntity = OwnerEntity(ownerId, ownerName ?: "", ownerType ?: "", phone ?: ""),
        model = model ?: "",
        brand = brand ?: "",
        price = price,
        description = description ?: "",
        engineVersion = engineVersion ?: "",
        city = city ?: "",
        createdDate = createdDate,
        phone = phone ?: ""
    )

