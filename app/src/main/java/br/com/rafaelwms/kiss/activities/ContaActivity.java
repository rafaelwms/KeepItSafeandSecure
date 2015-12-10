package br.com.rafaelwms.kiss.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.rafaelwms.kiss.R;
import br.com.rafaelwms.kiss.entidades.Servico;

public class ContaActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edtContaLogin;
    EditText edtContaSenha1;
    EditText edtContaSenha2;
    EditText edtContaServidor;
    EditText edtContaPorta;
    Button   btnContaSalvar;

    ImageView imgContaServico;
    TextView  txtNomeServico;
    TextView  txtInfoServico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        //Elementos da parte da nova Conta.
        edtContaLogin = (EditText)findViewById(R.id.edt_Conta_Login);
        edtContaSenha1 = (EditText)findViewById(R.id.edt_Conta_Senha1);
        edtContaSenha2 = (EditText)findViewById(R.id.edt_Conta_Senha2);
        edtContaServidor = (EditText)findViewById(R.id.edt_Conta_Servidor);
        edtContaPorta = (EditText)findViewById(R.id.edt_Conta_Porta);
        btnContaSalvar = (Button)findViewById(R.id.btn_Conta_Salvar);
        btnContaSalvar.setOnClickListener(this);

        //Elementos de amostra do Serviço a qual a conta estará associada.
        imgContaServico = (ImageView)findViewById(R.id.imgServico_activity_conta);
        txtNomeServico  = (TextView)findViewById(R.id.txtNomeServico_activity_conta);
        txtInfoServico  = (TextView)findViewById(R.id.txtInfoServico);
        /**
         *
         */
        Intent it = getIntent();
        Servico servico = new Servico();
        servico = (Servico)it.getSerializableExtra("Servico");

        txtNomeServico.setText(R.string.lbl_Servico + " "+ servico.getNomeServico());
        txtInfoServico.setText(getResources().getText(R.string.lbl_UsaServidor)+": "+ String.valueOf(servico.getUsaServidor())
        +"\n"+getResources().getText(R.string.lbl_UsaPorta)+": "+ String.valueOf(servico.getUsaPorta()));

        if(servico.getUsaServidor() == 0){
            edtContaServidor.setVisibility(View.INVISIBLE);
        }
        if(servico.getUsaPorta() == 0){
            edtContaPorta.setVisibility(View.INVISIBLE);
        }





    }

    @Override
    public void onClick(View v) {

    }
}
