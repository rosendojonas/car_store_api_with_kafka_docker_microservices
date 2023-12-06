package com.jonasrosendo.portal.api.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude
data class OwnerPostDTO(
    val name: String,
    val type: String,
    val phone: String,
)
