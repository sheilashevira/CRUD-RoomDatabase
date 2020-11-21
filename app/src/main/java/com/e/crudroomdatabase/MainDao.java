package com.e.crudroomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDao {

    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    //Delete query
    @Delete
    void delete(MainData mainData);

    //Delete semua query
    @Delete
    void reset(List<MainData> mainData);

    @Query("UPDATE negara SET nama_negara = :sNamaNegara WHERE id = :sId")
    void update(int sId, String sNamaNegara);

    //Get all data query
    @Query("SELECT * FROM negara")
    List<MainData> getAll();
}
