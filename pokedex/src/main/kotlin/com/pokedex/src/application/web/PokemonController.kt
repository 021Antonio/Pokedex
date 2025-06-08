package com.pokedex.src.application.web

import com.pokedex.src.domain.service.PokemonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/pokemon")
class PokemonController() {

    @Autowired
    lateinit var pokemonService: PokemonService

    @PostMapping("/{nome}")
    fun addPokemon(@PathVariable nome: String) {
        pokemonService.findAndPersist(nome)
    }

    @GetMapping
    fun listAll() = pokemonService.findAll()
}
