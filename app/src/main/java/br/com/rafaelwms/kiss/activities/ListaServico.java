package br.com.rafaelwms.kiss.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.rafaelwms.kiss.R;
import br.com.rafaelwms.kiss.view_adapters.ServicoAdapter;
import br.com.rafaelwms.kiss.entidades.Servico;
import br.com.rafaelwms.kiss.repositorios.KissDAO;


public class ListaServico extends AppCompatActivity implements View.OnClickListener{


    Button btn_novo_servico;
    ListView lista_servicos;
    ServicoAdapter adapter;

    KissDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servico);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.servidoires);
        dao = new KissDAO(this);

        List<Servico> mock = dao.listarServicos(0);

        btn_novo_servico = (Button)findViewById(R.id.btn_novo_servico);
        lista_servicos = (ListView)findViewById(R.id.lstv_servicos);

        adapter = new ServicoAdapter(mock);

        lista_servicos.setAdapter(adapter);




    }

    @Override
    public void onClick(View v) {

    }
}