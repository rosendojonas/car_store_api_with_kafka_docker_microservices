package org.jonasrosendo.store.car.mapper

import org.jonasrosendo.store.car.dto.CarDTO
import org.jonasrosendo.store.car.entities.CarEntity
import org.jonasrosendo.store.car.entities.OwnerEntity
import java.math.BigDecimal

fun CarEntity.toDto(): CarDTO =
    CarDTO(
        id = id,
        ownerId = ownerEntity.id ?: 0,
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

fun CarDTO.toEntity(ownerEntity: OwnerEntity): CarEntity =
    CarEntity(
        id = id,
        ownerEntity = ownerEntity,
        model = model ?: "",
        brand = brand ?: "",
        price = price ?: BigDecimal(0.0),
        description = description ?: "",
        engineVersion = engineVersion ?: "",
        city = city ?: "",
        createdDate = createdDate ?: "",
        phone = ownerEntity.phone
    )

