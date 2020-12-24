package com.kryptkode.data.charactersearch

import com.kryptkode.data.charactersearch.mapper.CharacterMapper
import com.kryptkode.data.charactersearch.remote.SearchCharactersRemote
import com.kryptkode.domain.charactersearch.entities.Character
import com.kryptkode.domain.charactersearch.repo.SearchCharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchCharactersRepositoryImpl @Inject constructor(
    private val remote: SearchCharactersRemote,
    private val mapper: CharacterMapper
) : SearchCharactersRepository {

    override fun searchCharacters(query: String): Flow<List<Character>> {
        return flow {
            emit(remote.searchCharacters(query).map {
                mapper.mapFromEntity(it)
            })
        }
    }
}