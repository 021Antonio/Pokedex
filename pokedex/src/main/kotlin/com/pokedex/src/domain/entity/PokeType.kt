package com.pokedex.src.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
data class PokeType(
    @Column(name = "pokemon_id", nullable = false)
    val pokeId: Long? = null,

    @Column(name = "type_id", nullable = false)
    val typeId: Long? = null,
)