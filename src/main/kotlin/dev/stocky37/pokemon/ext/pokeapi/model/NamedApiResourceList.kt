package dev.stocky37.pokemon.ext.pokeapi.model

data class NamedApiResourceList(
	val count: Int,
	val next: String?,
	val previous: String?,
	val results: List<NamedApiResource>
)