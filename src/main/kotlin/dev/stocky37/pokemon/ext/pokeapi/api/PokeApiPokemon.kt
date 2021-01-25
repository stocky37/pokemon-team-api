package dev.stocky37.pokemon.ext.pokeapi.api

import dev.stocky37.pokemon.ext.pokeapi.model.NamedApiResourceList
import dev.stocky37.pokemon.ext.pokeapi.model.Pokemon
import io.quarkus.cache.CacheResult
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.annotations.jaxrs.PathParam
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.GET
import javax.ws.rs.Path

@ApplicationScoped
@RegisterRestClient(baseUri = "https://pokeapi.co/api")
@Path("/v2/pokemon")
interface PokeApiPokemon {
	@CacheResult(cacheName = "pokemon.all")
	@GET
	fun list(): NamedApiResourceList

	@GET
	@Path("/{name}")
	fun get(@PathParam name: String): Pokemon
}