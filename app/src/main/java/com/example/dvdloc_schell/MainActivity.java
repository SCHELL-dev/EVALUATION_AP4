package com.example.dvdloc_schell;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.Policy;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menugeneral, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuRechercher:
                Log.i("LocDVD","Menu:Rechercher un cours");
                Intent intent = new Intent(MainActivity.this, Recherche.class);
                rechercheLauncher.launch(intent);
                return true;

            case R.id.menuParticipation:
                Log.i("LocDVD","Menu:Participer à un cours");
                Intent intent2 = new Intent(MainActivity.this, Reservation.class);
                reservationLauncher.launch(intent2);
                return true;

            case R.id.menuPresentation:
                Log.i("LocDVD","Menu:Présentation");
                return true;
        }
        return true;
    }

    ActivityResultLauncher<Intent> reservationLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Toast.makeText(MainActivity.this, "Réservation confirmée", Toast.LENGTH_SHORT).show();
                    }
                    if(result.getResultCode() == Activity.RESULT_CANCELED){
                        Toast.makeText(MainActivity.this, "Réservation annulée", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );

    ActivityResultLauncher<Intent> rechercheLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        String titre = data.getStringExtra("titre");
                        Toast.makeText(MainActivity.this, titre, Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdherent = (Button) findViewById(R.id.btnAdherent);
        btnAdherent.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View arg0){
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Adherent");
                alertDialog.setMessage("Etes-vous adhérent ?");
                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface arg0, int arg1){
                        Toast.makeText(getApplicationContext(), btnAdherent.getText(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, Adherent.class);
                        startActivity(intent);
                    }
                });

                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface arg0, int arg1){
                        // Pas de traitement
                    }
                });
                alertDialog.show();
            }
        });

        Button btnEntraineur = (Button) findViewById(R.id.btnEntraineur);
        btnEntraineur.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Entraineur");
                alertDialog.setMessage("Etes-vous entraineur ?");
                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface arg0, int arg1){
                        Toast.makeText(getApplicationContext(), btnEntraineur.getText(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, Entraineur.class);
                        startActivity(intent);
                    }
                });

                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface arg0, int arg1){
                        // Pas de traitement
                    }
                });
                alertDialog.show();
            }
        });

        Button btnMembre = (Button) findViewById(R.id.btnMembre);
        btnMembre.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Membre d'association");
                alertDialog.setMessage("Etes-vous membre ?");
                alertDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface arg0, int arg1){
                        Toast.makeText(getApplicationContext(), btnMembre.getText(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, Membre.class);
                        startActivity(intent);
                    }
                });

                alertDialog.setNegativeButton("Non", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface arg0, int arg1){
                        // Pas de traitement
                    }
                });
                alertDialog.show();
            }
        });
    }
}