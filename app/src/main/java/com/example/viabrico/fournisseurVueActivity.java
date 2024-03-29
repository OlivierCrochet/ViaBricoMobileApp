package com.example.viabrico;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class fournisseurVueActivity extends AppCompatActivity {

    private ConstraintLayout mLayoutVue;
    private TextView mNameAppVue;
    private TextView mFicheDetailVue;
    private ConstraintLayout mLayoutFournisseurVue;
    private TextView mBaliseNameVue;
    private ConstraintLayout mLayoutNameVue;
    private TextView mNameFournisseurVue;
    private ImageButton mBoutonPenNameVue;
    private TextView mBaliseAdresseVue;
    private ConstraintLayout mLayoutAdresseVue;
    private TextView mAdresseFournisseurVue;
    private ImageButton mBoutonPenAdresseVue;
    private TextView mBaliseTelephoneVue;
    private ConstraintLayout mLayoutTelephoneVue;
    private TextView mTelephoneFournisseurVue;
    private ImageButton mBoutonPenTelephoneVue;
    private TextView mBaliseMailVue;
    private ConstraintLayout mLayoutMailVue;
    private TextView mMailFournisseurVue;
    private ImageButton mBoutonPenMailVue;
    private TextView mBaliseDescriptionVue;
    private ConstraintLayout mLayoutDescriptionVue;
    private TextView mDescriptionFournisseurVue;
    private ImageButton mBoutonPenDescriptionVue;
    private Button mBoutonRetourVue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Déclaration des widgets
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fournisseur_vue);
        mLayoutVue = (ConstraintLayout) findViewById(R.id.layout_vue);
        mNameAppVue = (TextView) findViewById(R.id.name_app_vue);
        mFicheDetailVue = (TextView) findViewById(R.id.fiche_detail_vue);
        mLayoutFournisseurVue = (ConstraintLayout) findViewById(R.id.layout_fournisseur_vue);
        mBaliseNameVue = (TextView) findViewById(R.id.balise_name_vue);
        mLayoutNameVue = (ConstraintLayout) findViewById(R.id.layout_name_vue);
        mNameFournisseurVue = (TextView) findViewById(R.id.name_fournisseur_vue);
        mBoutonPenNameVue = (ImageButton) findViewById(R.id.bouton_pen_name_vue);
        mBaliseAdresseVue = (TextView) findViewById(R.id.balise_adresse_vue);
        mLayoutAdresseVue = (ConstraintLayout) findViewById(R.id.layout_adresse_vue);
        mAdresseFournisseurVue = (TextView) findViewById(R.id.adresse_fournisseur_vue);
        mBoutonPenAdresseVue = (ImageButton) findViewById(R.id.bouton_pen_adresse_vue);
        mBaliseTelephoneVue = (TextView) findViewById(R.id.balise_telephone_vue);
        mLayoutTelephoneVue = (ConstraintLayout) findViewById(R.id.layout_telephone_vue);
        mTelephoneFournisseurVue = (TextView) findViewById(R.id.telephone_fournisseur_vue);
        mBoutonPenTelephoneVue = (ImageButton) findViewById(R.id.bouton_pen_telephone_vue);
        mBaliseMailVue = (TextView) findViewById(R.id.balise_mail_vue);
        mLayoutMailVue = (ConstraintLayout) findViewById(R.id.layout_mail_vue);
        mMailFournisseurVue = (TextView) findViewById(R.id.mail_fournisseur_vue);
        mBoutonPenMailVue = (ImageButton) findViewById(R.id.bouton_pen_mail_vue);
        mBaliseDescriptionVue = (TextView) findViewById(R.id.balise_description_vue);
        mLayoutDescriptionVue = (ConstraintLayout) findViewById(R.id.layout_description_vue);
        mDescriptionFournisseurVue = (TextView) findViewById(R.id.description_fournisseur_vue);
        mBoutonPenDescriptionVue = (ImageButton) findViewById(R.id.bouton_pen_description_vue);
        mBoutonRetourVue = (Button) findViewById(R.id.bouton_retour_vue);

        // Activation des boutons
        mBoutonRetourVue.setEnabled(true);
        mBoutonPenNameVue.setEnabled(true);
        mBoutonPenAdresseVue.setEnabled(true);
        mBoutonPenTelephoneVue.setEnabled(true);
        mBoutonPenMailVue.setEnabled(true);
        mBoutonPenDescriptionVue.setEnabled(true);

        mBoutonRetourVue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retour = new Intent(fournisseurVueActivity.this, fournisseurActivity.class);
                startActivity(retour);
            }
        });

        mBoutonPenNameVue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Ajout de la méthode PUT */

                AsyncHttpClient client = new AsyncHttpClient();


                client.put("https://viabricosrm.herokuapp.com/api/fournisseur", new AsyncHttpResponseHandler()
                {
                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                        // Action si la requête fonctionne

                        Log.i("objJson", "success");
                        String ret = new String(responseBody);
                        Gson gson = new Gson();
                    }

                    @Override
                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                        // Action si la requête ne fonctionne pas

                        System.out.println(responseBody);
                    }

                });

            }
        });

        mBoutonPenAdresseVue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Ajout de la méthode PUT */

                AsyncHttpClient client = new AsyncHttpClient();


                client.put("https://viabricosrm.herokuapp.com/api/fournisseur", new AsyncHttpResponseHandler()
                {
                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                        // Action si la requête fonctionne

                        Log.i("objJson", "success");
                        String ret = new String(responseBody);
                        Gson gson = new Gson();
                    }

                    @Override
                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                        // Action si la requête ne fonctionne pas

                        System.out.println(responseBody);
                    }

                });
            }
        });

        mBoutonPenTelephoneVue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Ajout de la méthode PUT */

                AsyncHttpClient client = new AsyncHttpClient();


                client.put("https://viabricosrm.herokuapp.com/api/fournisseur", new AsyncHttpResponseHandler()
                {
                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                        // Action si la requête fonctionne

                        Log.i("objJson", "success");
                        String ret = new String(responseBody);
                        Gson gson = new Gson();
                    }

                    @Override
                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                        // Action si la requête ne fonctionne pas

                        System.out.println(responseBody);
                    }

                });
            }
        });

        mBoutonPenMailVue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Ajout de la méthode PUT */

                AsyncHttpClient client = new AsyncHttpClient();


                client.put("https://viabricosrm.herokuapp.com/api/fournisseur", new AsyncHttpResponseHandler()
                {
                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                        // Action si la requête fonctionne

                        Log.i("objJson", "success");
                        String ret = new String(responseBody);
                        Gson gson = new Gson();
                    }

                    @Override
                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                        // Action si la requête ne fonctionne pas

                        System.out.println(responseBody);
                    }

                });
            }
        });

        mBoutonPenDescriptionVue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Ajout de la méthode PUT */

                AsyncHttpClient client = new AsyncHttpClient();


                client.put("https://viabricosrm.herokuapp.com/api/fournisseur", new AsyncHttpResponseHandler()
                {
                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                        // Action si la requête fonctionne

                        Log.i("objJson", "success");
                        String ret = new String(responseBody);
                        Gson gson = new Gson();
                    }

                    @Override
                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                        // Action si la requête ne fonctionne pas

                        System.out.println(responseBody);
                    }

                });
            }
        });
    }
}
