package com.bangkit.glendjetpack1.di

import com.bangkit.glendjetpack1.ui.detail.DetailFilmActivity
import com.bangkit.glendjetpack1.ui.detail.DetailShowActivity
import com.bangkit.glendjetpack1.ui.favorite.FavoriteActivity
import com.bangkit.glendjetpack1.ui.home.HomeActivity
import com.bangkit.glendjetpack1.ui.reminder.ReminderActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [HomeFragmentBuildersModule::class])
    abstract fun contributeHomeActivity(): HomeActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailFilmActivity(): DetailFilmActivity

    @ContributesAndroidInjector
    abstract fun contributeDetailShowActivity(): DetailShowActivity

    @ContributesAndroidInjector(modules = [FavoriteFragmentBuildersModule::class])
    abstract fun contributeFavoriteActivity(): FavoriteActivity

    @ContributesAndroidInjector
    abstract fun contributeReminderActivity(): ReminderActivity

}