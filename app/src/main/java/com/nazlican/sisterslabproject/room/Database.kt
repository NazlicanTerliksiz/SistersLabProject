package com.nazlican.sisterslabproject.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nazlican.sisterslabproject.data.model.ProductX
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Database(entities = [ProductX::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getfavoritesDao() : FavoritesDao
}