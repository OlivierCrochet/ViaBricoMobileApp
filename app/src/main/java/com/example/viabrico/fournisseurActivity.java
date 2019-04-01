package com.example.viabrico;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class fournisseurActivity extends AppCompatActivity {

    private TextView mNomApp;
    private ConstraintLayout mLayoutFournisseur;
    private TextView mBaliseName;
    private TextView mNameFournisseur;
    private TextView mBaliseDescription;
    private TextView mDescription;
    private ImageButton mVueBouton;
    private ImageButton mSuppBouton;
    private ConstraintLayout mLayoutBouton;
    private Button mAjoutBouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fournisseur);
        mNomApp = (TextView) findViewById(R.id.name_app);
        mLayoutFournisseur = (ConstraintLayout) findViewById(R.id.layout_fournisseur);
        mBaliseName = (TextView) findViewById(R.id.balise_name);
        mNameFournisseur = (TextView) findViewById(R.id.name_fournisseur);
        mBaliseDescription = (TextView) findViewById(R.id.balise_description);
        mDescription = (TextView) findViewById(R.id.description);
        mVueBouton = (ImageButton) findViewById(R.id.button_vue);
        mSuppBouton = (ImageButton) findViewById(R.id.button_supp);
        mLayoutBouton = (ConstraintLayout) findViewById(R.id.layout_button);
        mAjoutBouton = (Button) findViewById(R.id.button_ajout);

        mVueBouton.setEnabled(true);
        mSuppBouton.setEnabled(true);
        mAjoutBouton.setEnabled(true);

        mVueBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fournisseurVueActivity = new Intent(fournisseurActivity.this, fournisseurVueActivity.class);
                startActivity(fournisseurVueActivity);
            }
        });

        mSuppBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(fournisseurActivity.this);
                builder.setMessage("Supprimer définitivement le fournisseur ?");
                builder.setCancelable(true);
                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        fournisseurActivity.this.finish();
                    }


                });

                builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }

        });

        mAjoutBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fournisseurAjoutActivity = new Intent(fournisseurActivity.this, fournisseurAjoutActivity.class);
                startActivity(fournisseurAjoutActivity);
            }
        });


    }
}
