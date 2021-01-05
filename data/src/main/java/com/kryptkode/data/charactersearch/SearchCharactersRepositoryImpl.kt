package com.kryptkode.data.charactersearch

import com.kryptkode.data.charactersearch.mapper.CharacterInfoMapper
import com.kryptkode.data.charactersearch.remote.SearchCharactersRemote
import com.kryptkode.domain.charactersearch.entities.CharacterInfo
import com.kryptkode.domain.charactersearch.repo.SearchCharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchCharactersRepositoryImpl @Inject constructor(
    private val remote: SearchCharactersRemote,
    private val mapper: CharacterInfoMapper
) : SearchCharactersRepository {

    override fun searchCharacters(query: String): Flow<List<CharacterInfo>> {
        return flow {
            emit(remote.searchCharacters(query).map {
                mapper.mapFromEntity(it)
            })
        }
    }
}