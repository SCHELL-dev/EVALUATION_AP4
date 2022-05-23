package com.example.dvdloc_schell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Membre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membre);
        Button btnRetourMembre = (Button) findViewById(R.id.btnRetourMembre);
        btnRetourMembre.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent intent = new Intent(Membre.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}