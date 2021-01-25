package dev.stocky37.pokemon

import dev.stocky37.pokemon.ext.pokeapi.api.PokeApiPokemon
import dev.stocky37.pokemon.ext.pokeapi.model.Pokemon
import io.smallrye.mutiny.Multi
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/pokemon")
class PokemonResource (@RestClient val client: PokeApiPokemon) {

	@GET
	fun list(): Multi<Pokemon> {
		return Multi.createFrom()
			.items(client.list().results.stream())
			.onItem()
			.transform { i -> client.get(i.name) }
	}
}