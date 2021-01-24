package dev.stocky37.pokemon.resteasyjackson

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/pokemon")
class PokemonResource {
	@GET
	fun get(): Pokemon {
		return Pokemon(1, "Bulbasaur")
	}
}