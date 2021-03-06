package com.example.osolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class connection_user extends AppCompatActivity {

    private static final int NEXT_REQUEST_CODE=0;
    public static final String IS_SHOWN = "IS_SHOWN";
    private boolean isShown = true;
    Button button_user;
    EditText edit_user;
    EditText edit_mdp;
    String mot_de_passe;
    String utilisateur;
    ImageButton btt1;
    ImageButton btt2;
    ImageButton btt3;
    TextView tv_1, tv_2, tv_3,tv_4;
    ProfilManager pm = new ProfilManager(this);


    public void validatePassword(String password){

        Pattern upperCase = Pattern.compile("[A-Z]");
        Pattern lowerCase = Pattern.compile("[a-z]");
        Pattern digitcase = Pattern.compile("[0-9]");
        if(!lowerCase.matcher(password).find()){
            tv_1.setTextColor(Color.RED);
        }else{
            tv_1.setTextColor(Color.GREEN);
        }

        if(!upperCase.matcher(password).find()){
            tv_2.setTextColor(Color.RED);
        }else{
            tv_2.setTextColor(Color.GREEN);
        }

        if(!digitcase.matcher(password).find()){
            tv_3.setTextColor(Color.RED);
        }else{
            tv_3.setTextColor(Color.GREEN);
        }

        if(password.length() <8){
            tv_4.setTextColor(Color.RED);
        }else{
            tv_4.setTextColor(Color.GREEN);
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_user);
        button_user=findViewById(R.id.button_user);
        edit_user=(EditText)findViewById(R.id.user);
        edit_mdp=(EditText)findViewById(R.id.password);


        tv_1=findViewById(R.id.tv_1);
        tv_2=findViewById(R.id.tv_2);
        tv_3=findViewById(R.id.tv_3);
        tv_4=findViewById(R.id.tv_4);

        edit_mdp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mot_de_passe=edit_mdp.getText().toString();
                validatePassword(mot_de_passe);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilisateur=edit_user.getText().toString();
                pm.open();
                profil p=pm.getProfil(utilisateur);
                pm.close();
                mot_de_passe=edit_mdp.getText().toString();
                if(mot_de_passe.equals("") || utilisateur.equals("")) {
                    Toast.makeText(connection_user.this, "nom d'utilisateur et/ou mot de passe absent",
                            Toast.LENGTH_LONG).show();
                }else {
                    if (!p.getOsolien()){
                        if (p.getPassword().equals(mot_de_passe)) {
                            Intent intent = new Intent(connection_user.this, info_pico_user.class);
                            intent.putExtra(IS_SHOWN, isShown);
                            startActivity(intent);
                        } else {

                            Toast.makeText(connection_user.this, "nom d'utilisateur et/ou mot de passe incorrect",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(connection_user.this, "vous n'êtes pas un utilisateur normal",
                                Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        btt1=findViewById(R.id.imageBt1);
        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(connection_user.this, "Retour au menu principal",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(connection_user.this,MainActivity.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });


        btt2=findViewById(R.id.imageButton5);
        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(connection_user.this,connect.class );
                intent.putExtra(IS_SHOWN, isShown);
                startActivity(intent);
            }
        });

        btt3=findViewById(R.id.imageBt3);
        btt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(connection_user.this, "Description de OSol et Pico",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(connection_user.this,description.class);
                intent.putExtra(IS_SHOWN,isShown);
                startActivity(intent);
            }
        });

    }


}