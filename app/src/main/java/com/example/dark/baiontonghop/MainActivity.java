package com.example.dark.baiontonghop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lvwmenu;
    String[] drawerItems={"Phong Ban","Nhan Vien"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvwmenu=(ListView)findViewById(R.id.lvwDrawerMenu);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,drawerItems);
        lvwmenu.setAdapter(adapter);

        lvwmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(MainActivity.this,Department.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this,"Bua Sau Lam...!",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
