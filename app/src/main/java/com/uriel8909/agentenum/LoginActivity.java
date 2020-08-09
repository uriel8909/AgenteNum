package com.uriel8909.agentenum;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.uriel8909.agentenum.common.Constantes;


public class LoginActivity extends AppCompatActivity {

    ImageView iv_adelantelogin;
    TextView tvtitulo;
    TextView tv_acercad;
    EditText pt_agente;
    Button btn_login;
    Button btn_acerca;
    String nick;
    Button btn_registro;
    ImageButton btn_clasif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvtitulo = findViewById(R.id.tvtitulo);
        pt_agente = findViewById(R.id.pt_agente);
        btn_login = findViewById(R.id.btn_login);
        btn_acerca = findViewById(R.id.btn_acerca);


        btn_acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(LoginActivity.this, "Gracias ", Toast.LENGTH_LONG).show();
                    ShowAlertPanel();
                }
                private void ShowAlertPanel() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("Gracias!!!");
                    builder.setMessage("https://icons8.com & https://www.iconfinder.com/ \n Docentes de la Unicla. \n Los testers que probaron esta app.\n Al Ing. Roberto Sanchez \n Alan Perez \nAl grupo de Facebook de Programación Android Studio \n A mis padres, que aunque mi papa no este conmigo, me esta apoyando este donde este.... \n Juego realizado por Uriel8909");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.show();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            nick = pt_agente.getText().toString();
            if (nick.isEmpty()){
                pt_agente.setError("Error, el nombre es obligatorio");
                } else {
                    Toast.makeText(LoginActivity.this, "Bienvenido Agente "+ nick, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this,GameActivity.class);
                    i.putExtra(Constantes.EXTRA_NICK, nick);
                    startActivity(i);
                }
            }
        });

    }
}