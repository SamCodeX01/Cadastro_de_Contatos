package com.example.cadastro_de_contatos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edNome, edCelular, edEmail;
    private Button btSalvar, btConsultar, btApagar;
    private TextView txtId;

    private void limparCampos(){
        txtId.setText("");
        edNome.setText("");
        edCelular.setText("");
        edEmail.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.txtId), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edNome = findViewById(R.id.edNome);
        edCelular = findViewById(R.id.edCelular);
        edEmail = findViewById(R.id.edEmail);
        btSalvar = findViewById(R.id.btSalvar);
        btConsultar = findViewById(R.id.btConsultar);
        btApagar = findViewById(R.id.btApagar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cria um novo contato com os dados dos campos.
                Contato c = new Contato();
                c.setNome(edNome.getText().toString());
                c.setCelular(edCelular.getText().toString());
                c.setEmail(edEmail.getText().toString());

                //Usa o ContatoDAO para salvar no banco.
                ContatoDAO dao = new ContatoDAO(MainActivity.this);
                dao.salvarContato(c);
                Toast.makeText(MainActivity.this, "Contato gravado com sucesso", Toast.LENGTH_SHORT).show();
                limparCampos(); //em vermelho
            }
        });

        btApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContatoDAO dao = new ContatoDAO(MainActivity.this);
                dao.excluirContato(Integer.parseInt(txtId.getText().toString())); //Pega o ID do contato.
                Toast.makeText(MainActivity.this,"Contato Excluído com Sucesso!", Toast.LENGTH_SHORT);
                limparCampos();
            }
        });

        btConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contato c = new Contato();
                ContatoDAO dao = new ContatoDAO(MainActivity.this);
                c = dao.consultarContatoPorNome(edNome.getText().toString());//Busca contato pelo nome.
                if(c != null){//Se encontrar, preenche os campos com os dados.
                        txtId.setText(String.valueOf(c.getId()));
                        edNome.setText(c.getNome());
                        edCelular.setText(c.getCelular());
                        edEmail.setText(c.getEmail());
                    }
                    else{//Se não encontrar, mostra mensagem.
                    Toast.makeText(MainActivity.this,"Contato não Cadastrado",
                                Toast.LENGTH_SHORT).show();
                    }
            }
        });

    }
}