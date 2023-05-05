package com.example.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthAtricleActivity extends AppCompatActivity {

    private String[][] health_articles =
            {
                    {"Walking Daily","","","","Click For More Details"},
                    {"Home Care of COVID-19","","","","Click For More Details"},
                    {"Stop Smoking","","","","Click For More Details"},
                    {"Menstrual Cramps","","","","Click For More Details"},
                    {"Healthy Gut","","","","Click For More Details"},
            };
    private int[] image =
            {
                    R.drawable.imgo,
                    R.drawable.imgt,
                    R.drawable.imgth,
                    R.drawable.imgf,
                    R.drawable.imgfi,
            };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_atricle);

        btnBack = findViewById(R.id.buttonHABack);
        lst = findViewById(R.id.listViewHA);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthAtricleActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i<health_articles.length;i++)
        {
            item = new HashMap<String,String>();
            item.put("line1",health_articles[i][0]);
            item.put("line2",health_articles[i][1]);
            item.put("line3",health_articles[i][2]);
            item.put("line4",health_articles[i][3]);
            item.put("line5",health_articles[i][4]);
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(HealthAtricleActivity.this, HealthArticlesDetailsActivity.class);
                it.putExtra("text1", health_articles[i][0]);
                it.putExtra("text2", image[i]);
                startActivity(it);
            }
        });
    }
}