package br.com.rafaelwms.kiss.view_adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.rafaelwms.kiss.R;
import br.com.rafaelwms.kiss.entidades.Conta;

/**
 * Created by Rafael on 15/12/2015.
 */
public class ContaAdapter extends BaseAdapter {

    private List<Conta> contas;

    public ContaAdapter(List<Conta> lista){
        this.contas = lista;
    }

    @Override
    public int getCount() {
        return contas.size();
    }

    @Override
    public Object getItem(int position) {
        return contas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return contas.get(position).getIdConta();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Conta conta = contas.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conta, null);
        }

        ImageView img_item_conta = (ImageView)convertView.findViewById(R.id.img_item_conta);
        TextView txt_item_conta = (TextView)convertView.findViewById(R.id.txt_item_conta);
        TextView txt_item_conta_servidor = (TextView)convertView.findViewById(R.id.txt_item_conta_servidor);
        TextView txt_item_conta_porta = (TextView)convertView.findViewById(R.id.txt_item_conta_porta);



        return convertView;
    }
}
