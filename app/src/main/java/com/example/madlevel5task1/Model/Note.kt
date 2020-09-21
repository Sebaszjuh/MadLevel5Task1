package com.example.madlevel5task1.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "NoteTable")
data class Note (

    @ColumnInfo
    var title: String,

    @ColumnInfo
    var lastUpdated: Date,

    @ColumnInfo
    var text: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Long? = null
)