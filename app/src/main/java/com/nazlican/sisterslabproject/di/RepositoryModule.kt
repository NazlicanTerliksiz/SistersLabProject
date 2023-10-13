package com.nazlican.sisterslabproject.di

import android.content.Context
import androidx.room.Room
import com.nazlican.sisterslabproject.data.repo.ProductRepository
import com.nazlican.sisterslabproject.room.Database
import com.nazlican.sisterslabproject.room.FavoritesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
class RepositoryModule {

    //fun provideProductRepository(retrofitModule: RetrofitModule, database: Database) : ProductRepository {
    //    return ProductRepository(retrofitModule, database)
    //}

    fun provideFavoriteFavoritesDao(@ApplicationContext context:Context) : FavoritesDao {
        val db = Room.databaseBuilder(context, Database::class.java, "eCommerce.db")
            .createFromAsset("eCommerce.db").build()
        return db.getfavoritesDao()
    }
}
