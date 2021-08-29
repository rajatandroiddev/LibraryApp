package com.example.gormaloneapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gormaloneapp.data.local.ProductDao
import com.example.gormaloneapp.data.model.ProductData

@Database(entities = [ProductData::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "roomdb"
                ).fallbackToDestructiveMigration().build()
            }
            return instance as AppDatabase
        }
    }
}