package com.kryptkode.swahpee.navigator

import android.app.Activity
import androidx.navigation.findNavController
import com.kryptkode.characters.CharacterUi
import com.kryptkode.characters.CharactersNavigator
import com.kryptkode.characters.search.SearchCharactersFragmentDirections
import com.kryptkode.swahpee.R
import javax.inject.Inject

class ScreenNavigator @Inject constructor(private val activity: Activity) :
    CharactersNavigator {

    private val navController by lazy {
        activity.findNavController(R.id.nav_host)
    }

    override fun navigateUp() {
        navController.navigateUp()
    }

    override fun toCharacterDetail(character: CharacterUi) {
        navController.navigate(
            SearchCharactersFragmentDirections
                .actionSearchCharactersToCharacterDetail(character)
        )
    }
}