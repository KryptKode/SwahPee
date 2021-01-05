package com.kryptkode.remote

import com.kryptkode.data.charactersearch.entities.CharacterInfoEntity
import com.kryptkode.data.charactersearch.remote.SearchCharactersRemote
import com.kryptkode.remote.api.SwahPeeServiceApi
import com.kryptkode.remote.mapper.CharacterRemoteMapper
import javax.inject.Inject

class SearchCharactersRemoteImpl @Inject constructor(
    private val serviceApi: SwahPeeServiceApi,
    private val mapper: CharacterRemoteMapper
) : SearchCharactersRemote {

    override suspend fun searchCharacters(query: String): List<CharacterInfoEntity> {
        return serviceApi.searchCharacters(query).results.map { character ->
            mapper.mapToEntity(character)
        }
    }
}