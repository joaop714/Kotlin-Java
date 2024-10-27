package br.unimes.approom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.unimes.approom.dao.UserDao
import br.unimes.approom.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun userDao():UserDao
}