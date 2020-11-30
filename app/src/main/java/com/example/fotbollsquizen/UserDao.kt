package com.example.fotbollsquizen

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


    @Dao
    interface UserDao {
        @Query("SELECT * FROM user")
        fun getAll(): List<User>

        @Insert
        fun insert(user:User)


        @Delete
        fun delete(user: User)


}