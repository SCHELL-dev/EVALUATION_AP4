package com.example.dvdloc_schell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Entraineur extends AppCompatActivity {

    public String listeEntraineur[] = {
            "Jacobe Silence",
            "Jeremy Sastre",
            "Satya Jabla",
            "Tom Vigneron",
            "Yoan Crackhead"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entraineur);

        Button btnRetourEntraineur = (Button) findViewById(R.id.btnRetourEntraineur);
        btnRetourEntraineur.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent intent = new Intent(Entraineur.this, MainActivity.class);
                startActivity(intent);
            }
        });


        final ArrayAdapter<String> adapterList =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, listeEntraineur);

    ListView listEntraineur = (ListView)findViewById(R.id.entraineur_listview);
    listEntraineur.setAdapter(adapterList);

    listEntraineur.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long arg3) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Position :" + String.valueOf(position), Toast.LENGTH_SHORT);
                    toast.show();

                    Toast toast2 = Toast.makeText(getApplicationContext(), "Titre :" + listeEntraineur[position], Toast.LENGTH_SHORT);
                    toast2.show();
                }
            }
    );
    }
}