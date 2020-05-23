package br.com.fatec_pdm_chat_com__firebase;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Temas extends AppCompatActivity {


    static List<String> list;
    ListView l1;
    ArrayAdapter<String> adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas);
        setTitle("Temas");
        l1 = (ListView) findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        l1.setAdapter(adapter);
        list.add("Cinema");
        list.add("Economia");
        list.add("Futebol");
        list.add("Novidades");
        list.add("Tecnologia");

        l1.setOnItemClickListener((adapterView, view, i, l) -> {

            Intent intent = new Intent(Temas.this, ChatActivity.class);
            intent.putExtra("room_name", ((TextView) view).getText().toString());
            startActivity(intent);

        });
    }

    public static List<String> getList() {
        return list;
    }



}





