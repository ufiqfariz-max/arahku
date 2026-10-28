package com.example.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_doa")
data class DoaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "arabic")
    val arabic: String,

    @ColumnInfo(name = "latin")
    val latin: String,

    @ColumnInfo(name = "translation")
    val translation: String,

    @ColumnInfo(name = "category")
    val category: String,

    @ColumnInfo(name = "source", defaultValue = "Kitab Hishnul Muslim")
    val source: String = "Kitab Hishnul Muslim",

    @ColumnInfo(name = "reference", defaultValue = "")
    val reference: String = "",

    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean = false
)
