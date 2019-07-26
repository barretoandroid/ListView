package br.com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.example.listview.adapter.MeuAdapter;
import br.com.example.listview.modelo.Tarefa;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Tarefa> tarefas = new ArrayList<>();
    private ArrayAdapter<Tarefa> meuAdapterTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvTarefas);

        criarTarefas();

        meuAdapterTarefa = new MeuAdapter(MainActivity.this,
                (ArrayList<Tarefa>) tarefas);
        listView.setAdapter(meuAdapterTarefa);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                tarefas.get(i).getNome(),
                                Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
        );
    }

    public void criarTarefas(){
        Tarefa tarefa1 = new Tarefa("1",
                "Lavar louça",
                "Lavar as louças do jantar");
        Tarefa tarefa2 = new Tarefa("2",
                "Estudar",
                "Estudar dev android");

        this.tarefas.add(tarefa1);
        this.tarefas.add(tarefa2);


    }

}
