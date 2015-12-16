package br.com.rafaelwms.kiss.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelwms.kiss.R;
import br.com.rafaelwms.kiss.entidades.Conta;
import br.com.rafaelwms.kiss.entidades.ImageEnum;
import br.com.rafaelwms.kiss.entidades.Servico;
import br.com.rafaelwms.kiss.entidades.Usuario;
import br.com.rafaelwms.kiss.repositorios.KissDAO;

public class ListaContaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    ListView listaContas;
    Button btn_deletar_conta;
    Button btn_nova_conta;
    Spinner spn_servicos;
    List<Conta> contas;
    List<Servico> servicos;
    Usuario usuario;
    KissDAO dao;
    Servico servico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_conta);
        dao = new KissDAO(this);

        listaContas = (ListView)findViewById(R.id.lstv_contas);
        btn_deletar_conta = (Button)findViewById(R.id.btn_deletar_conta);
        btn_nova_conta = (Button)findViewById(R.id.btn_nova_conta);
        spn_servicos = (Spinner)findViewById(R.id.spn_servicos);

        btn_deletar_conta.setOnClickListener(this);
        btn_nova_conta.setOnClickListener(this);

        spn_servicos.setOnItemSelectedListener(this);

        carrregarSpinner();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_nova_conta:
                Intent itNovo = new Intent(this, ContaActivity.class);
                Servico serv = new Servico();
                serv.setIdServico(1);
                serv.setIcoServico(ImageEnum.FACEBOOK);
                serv.setNomeServico("Facebook");
                serv.setUsaPorta(0);
                serv.setUsaServidor(0);
                itNovo.putExtra("Servico", serv);
                startActivity(itNovo);
                break;



        }
    }


    private void carrregarSpinner(){

        servico = new Servico();
        servicos = new ArrayList<>();
        servicos.add(new Servico(0,0,getResources().getString(R.string.txt_selecione_servico),0, 0, 0));

        for(Servico serv : dao.listarServicos(0)){
            servicos.add(serv);
        }

        ArrayAdapter<Servico> servicoAdapter =  new ArrayAdapter<Servico>(this,
                android.R.layout.simple_spinner_item, servicos);
        servicoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_servicos.setAdapter(servicoAdapter);

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent == spn_servicos){
            servico = (Servico)parent.getSelectedItem();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
}
