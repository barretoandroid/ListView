package br.com.example.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.example.listview.R;
import br.com.example.listview.modelo.Tarefa;

public class MeuAdapter extends ArrayAdapter<Tarefa> {

    //Contexto da aplicação
    private Context context;
    private List<Tarefa> tarefas;

    public MeuAdapter(Context context, ArrayList<Tarefa> list){
        super(context, 0, list);
        this.context = context;
        tarefas = list;
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent){
        //listItem é a nossa View layout_lista.xml
        View listItem = convertView;
        if (listItem == null){
            listItem = LayoutInflater.from(context).inflate(R.layout.layout_lista
                    , parent
                    , false);
        }

        Tarefa tarefaAtual = tarefas.get(posicao);

        TextView textViewNome = listItem.findViewById(R.id.tvNome);
        TextView textViewDesc = listItem.findViewById(R.id.tvDescricao);

        textViewNome.setText(tarefaAtual.getNome());
        textViewDesc.setText(tarefaAtual.getDescricao());

        return listItem;

    }


}
