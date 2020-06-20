package com.ilopes.meczap.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.ilopes.meczap.R;
import com.ilopes.meczap.config.ConfigFb;
import com.ilopes.meczap.model.User;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText camponome, campoemail,camposenha;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        camponome = findViewById(R.id.Inputnome);
        campoemail= findViewById(R.id.inputemail);
        camposenha = findViewById(R.id.inputsenha);
    }

    public void validauser(View view){

        String textoNome = camponome.getText().toString();
        String textoemail = campoemail.getText().toString();
        String textosenha = camposenha.getText().toString();

        if(!textoNome.isEmpty()){
            if(!textoemail.isEmpty()){
                if(!textosenha.isEmpty()){
                    User user = new User(textoNome,textoemail,textosenha);
                    cadastraruserfb(user);
                }else{
                    Toast.makeText(this, "Preencha a senha!", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Preencha o email!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Preencha o nome!", Toast.LENGTH_SHORT).show();
        }

    }
    public void cadastraruserfb(User user){

           auth = ConfigFb.getAuth();
           auth.createUserWithEmailAndPassword(user.getEmail(),user.getSenha())
                   .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if(task.isSuccessful()){
                               Toast.makeText(CadastroActivity.this, "Sucesso ao cadastrar usuário", Toast.LENGTH_SHORT).show();
                               finish();
                           }else{
                               String exc = "";
                               try {
                                   throw task.getException();
                               }catch (FirebaseAuthWeakPasswordException e){
                               exc = "Digite uma senha mais forte!";
                               } catch (FirebaseAuthInvalidCredentialsException e){
                                   exc = "Por favor, digite um e-mail válido";
                               }catch (FirebaseAuthUserCollisionException e){
                                   exc = "Esta conta já foi cadastrada";
                               }
                               catch (Exception e){
                                    exc = "Erro ao cadastrar o usuario: " + e.getMessage();
                                    e.printStackTrace();
                               }
                               Toast.makeText(CadastroActivity.this, exc, Toast.LENGTH_SHORT).show();
                           }
                       }
                   });

    }
}
