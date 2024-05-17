package com.marcos.whatsapplist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.marcos.whatsapplist.Adapter.AdapterUsuario;
import com.marcos.whatsapplist.Model.Usuario;
import com.marcos.whatsapplist.RecyclerItemClickListener.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_usuario;
    private List<Usuario> usuarioList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_usuario = findViewById(R.id.recycler_usuarios);

        recycler_usuario.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        recycler_usuario.setHasFixedSize(true);
        AdapterUsuario adapterUsuario = new AdapterUsuario(usuarioList);
        recycler_usuario.setAdapter(adapterUsuario);

        usuarios();

        //Evento de click na recyclerView
        recycler_usuario.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recycler_usuario,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Usuario usuario = usuarioList.get(position);

                        Toast.makeText(getApplicationContext(),"Usuário: " + usuario.getNome(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Usuario usuario = usuarioList.get(position);
                        Toast.makeText(getApplicationContext(),"Usuário: " + usuario.getNome(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));
    }

    public void usuarios(){

        Usuario usuario1 = new Usuario(R.drawable.usuario1,"Marcos","Olá como vai?");
        usuarioList.add(usuario1);

        Usuario usuario2 = new Usuario(R.drawable.usuario2, "Loirinha", "Tudo bem e você?");
        usuarioList.add(usuario2);

        Usuario usuario3 = new Usuario(R.drawable.rock, "Isaias Mamaco", "Tudo bem e você?");
        usuarioList.add(usuario3);

        Usuario usuario4 = new Usuario(R.drawable.zuck, "Iury", "Tudo bem e você?");
        usuarioList.add(usuario4);
    }
}