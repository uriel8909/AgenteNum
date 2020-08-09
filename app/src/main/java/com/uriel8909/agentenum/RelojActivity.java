package com.uriel8909.agentenum;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RelojActivity extends AppCompatActivity {

    Button btn_cora;
    int cora = 3;
    Button btn_num1;
    int num1 = 0;
    Button btn_num2;
    int num2 = 0;
    Button btn_correcto;
    int correcto = 0;
    Button btn_enviar;
    Button btn_agemte;
    TextView et_res;
    int res_usr = 0;
    int res_cor = 0;
    int acum = 0;
    String res_usrr;
    int a = 0;
    TextView tv_multi2;
    Button btn_puntaje;
    int puntaje = 0;
    Button btn_time;
    boolean gameOver = false;
    int sumas=0;
    int contsumas=0;
    int restas=0;
    int contrestas=0;
    int multis =0;
    int contmultis=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloj);
        AlertDialog.Builder builder = new AlertDialog.Builder(RelojActivity.this);
        builder.setTitle("Vas contra tiempo");
        builder.setMessage("Vamos por todo, tienes 2 minutos para terminar!!! \n Ademas tienes vidas");
        builder.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();

        btn_agemte = findViewById(R.id.btn_agente);
        btn_cora = findViewById(R.id.btn_cora);
        btn_num1 = findViewById(R.id.btn_num1);
        btn_num2 = findViewById(R.id.btn_num2);
        btn_correcto = findViewById(R.id.btn_correcto);
        btn_enviar = findViewById(R.id.btn_enviar);
        et_res = findViewById(R.id.et_res);
        tv_multi2 = findViewById(R.id.tv_multi2);
        btn_puntaje = findViewById(R.id.btn_puntaje);
        btn_time = findViewById(R.id.btn_time);

        btn_cora.setText(Integer.toString(cora));

            Random rn = new Random(System.currentTimeMillis());
            num1 = rn.nextInt(100);
            btn_num1.setText(Integer.toString(num1));
            Random rn2 = new Random(System.nanoTime());
            num2 = rn2.nextInt(100);
            btn_num2.setText(Integer.toString(num2));
            res_cor = num1 + num2;
            contsumas = contsumas + 1;
            tv_multi2.setText("+");
            btn_enviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    res_usrr = et_res.getText().toString();
                    if (res_usrr.isEmpty()) {
                        et_res.setError("Ingresa un numero");
                    } else {
                        res_usr = Integer.parseInt(res_usrr);
                        if (res_usr == res_cor) {
                            acum = acum + 1;
                            correcto = correcto + 1;
                            btn_correcto.setText(Integer.toString(correcto));
                            sumas = sumas + 1;
                            Toast toastc = Toast.makeText(getApplicationContext(), "Correcto!, llevas acumulados " + acum, Toast.LENGTH_LONG);
                            toastc.show();
                            et_res.setText("");
                        } else {
                            cora = cora - 1;
                            btn_cora.setText(Integer.toString(cora));
                            acum = 0;
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(RelojActivity.this);
                            builder1.setTitle("ERROR");
                            builder1.setMessage("El resultado de la suma de " + num1 + " + " + num2 + " era " + res_cor);
                            builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast toasrer = Toast.makeText(getApplicationContext(), "Pierdes tus acomulados que llevabas", Toast.LENGTH_LONG);
                                    toasrer.show();
                                    et_res.setText("");
                                }
                            });
                            builder1.show();
                        }
                        if (acum == 5) {
                            cora = cora + 1;
                            btn_cora.setText(Integer.toString(cora));
                            acum = 0;
                        }
                        if (cora == 0) {
                            puntaje = puntaje + 100;
                        } else {
                            puntaje = puntaje + (cora * 100);
                        }
                        if (cora == 0) {
                            AlertDialog.Builder builder3 = new AlertDialog.Builder(RelojActivity.this);
                            builder3.setTitle("Fin del Juego");
                            builder3.setMessage("No te queda mas corazones, ¿Quieres volver a empezar?");
                            builder3.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(RelojActivity.this, RelojActivity.class);
                                    startActivity(i);
                                }
                            });
                            builder3.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(RelojActivity.this, GameActivity.class);
                                }

                            });
                            builder3.show();
                        }
                    }
                }
            });
            if (acum == 5) {
                cora = cora + 1;
                acum = 0;
            }
            tv_multi2.setText("X");
            btn_cora.setText(Integer.toString(cora));
            Random rn5 = new Random(System.currentTimeMillis());
            num1 = rn5.nextInt(9);
            btn_num1.setText(Integer.toString(num1));
            Random rn6 = new Random(System.nanoTime());
            num2 = rn6.nextInt(9);
            btn_num2.setText(Integer.toString(num2));
            res_cor = num1 * num2;
            contmultis = contmultis + 1;
            btn_enviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Random rna = new Random(System.currentTimeMillis());
                    a = rna.nextInt(100);
                    res_usrr = et_res.getText().toString();
                    if (res_usrr.isEmpty()) {
                        et_res.setError("Ingresa un numero");
                    } else {
                        res_usr = Integer.parseInt(res_usrr);
                        if (res_usr == res_cor) {
                            acum = acum + 1;
                            correcto = correcto + 1;
                            multis = multis + 1;
                            btn_correcto.setText(Integer.toString(correcto));
                            Toast toastc = Toast.makeText(getApplicationContext(), "Correcto!, llevas acumulados " + acum, Toast.LENGTH_LONG);
                            toastc.show();
                            et_res.setText("");
                        } else {
                            cora = cora - 1;
                            btn_cora.setText(Integer.toString(cora));
                            acum = 0;
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(RelojActivity.this);
                            builder1.setTitle("ERROR");
                            builder1.setMessage("El resultado de la multiplicacion de " + num1 + " X " + num2 + " era " + res_cor);
                            builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) { Toast toasrer = Toast.makeText(getApplicationContext(), "Pierdes tus acomulados que llevabas", Toast.LENGTH_LONG);                                 toasrer.show();
                                btn_cora.setText(Integer.toString(cora));
                                et_res.setText("");
                                }
                            });
                            builder1.show();
                        }
                        if (acum == 5) {
                            cora = cora + 1;
                            btn_cora.setText(Integer.toString(cora));
                            acum = 0;
                        }
                        if (cora == 0) {
                            puntaje = puntaje + 100;
                        } else {
                            puntaje = puntaje + (cora * 100);
                        }
                        if (cora == 0) {
                            AlertDialog.Builder builder3 = new AlertDialog.Builder(RelojActivity.this);
                            builder3.setTitle("Fin del Juego");
                            builder3.setMessage("No te queda mas corazones, ¿Quieres volver a empezar?");
                            builder3.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(RelojActivity.this, RelojActivity.class);
                                    startActivity(i);
                                }
                            });
                            builder3.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(RelojActivity.this, GameActivity.class);

                                }

                            });
                            builder3.show();
                        }
                    }
                }
            });
                    tv_multi2.setText("-");
                    btn_cora.setText(Integer.toString(cora));
                    Random rn7 = new Random(System.currentTimeMillis());
                    num1 = rn7.nextInt(100);
                    Random rn8 = new Random(System.nanoTime());
                    num2 = rn8.nextInt(50);
                    if (num2 > num1) {
                        while (num2 > num1) {
                            Random rn3 = new Random(System.currentTimeMillis());
                            num1 = rn3.nextInt(100);
                            Random rn4 = new Random(System.nanoTime());
                            num2 = rn4.nextInt(50);
                        }
                    }
                    else {
                        btn_num1.setText(Integer.toString(num1));
                        btn_num2.setText(Integer.toString(num2));
                        res_cor = num1 - num2;
                        contrestas = contrestas + 1;
                        btn_enviar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Random rna = new Random(System.currentTimeMillis());
                                a = rna.nextInt(100);
                                res_usrr = et_res.getText().toString();
                                if (res_usrr.isEmpty()) {
                                    et_res.setError("Ingresa un numero");
                                } else {
                                    res_usr = Integer.parseInt(res_usrr);
                                    if (res_usr == res_cor) {
                                        acum = acum + 1;
                                        correcto = correcto + 1;
                                        restas = restas + 1;
                                        btn_correcto.setText(Integer.toString(correcto));
                                        Toast toastc = Toast.makeText(getApplicationContext(), "Correcto!, llevas acumulados " + acum, Toast.LENGTH_LONG);
                                        toastc.show();
                                        et_res.setText("");
                                    } else {
                                        cora = cora - 1;
                                        btn_cora.setText(Integer.toString(cora));
                                        acum = 0;
                                        AlertDialog.Builder builder1 = new AlertDialog.Builder(RelojActivity.this);
                                        builder1.setTitle("ERROR");
                                        builder1.setMessage("El resultado de la restar de " + num1 + " - " + num2 + " era " + res_cor);
                                        builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                            }
                                        });
                                        builder1.show();
                                    }
                                    if (acum == 5) {
                                        cora = cora + 1;
                                        btn_cora.setText(Integer.toString(cora));
                                        acum = 0;
                                    }
                                    if (cora == 0) {
                                        puntaje = puntaje + 100;
                                    } else {
                                        puntaje = puntaje + (cora * 100);
                                    }
                                }
                                if (cora == 0) {
                                    AlertDialog.Builder builder3 = new AlertDialog.Builder(RelojActivity.this);
                                    builder3.setTitle("Fin del Juego");
                                    builder3.setMessage("No te queda mas corazones, ¿Quieres volver a empezar?");
                                    builder3.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent i = new Intent(RelojActivity.this, RelojActivity.class);
                                            startActivity(i);
                                        }
                                    });
                                    builder3.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent i = new Intent(RelojActivity.this, GameActivity.class);
                                        }

                                    });
                                    builder3.show();
                                }
                                if (cora == 10) {
                                    AlertDialog.Builder builder4 = new AlertDialog.Builder(RelojActivity.this);
                                    builder4.setTitle("Ganaste");
                                    builder4.setMessage("Has alcanzado el numero maximo de vidas, deseas volver a jugar?");
                                    builder4.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent i = new Intent(RelojActivity.this, SumaActivity.class);
                                            startActivity(i);
                                        }
                                    });
                                    builder4.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent i = new Intent(RelojActivity.this, GameActivity.class);
                                            startActivity(i);
                                        }
                                    });
                                    builder4.show();
                                }
                            }
                        });
                    }

                    Random rn11 = new Random(System.currentTimeMillis());
                    num1 = rn11.nextInt(100);
                    btn_num1.setText(Integer.toString(num1));
                    Random rn22 = new Random(System.nanoTime());
                    num2 = rn22.nextInt(100);
                    btn_num2.setText(Integer.toString(num2));
                    res_cor = num1 + num2;
                    contsumas = contsumas + 1;
                    tv_multi2.setText("+");
                    btn_enviar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            res_usrr = et_res.getText().toString();
                            if (res_usrr.isEmpty()) {
                                et_res.setError("Ingresa un numero");
                            } else {
                                res_usr = Integer.parseInt(res_usrr);
                                if (res_usr == res_cor) {
                                    acum = acum + 1;
                                    correcto = correcto + 1;
                                    btn_correcto.setText(Integer.toString(correcto));
                                    sumas = sumas + 1;
                                    Toast toastc = Toast.makeText(getApplicationContext(), "Correcto!, llevas acumulados " + acum, Toast.LENGTH_LONG);
                                    toastc.show();
                                    et_res.setText("");
                                } else {
                                    cora = cora - 1;
                                    btn_cora.setText(Integer.toString(cora));
                                    acum = 0;
                                    AlertDialog.Builder builder1 = new AlertDialog.Builder(RelojActivity.this);
                                    builder1.setTitle("ERROR");
                                    builder1.setMessage("El resultado de la suma de " + num1 + " + " + num2 + " era " + res_cor);
                                    builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast toasrer = Toast.makeText(getApplicationContext(), "Pierdes tus acomulados que llevabas", Toast.LENGTH_LONG);
                                            toasrer.show();
                                            et_res.setText("");
                                        }
                                    });
                                    builder1.show();
                                }
                                if (acum == 5) {
                                    cora = cora + 1;
                                    btn_cora.setText(Integer.toString(cora));
                                    acum = 0;
                                }
                                if (cora == 0) {
                                    puntaje = puntaje + 100;
                                } else {
                                    puntaje = puntaje + (cora * 100);
                                }
                                if (cora == 0) {
                                    AlertDialog.Builder builder3 = new AlertDialog.Builder(RelojActivity.this);
                                    builder3.setTitle("Fin del Juego");
                                    builder3.setMessage("No te queda mas corazones, ¿Quieres volver a empezar?");
                                    builder3.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent i = new Intent(RelojActivity.this, RelojActivity.class);
                                            startActivity(i);
                                        }
                                    });
                                    builder3.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent i = new Intent(RelojActivity.this, GameActivity.class);
                                        }

                                    });
                                    builder3.show();
                                }
                            }
                        }
                    });


        btn_puntaje.setText(Integer.toString(puntaje));

        new CountDownTimer(120000, 1000) {
            int totales = 0;
            public void onTick(long millisUntilFinished) {
                btn_time.setText(millisUntilFinished / 1000 + "s");
            }
            public void onFinish() {
                btn_time.setText("0s");
                gameOver = true;
                totales = contsumas + contrestas + contmultis;
                AlertDialog.Builder buildergameOver = new AlertDialog.Builder(RelojActivity.this);
                buildergameOver.setTitle("Se acabo!!!");
                buildergameOver.setMessage("Tus resultados: \n TOTAL = " + totales + "\n Sumas " + sumas + " de " + contsumas + "; \n Restas " + restas + " de " + contrestas + "; \n Multiplicaciones " + multis + " de " + contmultis + "; \n Puntaje total: " + puntaje + " .");
                buildergameOver.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(RelojActivity.this, GameActivity.class);
                        startActivity(i);
                    }
                });
                buildergameOver.show(); }}
        .start();

    }}