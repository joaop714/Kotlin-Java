package br.unimes.approom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.unimes.approom.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll():List<User>
    @Insert
    suspend fun insertAll(vararg user: User)
}