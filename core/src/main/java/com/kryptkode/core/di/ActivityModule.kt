package com.kryptkode.core.di

import android.content.Context
import android.view.LayoutInflater
import com.kryptkode.commonandroid.ToastHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    @Provides
    fun provideLayoutInflater(@ActivityContext context: Context): LayoutInflater {
        return LayoutInflater.from(context)
    }

    @Provides
    fun provideToastHelper(@ActivityContext context: Context): ToastHelper {
        return ToastHelper(context)
    }
}