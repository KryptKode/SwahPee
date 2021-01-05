package com.kryptkode.domain.charactersearch.usecases

import com.kryptkode.domain.charactersearch.entities.CharacterInfo
import com.kryptkode.domain.charactersearch.entities.CharacterInfo.Companion.NO_CHARACTER_INFO
import com.kryptkode.domain.charactersearch.repo.CharacterDetailRepository
import com.kryptkode.domain.dispatchers.AppDispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchCharacterInfoUseCase @Inject constructor(
    private val dispatchers: AppDispatchers,
    private val repository: CharacterDetailRepository) {

    fun fetchCharacterInfo(characterUrl:String):Flow<CharacterInfo>{
        if (characterUrl.isEmpty()) {
            return flowOf(NO_CHARACTER_INFO)
        }
        return repository.getCharacterInfo(characterUrl).flowOn(dispatchers.io)
    }
}