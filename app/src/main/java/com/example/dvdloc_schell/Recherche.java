package com.example.dvdloc_schell;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Recherche extends AppCompatActivity {

    //Definition de 2 attributs
    private Button btnRecherche;
    private EditText edtRecherche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);

        // Association des attributs à la vue
        edtRecherche = findViewById(R.id.edtRecherche);
        btnRecherche = findViewById(R.id.btnRecherche);

        btnRecherche.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Toast toast = Toast.makeText(getApplicationContext(), edtRecherche.getText(), Toast.LENGTH_SHORT);
                //toast.show();

                Intent intent = new Intent(Recherche.this, Adherent.class);
                intent.putExtra("titre", edtRecherche.getText().toString());
                startActivity(intent);

            }

        });

        Button btnRetourRecherche = (Button) findViewById(R.id.btnRetourRecherche);
        btnRetourRecherche.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent intent = new Intent(Recherche.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}