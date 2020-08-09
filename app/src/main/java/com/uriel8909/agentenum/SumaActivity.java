package com.uriel8909.agentenum;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class SumaActivity extends AppCompatActivity {

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
    Button btn_puntaje;
    int puntaje=0;
    int errores=0;
    boolean gameOver = false;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma);
        AlertDialog.Builder builder = new AlertDialog.Builder(SumaActivity.this);
        builder.setTitle("Como sumar");
        builder.setMessage("Vamos a ver un ejemplo. Sumemos 83 + 14 \n Ponemos el 83 y debajo 14, haciendo que coincidan las unidades, es decir, el 3 y el 4.\n Sumamos 3 + 4 = 7 y lo ponemos debajo de la columna de las unidades.\n Sumamos 8 + 1 = 9 y lo ponemos debajo de la columna de las decenas.\n Y como resultado tendremos 97.");
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
        btn_puntaje= findViewById(R.id.btn_puntaje);

        btn_puntaje.setText(Integer.toString(puntaje));

        btn_puntaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder7 = new AlertDialog.Builder(SumaActivity.this);
                builder7.setTitle("Puntaje");
                builder7.setMessage("Para conocer como calculamos tu puntaje, mientras mas corazones, mas puntos obtienes,multiplicamos tus corazones por 100");
                builder7.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                   }
                });
                builder7.show();
            }
        });



    btn_cora.setText(Integer.toString(cora));
        Random rn = new Random(System.currentTimeMillis());
        num1 = rn.nextInt(100);
        btn_num1.setText(Integer.toString(num1));
        Random rn2 = new Random(System.nanoTime());
        num2 = rn2.nextInt(100);
        btn_num2.setText(Integer.toString(num2));
        res_cor=num1+num2;
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
                                                  if (acum==5){
                                                      cora=cora+1;
                                                      btn_cora.setText(Integer.toString(cora));
                                                      acum=0;
                                                      if (cora == 5) {
                                                          AlertDialog.Builder builder4 = new AlertDialog.Builder(SumaActivity.this);
                                                          builder4.setTitle("Ganaste");
                                                          builder4.setMessage("Has alcanzado el numero maximo de vidas, F E L I C I D A D E S!!! Tu puntaje fue de " +puntaje);
                                                          builder4.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                              @Override
                                                              public void onClick(DialogInterface dialog, int which) {
                                                                  Intent i = new Intent(SumaActivity.this, GameActivity.class);
                                                                  startActivity(i);
                                                              }
                                                          });
                                                          builder4.show();
                                                      }
                                                  }
                                                  if (cora==0){
                                                      puntaje=puntaje+100;
                                                  } else{
                                                      puntaje=puntaje+(cora*100);
                                                  }
                                                  btn_puntaje.setText(Integer.toString(puntaje));
                                                  correcto = correcto + 1;
                                                  btn_correcto.setText(Integer.toString(correcto));
                                                  Toast toastc = Toast.makeText(getApplicationContext(), "Correcto!, llevas acumulados " + acum, Toast.LENGTH_LONG);
                                                  toastc.show();
                                                  et_res.setText("");
                                                  Random rn = new Random(System.currentTimeMillis());
                                                  num1 = rn.nextInt(100);
                                                  btn_num1.setText(Integer.toString(num1));
                                                  Random rn2 = new Random(System.nanoTime());
                                                  num2 = rn2.nextInt(100);
                                                  btn_num2.setText(Integer.toString(num2));
                                                  res_cor=num1+num2;
                                              }
                                              else {
                                                  AlertDialog.Builder builder1 = new AlertDialog.Builder(SumaActivity.this);
                                                  builder1.setTitle("ERROR");
                                                  builder1.setMessage("El resultado de la suma de " +num1 +" + " +num2 +" era "+res_cor);
                                                  builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                      @Override
                                                      public void onClick(DialogInterface dialog, int which) {
                                                          cora=cora-1;
                                                          errores=errores+1;
                                                          if (cora<0){
                                                              AlertDialog.Builder builder3 = new AlertDialog.Builder(SumaActivity.this);
                                                              builder3.setTitle("Fin del Juego");
                                                              builder3.setMessage("No te queda mas corazones, tu puntaje fue de " +puntaje);
                                                              builder3.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                                                  @Override
                                                                  public void onClick(DialogInterface dialog, int which) {
                                                                      Intent i = new Intent(SumaActivity.this,GameActivity.class);
                                                                      startActivity(i);                                                        }

                                                              });
                                                              builder3.show();}


                                                          btn_cora.setText(Integer.toString(cora));
                                                          acum = 0;
                                                          Toast toaster = Toast.makeText(getApplicationContext(), "Pierdes tus acomulados que llevabas", Toast.LENGTH_SHORT);
                                                          toaster.show();
                                                          btn_cora.setText(Integer.toString(cora));
                                                          Random rn = new Random(System.currentTimeMillis());
                                                          num1 = rn.nextInt(100);
                                                          btn_num1.setText(Integer.toString(num1));
                                                          Random rn2 = new Random(System.nanoTime());
                                                          num2 = rn2.nextInt(100);
                                                          btn_num2.setText(Integer.toString(num2));
                                                          res_cor=num1+num2;
                                                          et_res.setText("");
                                              }
                                          });
                                                  builder1.show();}
    }}});}}