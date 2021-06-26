package com.bangkit.glendjetpack1.di

import android.app.Application
import com.bangkit.glendjetpack1.data.source.ContentRepository
import com.bangkit.glendjetpack1.data.source.local.LocalDataSource
import com.bangkit.glendjetpack1.data.source.local.room.ContentDao
import com.bangkit.glendjetpack1.data.source.local.room.ContentDatabase
import com.bangkit.glendjetpack1.data.source.remote.RemoteDataSource
import com.bangkit.glendjetpack1.data.source.remote.api.ApiService
import com.bangkit.glendjetpack1.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    companion object {

        @Singleton
        @Provides
        fun provideContentDatabase(application: Application): ContentDatabase =
            ContentDatabase.getInstance(application)

        @Singleton
        @Provides
        fun provideContentDao(contentDatabase: ContentDatabase): ContentDao =
            contentDatabase.contentDao()

        @Singleton
        @Provides
        fun provideLocalDataSource(contentDao: ContentDao): LocalDataSource =
            LocalDataSource(contentDao)

        @Singleton
        @Provides
        fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource =
            RemoteDataSource(apiService)

        @Singleton
        @Provides
        fun provideContentRepository(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource
        ): ContentRepository = ContentRepository(remoteDataSource, localDataSource)

        @Singleton
        @Provides
        fun provideViewModelFactory(contentRepository: ContentRepository): ViewModelFactory =
            ViewModelFactory(contentRepository)

    }
}