package br.com.rafaelwms.kiss.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.rafaelwms.kiss.R;
import br.com.rafaelwms.kiss.entidades.ImageEnum;
import br.com.rafaelwms.kiss.entidades.Servico;
import br.com.rafaelwms.kiss.repositorios.KissDAO;
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

    KissDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        setContentView(R.layout.activity_main);
        dao = new KissDAO(this);

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

        cargaInicial();

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btnServicos:
                Intent it1 = new Intent(this, ListaServico.class);
                startActivity(it1);
                break;

            case R.id.btnContas:
                Intent it = new Intent(this, ListaContaActivity.class);
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

    private void cargaInicial(){

        List<Servico> servicos = dao.listarServicos(0);

        if(servicos == null || servicos.size() == 0){

            Servico facebook = new Servico(0,"Facebook", ImageEnum.FACEBOOK,0, 0);
            Servico twitter = new Servico(0,"Twitter", ImageEnum.TWITTER,0, 0);
            Servico hotmail = new Servico(0,"Microsoft Outlook", ImageEnum.MICROSOFT,0, 0);
            Servico ftp = new Servico(0,"Ftp", ImageEnum.FTP, 1, 1);

            dao.insertServico(facebook);
            dao.insertServico(twitter);
            dao.insertServico(hotmail);
            dao.insertServico(ftp);
        }



    }


}