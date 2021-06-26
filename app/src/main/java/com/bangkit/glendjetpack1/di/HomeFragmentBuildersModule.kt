package com.bangkit.glendjetpack1.di

import com.bangkit.glendjetpack1.ui.movies.MovieFragment
import com.bangkit.glendjetpack1.ui.shows.ShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeFilmFragment() : MovieFragment

    @ContributesAndroidInjector
    abstract fun contributeShowFragment() : ShowFragment

//    @ContributesAndroidInjector(modules = [FavoriteFragmentBuildersModule::class])
//    abstract fun contributeFavoriteFragment() : FavoriteFragment

//    @ContributesAndroidInjector
//    abstract fun contributeReminderFragment() : ReminderFragment
}