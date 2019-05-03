package com.example.viabrico;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private EditText mUser;
    private EditText mPassword;
    private Button mConnexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Déclaration des widgets

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser = (EditText) findViewById(R.id.saisie_user);
        mPassword = (EditText) findViewById(R.id.saisie_password);
        mConnexion = (Button) findViewById(R.id.button_connexion);


        // Activation du bouton et des champs de saisie
        mConnexion.setEnabled(true);
        mUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mUser.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        mConnexion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Démarrage de l'activité
                Intent fournisseurActivity = new Intent(MainActivity.this, fournisseurActivity.class);
                startActivity(fournisseurActivity);
                Toast.makeText(MainActivity.this, "Bienvenue " + mUser.getText() + " !", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
