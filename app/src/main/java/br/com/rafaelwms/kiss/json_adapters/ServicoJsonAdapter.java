package br.com.rafaelwms.kiss.json_adapters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import br.com.rafaelwms.kiss.entidades.Servico;

/**
 * Created by Rafael on 23/11/2015.
 */
public class ServicoJsonAdapter {


    public JSONObject ServicoToJsonConverter(Servico servico){
        try{
            JSONObject servicoJson = new JSONObject();
            servicoJson.put("idServico", servico.getIdServico());
            servicoJson.put("nomeServico", servico.getNomeServico());
            servicoJson.put("icoServico", servico.getIcoServico());
            return servicoJson;
        }catch(JSONException ex){
           ex.printStackTrace();
            return null;
        }
    }

    public JSONArray ServicosToJsonArrayConverter(List<Servico> servicos){
        try{
            JSONArray servicosJsonArray = new JSONArray();
            for(int i =0; i < servicos.size(); i++){
                JSONObject jsonObj = this.ServicoToJsonConverter(servicos.get(i));
                servicosJsonArray.put(jsonObj);
            }
            return servicosJsonArray;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }


    }



}
