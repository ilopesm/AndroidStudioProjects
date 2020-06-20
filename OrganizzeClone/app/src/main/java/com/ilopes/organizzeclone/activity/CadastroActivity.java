package com.ilopes.organizzeclone.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.ilopes.organizzeclone.R;
import com.ilopes.organizzeclone.config.ConfigFirebase;
import com.ilopes.organizzeclone.helper.Base64Custom;
import com.ilopes.organizzeclone.model.User;

public class CadastroActivity extends AppCompatActivity {
    private EditText camponome,campoemail,camposenha;
    private Button botaoCadastrar;
    private FirebaseAuth auth;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        camponome =findViewById(R.id.editNome);
        campoemail= findViewById(R.id.editEmail);
        camposenha = findViewById(R.id.editSenha);
        botaoCadastrar = findViewById(R.id.buttonCadastrarC);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String TextoNome = camponome.getText().toString();
                String Textoemail = campoemail.getText().toString();
                String Textosenha = camposenha.getText().toString();

                if(!TextoNome.isEmpty()){

                    if(!Textoemail.isEmpty()){

                        if(!Textosenha.isEmpty()){
                            user = new User(TextoNome,Textoemail,Textosenha);
                            cadastrarUsuario();

                        }else{
                            Toast.makeText(CadastroActivity.this, "Preencha a senha!", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(CadastroActivity.this, "Preencha o email!", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(CadastroActivity.this, "Preencha o nome!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void cadastrarUsuario(){

        auth = ConfigFirebase.getAuth();
        auth.createUserWithEmailAndPassword(user.getEmail(),user.getSenha()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    String idUsuario = Base64Custom.encode64(user.getEmail() );
                    user.setIduser(idUsuario);
                    user.salvar();
                    finish();

                }else{
                    String exception ="";
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        exception = "Digite uma senha mais forte!";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        exception = "Digite um email valido!";
                    }catch (FirebaseAuthUserCollisionException e){
                        exception = "Esta conta já foi cadastrada!";
                    }catch (Exception e){
                        exception = "Erro ao cadastrar usuario:" + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(CadastroActivity.this, exception, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
