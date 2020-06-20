package com.ilopes.organizzeclone.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.ilopes.organizzeclone.R;
import com.ilopes.organizzeclone.config.ConfigFirebase;
import com.ilopes.organizzeclone.model.User;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    private EditText campoemail,camposenha;
    private Button bentrar;
    private User user;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoemail = findViewById(R.id.editEmail);
        camposenha = findViewById(R.id.editSenha);
        bentrar =findViewById(R.id.buttonEntrar);

        bentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Textoemail = campoemail.getText().toString();
                String Textosenha = camposenha.getText().toString();

                if(!Textoemail.isEmpty()){

                    if(!Textosenha.isEmpty()){

                        user = new User();
                        user.setEmail(Textoemail);
                        user.setSenha(Textosenha);
                        validarlogin();

                    }else{
                        Toast.makeText(LoginActivity.this, "Preencha a senha!", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(LoginActivity.this, "Preencha o email!", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
    public void validarlogin(){
        auth = ConfigFirebase.getAuth();
        auth.signInWithEmailAndPassword(user.getEmail(),user.getSenha())
        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    abrirTelaprincipal();

                }else{

                    String exception = "";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e){
                        exception = "Usuario não está cadastrado!";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        exception = "Email e/ou senha não correspondem a um usuário cadastrado!";
                    }catch (Exception e){
                        exception = "Erro ao entrar:" + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(LoginActivity.this, exception, Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public void abrirTelaprincipal (){
        startActivity(new Intent(this, PrincipalActivity.class));
        finish();
    }
}
