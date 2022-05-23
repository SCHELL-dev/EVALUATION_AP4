package com.example.dvdloc_schell;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reservation extends AppCompatActivity {
    private Button btnConfirmerReservation;
    private Button btnAnnulerReservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        //Retour
        Button btnRetourReservation = (Button) findViewById(R.id.btnRetourReservation);
        btnRetourReservation.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent intent = new Intent(Reservation.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Confirmation
        btnConfirmerReservation = findViewById(R.id.btnConfirmerReservation);
        btnConfirmerReservation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        //Annulation
        btnAnnulerReservation = findViewById(R.id.btnAnnulerReservation);
        btnAnnulerReservation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });


    }
}