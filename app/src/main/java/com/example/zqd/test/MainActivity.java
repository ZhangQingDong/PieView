package com.example.zqd.test;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PieView pieView;
    private Button button;
    private List<DataBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new DataBean("北京", 100, Color.parseColor("#ffff00")));
        list.add(new DataBean("上海", 20, Color.parseColor("#ff0000")));
        list.add(new DataBean("广州", 60, Color.parseColor("#00ff00")));
        list.add(new DataBean("深圳", 80, Color.parseColor("#0000ff")));
    }

    private void initViews() {
        pieView = findViewById(R.id.pieView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieView.setData(list);
            }
        });
    }
}
