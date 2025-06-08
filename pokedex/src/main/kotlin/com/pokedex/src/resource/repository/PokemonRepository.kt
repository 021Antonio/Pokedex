package com.pokedex.src.resource.repository

import com.pokedex.src.domain.entity.Pokemon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepository : JpaRepository<Pokemon, Long>