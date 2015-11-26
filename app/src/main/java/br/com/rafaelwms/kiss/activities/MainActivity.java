package br.com.rafaelwms.kiss.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.rafaelwms.kiss.R;
import br.com.rafaelwms.kiss.util.SimpleCrypto;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edit;
    Button butt;
    Button butt2;
    TextView text;
    String texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = "";
        edit = (EditText)findViewById(R.id.edtTst);
        butt = (Button)findViewById(R.id.btnTest);
        butt2 = (Button)findViewById(R.id.btnTest2);
        text = (TextView)findViewById(R.id.txtTest);

        butt.setOnClickListener(this);
        butt2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
    if(v.getId() == R.id.btnTest){
        try {
            texto = SimpleCrypto.encrypt("kiss", edit.getText().toString());
            text.setText(texto);
        }catch (Exception ex){
            ex.getStackTrace();
        }
    }
        if(v.getId() == R.id.btnTest2){
            try {
                texto = SimpleCrypto.decrypt("kiss", text.getText().toString());
                text.setText("");
                text.setText(texto);
            }catch (Exception ex){
                ex.getStackTrace();
            }
        }

    }
}
