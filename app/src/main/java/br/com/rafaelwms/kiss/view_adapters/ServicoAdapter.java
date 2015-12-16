package br.com.rafaelwms.kiss.view_adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.rafaelwms.kiss.R;
import br.com.rafaelwms.kiss.entidades.Servico;

/**
 * Created by rafael.marques.de.sa on 14/12/2015.
 */
public class ServicoAdapter extends BaseAdapter {

    private List<Servico> servicos;

    public ServicoAdapter(List<Servico> lista){
        this.servicos = lista;
    }

    @Override
    public int getCount() {
        return servicos.size();
    }

    @Override
    public Object getItem(int position) {
        return servicos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return servicos.get(position).getIdServico();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Servico serv = servicos.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_servico, null);
        }

        ImageView img_item_servico = (ImageView)convertView.findViewById(R.id.img_item_servico);
        TextView txt_item_servico = (TextView)convertView.findViewById(R.id.txt_item_servico);
        CheckBox ckb_item_servico_servidor = (CheckBox)convertView.findViewById(R.id.ckb_item_servico_servidor);
        CheckBox ckb_item_servico_porta = (CheckBox)convertView.findViewById(R.id.ckb_item_servico_porta);

        img_item_servico.setImageResource(serv.getIcoServico());
        txt_item_servico.setText(serv.getNomeServico());
        ckb_item_servico_servidor.setChecked(serv.getUsaServidor() == 1);
        ckb_item_servico_porta.setChecked(serv.getUsaPorta() == 1);


        return convertView;
    }
}
