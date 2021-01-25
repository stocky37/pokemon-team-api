package dev.stocky37.pokemon.ext.pokeapi

import dev.stocky37.pokemon.ext.pokeapi.model.NamedApiResource
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/pokemon")
interface PokeApiPokemon {
	@GET
	fun list(): NamedApiResource

	@GET
	@Path("/{id}")
	fun get(id: Int)
}