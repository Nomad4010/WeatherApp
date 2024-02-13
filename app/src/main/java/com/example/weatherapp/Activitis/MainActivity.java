package com.example.weatherapp.Activitis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.weatherapp.Adapters.HourlyAdapters;
import com.example.weatherapp.Domains.Hourly;
import com.example.weatherapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        setVariable();

    }

    private void setVariable() {
        TextView nextBtn=findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FutureActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<Hourly> items=new ArrayList<>();

        items.add(new Hourly("21:00",28,"cloudy"));
        items.add(new Hourly("23:00",29,"sunny"));
        items.add(new Hourly("00:00",30,"wind"));
        items.add(new Hourly("01:00",29,"rain"));
        items.add(new Hourly("02:00",27,"storm"));

        recyclerView=findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterHourly=new HourlyAdapters(items);
        recyclerView.setAdapter(adapterHourly);

    }
}