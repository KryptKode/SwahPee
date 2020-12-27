package com.kryptkode.remote

import com.kryptkode.data.charactersearch.entities.CharacterEntity
import com.kryptkode.data.charactersearch.remote.SearchCharactersRemote

class SearchCharactersRemoteImpl : SearchCharactersRemote {

    override suspend fun searchCharacters(query: String): List<CharacterEntity> {
        TODO()
    }
}