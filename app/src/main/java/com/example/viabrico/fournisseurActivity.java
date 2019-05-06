package com.example.viabrico;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Header;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.List;

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
        // Ajout de chaque widget avec son id
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

        // Ajout de la méthode GET qui va requêter l'api

        AsyncHttpClient client = new AsyncHttpClient();


        client.get("https://viabricosrm.herokuapp.com/api/fournisseur", new AsyncHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                // Action si la requête fonctionne

                Log.i("objJson", "success");
                String ret = new String(responseBody);
                Gson gson = new Gson();
                // Ajout de la méthode GET
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                // Action si la requête ne fonctionne pas

                System.out.println(responseBody);
            }

        });

        // Activation des boutons

        mVueBouton.setEnabled(true);
        mSuppBouton.setEnabled(true);
        mAjoutBouton.setEnabled(true);

        mVueBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Déclaration de l'objet Intent qui va appeler une autre activité

                Intent fournisseurVueActivity = new Intent(fournisseurActivity.this, fournisseurVueActivity.class);
                startActivity(fournisseurVueActivity);
            }
        });

        mSuppBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Message pour supprimer un fournisseur
                AlertDialog.Builder builder = new AlertDialog.Builder(fournisseurActivity.this);
                builder.setMessage("Supprimer définitivement le fournisseur ?");
                builder.setCancelable(true);
                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Ajout de la méthode delete
                        AsyncHttpClient client = new AsyncHttpClient();


                        client.delete("https://viabricosrm.herokuapp.com/api/fournisseur", new AsyncHttpResponseHandler()
                        {
                            @Override
                            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                                // Action si la requête fonctionne
                                System.out.println("Request successful");
                                Log.i("objJson", "success");
                                String ret = new String(responseBody);
                                Gson gson = new Gson();
                            }

                            @Override
                            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                                // Action si la requête ne fonctionne pas
                                System.out.println("Request unsuccessful");
                                System.out.println(responseBody);
                            }

                        });
                        Toast.makeText(fournisseurActivity.this, "Le fournisseur a bien été supprimé !", Toast.LENGTH_SHORT).show();
                    }


                });

                builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Bouton annuler
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
                // Démarrage d'une nouvelle activité
                Intent fournisseurAjoutActivity = new Intent(fournisseurActivity.this, fournisseurAjoutActivity.class);
                startActivity(fournisseurAjoutActivity);
            }
        });


    }
}
