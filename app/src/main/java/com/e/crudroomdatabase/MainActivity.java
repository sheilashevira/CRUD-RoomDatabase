package com.e.crudroomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btnAdd, btnReset;
    RecyclerView recyclerView;

    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        btnAdd = findViewById(R.id.btn_add);
        btnReset = findViewById(R.id.btn_reset);
        recyclerView = findViewById(R.id.recyler_view);

        database = RoomDB.getInstance(this);
        dataList = database.mainDao().getAll();

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MainAdapter(MainActivity.this, dataList);
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sNamaNegara = editText.getText().toString().trim();
                if(!sNamaNegara.equals("")){
                    MainData data = new MainData();
                    data.setNamaNegara(sNamaNegara);
                    database.mainDao().insert(data);
                    editText.setText("");
                    dataList.addAll(database.mainDao().getAll());
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.mainDao().reset(dataList);
                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
