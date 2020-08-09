package com.uriel8909.agentenum;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.uriel8909.agentenum.common.Constantes;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    Button btn_agente;
    ListView listaMenu;
    ArrayList<String> arrayMenu;
    String nick;
    int cheat=7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        listaMenu= findViewById(R.id.listaMenu);
        btn_agente = findViewById(R.id.btn_agente);

        btn_agente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast toastprox = Toast.makeText(getApplicationContext(), "Proximamente...",Toast.LENGTH_SHORT);
                toastprox.show();}
        }
        );

        arrayMenu = new ArrayList<>();
        arrayMenu.add("Suma");
        arrayMenu.add("Resta");
        arrayMenu.add("Multiplicacion");
        arrayMenu.add("Contrareloj");
        if (cheat==0)
        {arrayMenu.add("Atajos");}
        ArrayAdapter adaptador = new ArrayAdapter<String>(GameActivity.this,android.R.layout.simple_list_item_1, arrayMenu);
        listaMenu.setAdapter(adaptador);
        listaMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(GameActivity.this,"Usted selecciono: " + arrayMenu.get(position),Toast.LENGTH_SHORT).show();
            if (position==0){
                Intent intent = new Intent(GameActivity.this,SumaActivity.class);
                startActivity(intent);
    }
        if (position==1){
            Intent intent = new Intent(GameActivity.this,RestaActivity.class);
            startActivity(intent);
        }
        if (position==2){
            Intent intent = new Intent(GameActivity.this,MultiActivity.class);
            startActivity(intent);
        }
        if (position==3){
            Intent intent = new Intent(GameActivity.this,RelojActivity.class);
            startActivity(intent);
            Toast.makeText(GameActivity.this,"No disponible",Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(GameActivity.this,DivActivity.class);
  //          startActivity(intent);
        }
        if (position==4){
            Toast.makeText(GameActivity.this,"No disponible",Toast.LENGTH_SHORT).show();
 //           Intent intent = new Intent(GameActivity.this,RelojActivity.class);
 //           startActivity(intent);
        }
    }
});
        listaMenu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
       if (position==0){
           AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
           builder.setTitle("SUMA");
           builder.setMessage("Tu mision es... \n Resuelver estos acertijos para llegar a tu objetivo, solo tienes 3 vidas, contesta 10 operaciones consecutivas para ganar una vida extra");
           builder.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
               }
           });
           if (position==1){
               AlertDialog.Builder builder1 = new AlertDialog.Builder(GameActivity.this);
               builder1.setTitle("RESTA");
               builder1.setMessage("Tu mision si decides aceptarla... \n Resuelve estos acertijos para llegar a tu objetivo, solo tienes 3 vidas, contesta 10 operaciones consecutivas para ganar una vida extra");
               builder1.setPositiveButton("Vamos!", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                   }
               });
               builder.show();
           }
           if (position==2){
               AlertDialog.Builder builder2 = new AlertDialog.Builder(GameActivity.this);
               builder2.setTitle("Multiplicaciones");
               builder2.setMessage("Tu mision si decides aceptarla... \n Resuelve estos acertijos para llegar a tu objetivo, solo tienes 3 vidas, contesta 10 operaciones consecutivas para ganar una vida extra");
               builder2.setPositiveButton("Vamos!", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                   }
               });
           }
           if (position==3){
               Toast.makeText(GameActivity.this,"No disponible",Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(GameActivity.this,DivActivity.class);
               //          startActivity(intent);
           }
       }
        return false;
    }
});

/*
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                builder.setTitle("Divisiones");
                builder.setMessage("Tu mision si decides aceptarla... \n Resuelve estos acertijos para llegar a tu objetivo, solo tienes 3 vidas, contesta 10 operaciones consecutivas para ganar una vida extra");
                builder.setPositiveButton("Vamos!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(GameActivity.this,DivActivity.class);
                        i.putExtra(Constantes.EXTRA_NICK, nick);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("No acepto", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });

        btn_reloj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                builder.setTitle("Contrareloj");
                builder.setMessage("En este modo te enfrentaras a diversas operaciones, la misma mecanica mas, tiempo, cada respuesta correcta le da a tu contador 3 segundos mas!");
                builder.setPositiveButton("Vamos!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(GameActivity.this,RelojActivity.class);
                        i.putExtra(Constantes.EXTRA_NICK, nick);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("No acepto", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });
*/
Bundle extras = getIntent().getExtras();
        String nick = extras.getString(Constantes.EXTRA_NICK);
        btn_agente.setText("Hola, " +nick);
    }
}
