package com.nazlican.sisterslabproject.di

import com.nazlican.sisterslabproject.data.repo.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(retrofitModule: RetrofitModule) : ProductRepository {
        return ProductRepository(retrofitModule)
    }
}
