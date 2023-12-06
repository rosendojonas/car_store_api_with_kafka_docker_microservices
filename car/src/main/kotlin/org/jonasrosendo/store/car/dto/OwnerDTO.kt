package org.jonasrosendo.store.car.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude
data class OwnerDTO(
    val name: String,
    val type: String,
    val phone: String,
)
