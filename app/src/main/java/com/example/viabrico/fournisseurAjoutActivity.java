package com.example.viabrico;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class fournisseurAjoutActivity extends AppCompatActivity {

    private TextView mNomApp;
    private TextView mAjoutFournisseurText;
    private ConstraintLayout mLayoutFournisseurAjout;
    private TextView mBaliseNameAjout;
    private EditText mNameAjout;
    private TextView mBaliseAdresseAjout;
    private EditText mAdresseAjout;
    private TextView mBaliseTelephoneAjout;
    private EditText mTelephoneAjout;
    private TextView mBaliseMailAjout;
    private EditText mMailAjout;
    private TextView mBaliseDescriptionAjout;
    private EditText mDescriptionAjout;
    private ConstraintLayout mLayoutBoutonAjout;
    private Button mBoutonAnnuler;
    private Button mBoutonAjouter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fournisseur_ajout);
        mNomApp = (TextView) findViewById(R.id.ajout_nom_app);
        mAjoutFournisseurText = (TextView) findViewById(R.id.ajout_fournisseur_texte);
        mLayoutFournisseurAjout = (ConstraintLayout) findViewById(R.id.layout_fournisseur_ajout);
        mBaliseNameAjout = (TextView) findViewById(R.id.balise_name_ajout);
        mNameAjout = (EditText) findViewById(R.id.name_fournisseur_ajout);
        mBaliseAdresseAjout = (TextView) findViewById(R.id.balise_adresse_ajout);
        mAdresseAjout = (EditText) findViewById(R.id.adresse_ajout);
        mBaliseTelephoneAjout = (TextView) findViewById(R.id.balise_telephone_ajout);
        mTelephoneAjout = (EditText) findViewById(R.id.ajout_telephone);
        mBaliseMailAjout = (TextView) findViewById(R.id.balise_mail_ajout);
        mMailAjout = (EditText) findViewById(R.id.ajout_mail);
        mBaliseDescriptionAjout = (TextView) findViewById(R.id.balise_description_ajout);
        mDescriptionAjout = (EditText) findViewById(R.id.ajout_description);
        mLayoutBoutonAjout = (ConstraintLayout) findViewById(R.id.layout_bouton_ajout);
        mBoutonAnnuler = (Button) findViewById(R.id.annuler_bouton);
        mBoutonAjouter = (Button) findViewById(R.id.ajouter_bouton_ajout);


        mBoutonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent annuler = new Intent(fournisseurAjoutActivity.this, fournisseurActivity.class);
                startActivity(annuler);
            }
        });

        mBoutonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Ajouter une méthode add */
                Intent ajouter = new Intent(fournisseurAjoutActivity.this, fournisseurActivity.class);
                startActivity(ajouter);
            }
        });

        /* Ajout de la méthode GET */

        mNameAjout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mAdresseAjout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mTelephoneAjout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mMailAjout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDescriptionAjout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
