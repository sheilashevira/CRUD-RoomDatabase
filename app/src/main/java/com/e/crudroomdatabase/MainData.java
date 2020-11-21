package com.e.crudroomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "negara")
public class MainData implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nama_negara")
    private String namaNegara;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaNegara() {
        return namaNegara;
    }

    public void setNamaNegara(String namaNegara) {
        this.namaNegara = namaNegara;
    }


}
