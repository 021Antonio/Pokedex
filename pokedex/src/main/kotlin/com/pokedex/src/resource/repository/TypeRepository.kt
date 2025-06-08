package com.pokedex.src.resource.repository

import com.pokedex.src.domain.entity.Type
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TypeRepository: JpaRepository<Type, Long> {

    fun findByName(name: String): Type?
}