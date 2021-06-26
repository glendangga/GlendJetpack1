package com.bangkit.glendjetpack1.di

import com.bangkit.glendjetpack1.ui.favorite.FavoriteFilmFragment
import com.bangkit.glendjetpack1.ui.favorite.FavoriteShowFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoriteFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeFavoriteMovieFragment() : FavoriteFilmFragment

    @ContributesAndroidInjector
    abstract fun contributeFavoriteTvShowFragment() : FavoriteShowFragment


}