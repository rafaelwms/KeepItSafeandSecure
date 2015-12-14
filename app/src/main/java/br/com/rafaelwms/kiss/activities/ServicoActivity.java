package br.com.rafaelwms.kiss.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.*;

import br.com.rafaelwms.kiss.R;
import br.com.rafaelwms.kiss.adapters.ServicoAdapter;
import br.com.rafaelwms.kiss.entidades.ImageEnum;
import br.com.rafaelwms.kiss.entidades.Servico;

public class ServicoActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }

}
