package cardoso.reis.ilanna.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar); //capturando o botão
        btnEnviar.setOnClickListener(new View.OnClickListener() { //ouvidor de clicks
            @Override
            public void onClick(View view) { //método assim que o ouvidor de clicks for ativado
                EditText etEmail = (EditText) findViewById(R.id.etEmail); //capturando o que for digitado no etEmail
                String email = etEmail.getText().toString(); //obtendo o texto

                EditText etAssunto = (EditText) findViewById(R.id.etAssunto);  //capturando o que for digitado no etAssunto
                String assunto = etAssunto.getText().toString(); //obtendo o texto

                EditText etTexto = (EditText) findViewById(R.id.etTexto);  //capturando o que for digitado no etTexto
                String texto = etTexto.getText().toString(); //obtendo o texto

                Intent i = new Intent(Intent.ACTION_SENDTO); //criando uma intent com uma ação de envio

                i.setData(Uri.parse("mailto:"));

                String[] emails = new String[] {email};
                i.putExtra(Intent.EXTRA_EMAIL, emails);
                i.putExtra(Intent.EXTRA_SUBJECT, assunto);
                i.putExtra(Intent.EXTRA_TEXT, texto);

                try {
                    startActivity(Intent.createChooser(i, "Escolha o APP"));
                }
                catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Não há nenhum app que posso realizar essa operação",
                            Toast.LENGTH_LONG).show();

                }

            }
        });



    }
}