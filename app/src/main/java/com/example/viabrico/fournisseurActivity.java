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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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


        RequestQueue queue = (RequestQueue) Volley.newRequestQueue(fournisseurActivity.this);
        String url ="https://viabricosrm.herokuapp.com/fournisseur";
        StringRequest strRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        System.out.println("Marche stp !");
                        Toast.makeText(fournisseurActivity.this,"Response is: " + response.substring(0, 500), Toast.LENGTH_SHORT);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Marche pas stp !");
                Toast.makeText(fournisseurActivity.this,"That didn't work!", Toast.LENGTH_SHORT);
            }
        });

        queue.add(strRequest);

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
                        /* Ajout de la méthode delete */

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
