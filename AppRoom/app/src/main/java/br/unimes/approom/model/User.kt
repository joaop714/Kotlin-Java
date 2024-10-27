package br.unimes.approom.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val uid:Int,
    @ColumnInfo(name = "firstName")
    val firstName:String?,
    @ColumnInfo(name = "lastName")
    val lastName:String?
)
