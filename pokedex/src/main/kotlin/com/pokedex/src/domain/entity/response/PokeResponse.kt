package com.pokedex.src.domain.entity.response

import com.fasterxml.jackson.annotation.JsonProperty

data class PokeResponse(
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: Sprites,
    val types: List<TypeSlot>
)

data class Sprites(
    @JsonProperty("front_default")
    val frontDefault: String
)

data class TypeSlot(
    val slot: Int,
    val type: TypeInfo
)

data class TypeInfo(
    val name: String
)
