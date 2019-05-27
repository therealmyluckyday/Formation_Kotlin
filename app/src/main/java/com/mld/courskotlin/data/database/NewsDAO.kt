package com.mld.courskotlin.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mld.courskotlin.data.model.News

@Dao
interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(listNews: List<News>?)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(news: News?)


    @Query("SELECT * FROM News")
    fun fetchAll(): LiveData<List<News>>

}