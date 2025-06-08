package com.pokedex.src.resource.repository

import com.pokedex.src.domain.entity.PokeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PokeTypeRepository: JpaRepository<PokeType , Long> {

    fun findByPokeId(pokeId: Long): List<PokeType>

    fun findByTypeId(typeId: Long): List<PokeType>
}