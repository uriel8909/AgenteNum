package com.uriel8909.agentenum;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.uriel8909.agentenum.common.Constantes;

import java.util.Random;

public class MultiActivity extends AppCompatActivity {

    Button btn_cora;
    int cora=3;
    Button btn_num1;
    int num1=0;
    Button btn_num2;
    int num2=0;
    Button btn_correcto;
    int correcto=0;
    Button btn_enviar;
    Button btn_agemte;
    TextView et_res;
    int res_usr=0;
    int res_cor=0;
    int acum=0;
    String res_usrr;
    String nick;
    boolean gameOver = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        AlertDialog.Builder builder = new AlertDialog.Builder(MultiActivity.this);
        builder.setTitle("Como Multiplicar");
        builder.setMessage("La multiplicación es una operación matemática que utilizamos cuando tenemos que reemplazar el cálculo de ciertas SUMAS repetitivas, por un método más veloz. \n Es decir, es una operación más fácil que sumar muchas veces el mismo número.");
        builder.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();

        btn_agemte = findViewById(R.id.btn_agente);
        btn_cora= findViewById(R.id.btn_cora);
        btn_num1 = findViewById(R.id.btn_num1);
        btn_num2 = findViewById(R.id.btn_num2);
        btn_correcto = findViewById(R.id.btn_correcto);
        btn_enviar = findViewById(R.id.btn_enviar);
        et_res = findViewById(R.id.et_res);


        if (acum == 5){
            cora=cora+1;
            acum = 0;}

        btn_cora.setText(Integer.toString(cora));
        Random rn = new Random(System.currentTimeMillis());
        num1 = rn.nextInt(9);
        btn_num1.setText(Integer.toString(num1));
        Random rn2 = new Random(System.nanoTime());
        num2 = rn2.nextInt(9);
        btn_num2.setText(Integer.toString(num2));
        res_cor=num1*num2;
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res_usrr = et_res.getText().toString();
                if (res_usrr.isEmpty()){
                    et_res.setError("Ingresa un numero");
                } else {
                res_usr = Integer.parseInt(res_usrr);
                if (res_usr == res_cor) {
                    acum = acum + 1;
                    correcto = correcto + 1;
                    btn_correcto.setText(Integer.toString(correcto));
                    Toast toastc = Toast.makeText(getApplicationContext(), "Correcto!, llevas acumulados " + acum, Toast.LENGTH_LONG);
                    toastc.show();
                    et_res.setText("");
                    Random rn = new Random(System.currentTimeMillis());
                    num1 = rn.nextInt(9);
                    btn_num1.setText(Integer.toString(num1));
                    Random rn2 = new Random(System.nanoTime());
                    num2 = rn2.nextInt(9);
                    btn_num2.setText(Integer.toString(num2));
                    res_cor=num1*num2;
                }
                else {
                    cora=cora-1;
                    btn_cora.setText(Integer.toString(cora));
                    acum = 0;
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MultiActivity.this);
                    builder1.setTitle("ERROR");
                    builder1.setMessage("El resultado de la multiplicacion de " +num1 +" X " +num2 +" era "+res_cor);
                    builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast toasrer = Toast.makeText(getApplicationContext(), "Pierdes tus acomulados que llevabas", Toast.LENGTH_LONG);
                            toasrer.show();
                            btn_cora.setText(Integer.toString(cora));
                            Random rn = new Random(System.currentTimeMillis());
                            num1 = rn.nextInt(9);
                            btn_num1.setText(Integer.toString(num1));
                            Random rn2 = new Random(System.nanoTime());
                            num2 = rn2.nextInt(9);
                            btn_num2.setText(Integer.toString(num2));
                            res_cor=num1*num2;
                            et_res.setText("");
                        }
                    });
                    builder1.show();
                }
                if (acum==5){
                    cora=cora+1;
                    btn_cora.setText(Integer.toString(cora));
                    acum=0;
                }
                if (cora==0){
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(MultiActivity.this);
                    builder3.setTitle("Fin del Juego");
                    builder3.setMessage("No te queda mas corazones, ¿Quieres volver a empezar?");
                    builder3.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(MultiActivity.this,SumaActivity.class);
                            i.putExtra(Constantes.EXTRA_NICK, nick);
                            startActivity(i);
                        }
                    });
                    builder3.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(MultiActivity.this,GameActivity.class);
                            i.putExtra(Constantes.EXTRA_NICK, nick);
                            startActivity(i);
                        }

                    });
                    builder3.show();}
                if (cora == 10) {
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(MultiActivity.this);
                    builder4.setTitle("Ganaste");
                    builder4.setMessage("Has alcanzado el numero maximo de vidas, deseas volver a jugar?");
                    builder4.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(MultiActivity.this, SumaActivity.class);
                            startActivity(i);
                        }
                    });
                    builder4.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(MultiActivity.this, GameActivity.class);
                            i.putExtra(Constantes.EXTRA_NICK, nick);
                            startActivity(i);
                        }
                    });
                    builder4.show();
                }
            }}});}}