package com.pokedex.src.domain.service

import com.pokedex.src.domain.entity.Pokemon
import com.pokedex.src.domain.entity.Type
import com.pokedex.src.domain.entity.response.PokeResponse
import com.pokedex.src.resource.repository.PokeTypeRepository
import com.pokedex.src.resource.repository.PokemonRepository
import com.pokedex.src.resource.repository.TypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PokemonService(
    private val pokemonRepository: PokemonRepository,
    private val typeRepository: TypeRepository,
    private val pokeTypeRepository: PokeTypeRepository
){
    private val restTemplate = RestTemplate()

    fun findAndPersist(nome: String) {
        val url = "https://pokeapi.co/api/v2/pokemon/$nome"
        val response = restTemplate.getForObject(url, PokeResponse::class.java)

        response?.let { pokeResponse ->
            val types = pokeResponse.types.map {
                typeRepository.findByName(it.type.name) ?: typeRepository.save(Type(name = it.type.name))
            }.toSet()

            val pokemon = Pokemon(
                name = pokeResponse.name,
                height = pokeResponse.height,
                weight = pokeResponse.weight,
                imageUrl = pokeResponse.sprites.frontDefault,
                types = types
            )

            pokemonRepository.save(pokemon)
        }
    }

    fun findAll(): List<Pokemon> {
        return pokemonRepository.findAll()
    }

    fun findAllPokemon(){

    }

}
