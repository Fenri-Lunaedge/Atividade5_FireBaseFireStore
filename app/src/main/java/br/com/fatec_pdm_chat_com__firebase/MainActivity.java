package br.com.fatec_pdm_chat_com__firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText senhaEditText;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginEditText = findViewById(R.id.loginEditText);
        senhaEditText = findViewById(R.id.senhaEditText);
        firebaseAuth = FirebaseAuth.getInstance();
        setTitle("Sign In");
    }

    protected void onResume() {
        super.onResume();
        loginEditText.setText("");
        senhaEditText.setText("");

    }



    public void irParaCadastro (View view){
        startActivity(new Intent(this, NovoUsuarioActivity.class));
        }
    public void fazerLogin (View view){
        String login = loginEditText.getText().toString();
        String senha = senhaEditText.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(
                login,
                senha
        ).addOnSuccessListener((result) -> {
            Toast.makeText(
                    this,
                    getString(R.string.login_sucesso),
                    Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, Temas.class));

        }).addOnFailureListener((error) -> {
            Toast.makeText(
                    this,
                    getString(R.string.login_falhou),
                    Toast.LENGTH_SHORT).show();
        });
    }

}

