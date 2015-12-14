package br.com.rafaelwms.kiss.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.rafaelwms.kiss.R;
import br.com.rafaelwms.kiss.entidades.Servico;
import br.com.rafaelwms.kiss.util.SimpleCrypto;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView imgMainServicos;
    ImageView imgMainContas;
    ImageView imgMainAjustes;
    ImageView imgMainLog;

    Button btnMainServicos;
    Button btnMainContas;
    Button btnMainAjustes;
    Button btnMainLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        setContentView(R.layout.activity_main);

        imgMainServicos = (ImageView) findViewById(R.id.img_servidores);
        imgMainContas = (ImageView) findViewById(R.id.img_contas);
        imgMainAjustes = (ImageView) findViewById(R.id.imgAjustes);
        imgMainLog = (ImageView) findViewById(R.id.imgLog);

        btnMainServicos = (Button) findViewById(R.id.btnServicos);
        btnMainContas = (Button) findViewById(R.id.btnContas);
        btnMainAjustes = (Button) findViewById(R.id.btnAjustes);
        btnMainLog = (Button) findViewById(R.id.btnLog);

        btnMainServicos.setOnClickListener(this);
        btnMainContas.setOnClickListener(this);
        btnMainAjustes.setOnClickListener(this);
        btnMainLog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btnServicos:
                Intent it1 = new Intent(this, ListaServico.class);
                startActivity(it1);
                break;

            case R.id.btnContas:
                Intent it = new Intent(this, ContaActivity.class);
                Servico serv = new Servico();
                serv.setIdServico(1);
                serv.setNomeServico("Facebook");
                serv.setUsaPorta(0);
                serv.setUsaServidor(0);
                it.putExtra("Servico", serv);
                startActivity(it);
                break;

            case R.id.btnAjustes:
                break;

            case R.id.btnLog:
                break;

            default:
                break;
        }


    }
}