package com.kryptkode.swahpee.navigator

import com.kryptkode.characters.CharactersNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
interface ScreenNavigatorModule {

    @Binds
    @ActivityScoped
    fun provideScreenNavigator(navigator: ScreenNavigator):CharactersNavigator
}