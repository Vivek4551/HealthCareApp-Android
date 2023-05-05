package com.example.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Teacher Name : Karan Aujla","Location : 34-201","College id : 26616","Mobile no : 9879875431","Exp : 5yrs"},
                    {"Teacher Name : Lakshyaa Chaudhary","Location : 32-201","College id : 26916","Mobile no : 9879812345","Exp : 2yrs"},
                    {"Teacher Name : Dilip Kumar","Location : 32-505","College id : 23918","Mobile no : 6298756432","Exp : 7yrs"},
                    {"Teacher Name : Jyoti Pasricha","Location : 32-201","College id : 24567","Mobile no : 9567432189","Exp : 12yrs"},
                    {"Teacher Name : Mahe Alam","Location : 32-201","College id : 21501","Mobile no : 8765438921","Exp : 11yrs"},
            };
    private String[][] doctor_details2 =
            {
                    {"Teacher Name : Abhimanyu","Location : 34-201","College id : 26616","Mobile no : 9879875431","Exp : 5yrs"},
                    {"Teacher Name : Hansraj","Location : 32-201","College id : 26916","Mobile no : 9879812345","Exp : 2yrs"},
                    {"Teacher Name : Shyam","Location : 32-505","College id : 23918","Mobile no : 6298756432","Exp : 7yrs"},
                    {"Teacher Name : Pasricha","Location : 32-201","College id : 24567","Mobile no : 9567432189","Exp : 12yrs"},
                    {"Teacher Name : Alam","Location : 32-201","College id : 21501","Mobile no : 8765438921","Exp : 11yrs"},
            };
    private String[][] doctor_details3 =
            {
                    {"Teacher Name : Mahesh","Location : 34-201","College id : 26616","Mobile no : 9879875431","Exp : 5yrs"},
                    {"Teacher Name : Yamuna","Location : 32-201","College id : 26916","Mobile no : 9879812345","Exp : 2yrs"},
                    {"Teacher Name : Ganga","Location : 32-505","College id : 23918","Mobile no : 6298756432","Exp : 7yrs"},
                    {"Teacher Name : K Pasricha","Location : 32-201","College id : 24567","Mobile no : 9567432189","Exp : 12yrs"},
                    {"Teacher Name : Lovish","Location : 32-201","College id : 21501","Mobile no : 8765438921","Exp : 11yrs"},
            };
    private String[][] doctor_details4 =
            {
                    {"Teacher Name : Nanadev","Location : 34-201","College id : 26616","Mobile no : 9879875431","Exp : 5yrs"},
                    {"Teacher Name : Chaudhary ji","Location : 32-201","College id : 26916","Mobile no : 9879812345","Exp : 2yrs"},
                    {"Teacher Name : Kumar gaurav","Location : 32-505","College id : 23918","Mobile no : 6298756432","Exp : 7yrs"},
                    {"Teacher Name : Nishant tanwar","Location : 32-201","College id : 24567","Mobile no : 9567432189","Exp : 12yrs"},
                    {"Teacher Name : yusuf pathan","Location : 32-201","College id : 21501","Mobile no : 8765438921","Exp : 11yrs"},
            };
    private String[][] doctor_details5 =
            {
                    {"Teacher Name : Jhon Doe","Location : 34-201","College id : 26616","Mobile no : 9879875431","Exp : 5yrs"},
                    {"Teacher Name : Travis Scoot","Location : 32-201","College id : 26916","Mobile no : 9879812345","Exp : 2yrs"},
                    {"Teacher Name : Drake","Location : 32-505","College id : 23918","Mobile no : 6298756432","Exp : 7yrs"},
                    {"Teacher Name : The Weekend","Location : 32-201","College id : 24567","Mobile no : 9567432189","Exp : 12yrs"},
                    {"Teacher Name : DJ Snake","Location : 32-201","College id : 21501","Mobile no : 8765438921","Exp : 11yrs"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details ={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDoctorDetailTitle);
        btn = findViewById(R.id.ButtonVMBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dieticians") == 0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentists") == 0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeons") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i<doctor_details.length;i++) {
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5",doctor_details[i][4]);
            list.add(item);
        }
        sa  = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewVM);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}