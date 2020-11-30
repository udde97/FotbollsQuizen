package com.example.fotbollsquizen

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


    @Entity
    data class User(@PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "USERNAME") val name: String?

    )
