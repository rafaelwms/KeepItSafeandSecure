package br.com.rafaelwms.kiss.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelwms.kiss.R;
import br.com.rafaelwms.kiss.adapters.ServicoAdapter;
import br.com.rafaelwms.kiss.entidades.ImageEnum;
import br.com.rafaelwms.kiss.entidades.Servico;



public class ListaServico extends AppCompatActivity implements View.OnClickListener{


    Button btn_novo_servico;
    ListView lista_servicos;
    ServicoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servico);

        List<Servico> mock = new ArrayList<>();

        mock.add(new Servico(1, "Facebook", ImageEnum.FACEBOOK, 0, 0));
        mock.add(new Servico(2, "Email", ImageEnum.KISS, 0, 0));
        mock.add(new Servico(3, "Twitter", ImageEnum.FACEBOOK, 0, 0));
        mock.add(new Servico(4, "FTP", ImageEnum.KISS, 1, 1));


        btn_novo_servico = (Button)findViewById(R.id.btn_novo_servico);
        lista_servicos = (ListView)findViewById(R.id.lstv_servicos);

        adapter = new ServicoAdapter(mock);

        lista_servicos.setAdapter(adapter);




    }

    @Override
    public void onClick(View v) {

    }
}