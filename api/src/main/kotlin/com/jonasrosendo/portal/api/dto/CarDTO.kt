package com.jonasrosendo.portal.api.dto

import com.fasterxml.jackson.annotation.JsonInclude
import java.math.BigDecimal

@JsonInclude
data class CarDTO(
    private var ownerId: Long? = null,
    private var ownerName: String? = null,
    private var ownerType: String? = null,
    private var model: String? = null,
    private var brand: String? = null,
    private var price: BigDecimal? = null,
    private var description: String? = null,
    private var engineVersion: String? = null,
    private var city: String? = null,
    private var createdDate: String? = null,
    private var phone: String? = null
) {

    fun ownerId(ownerId: Long) = apply {
        this.ownerId = ownerId
    }

    fun ownerName(ownerName: String) = apply {
        this.ownerName = ownerName
    }

    fun ownerType(ownerType: String) = apply {
        this.ownerType = ownerType
    }

    fun model(model: String) = apply {
        this.model = model
    }

    fun brand(brand: String) = apply {
        this.brand = brand
    }

    fun price(price: BigDecimal) = apply {
        this.price = price
    }

    fun description(description: String) = apply {
        this.description = description
    }

    fun engineVersion(engineVersion: String) = apply {
        this.engineVersion = engineVersion
    }

    fun city(city: String) = apply {
        this.city = city
    }

    fun createdDate(createdDate: String) = apply {
        this.createdDate = createdDate
    }

    fun contract(phone: String) = apply {
        this.phone = phone
    }
}