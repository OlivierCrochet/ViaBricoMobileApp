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

public class MainActivity extends AppCompatActivity {

    private EditText mUser;
    private EditText mPassword;
    private Button mConnexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser = (EditText) findViewById(R.id.saisie_user);
        mPassword = (EditText) findViewById(R.id.saisie_password);
        mConnexion = (Button) findViewById(R.id.button_connexion);

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
                Intent fournisseurActivity = new Intent(MainActivity.this, fournisseurActivity.class);
                startActivity(fournisseurActivity);
            }
        });


    }

}
