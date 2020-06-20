package com.ilopes.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    //private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    //private FirebaseAuth usuario = FirebaseAuth.getInstance();

    private ImageView imagemFoto;
    private Button buttonUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagemFoto = findViewById(R.id.imageFoto);
        buttonUpload = findViewById(R.id.buttonUpload);

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //configura para a imagem ser salva na memoria
                imagemFoto.setDrawingCacheEnabled(true);
                imagemFoto.buildDrawingCache();

                //recuperar o bitmap da imagem
                Bitmap bitmap = imagemFoto.getDrawingCache();

                //comprimir o bitmap em png/jpeg
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,75,baos);

                //converte o baos para pixel brutos em uma matriz de bytes
                //(dados da imagem)
                byte[] dadosimage = baos.toByteArray();

                //definir nós para a fbstorage
                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                StorageReference imagens = storageReference.child("Imagens");
                StorageReference imagemRef = imagens.child("celular.jpeg");

                Glide.with(MainActivity.this).load(imagemRef).into(imagemFoto);

                /*imagemRef.delete().addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Falha ao deletar imagem" +e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Sucesso ao deletar a imagem", Toast.LENGTH_SHORT).show();
                    }
                });*/

                /*
                //nome imagem
                //String nomeArquivo = UUID.randomUUID().toString();
                StorageReference imagemRef = imagens.child("celular.jpeg");

                //retorna o obj que ira controlar o upload
                UploadTask uploadTask = imagemRef.putBytes(dadosimage);

                uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Upload da Imagem falhou" +e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Uri url = taskSnapshot.getUploadSessionUri();
                        Toast.makeText(MainActivity.this, "Upload da Imagem foi um sucesso"+ url.toString(), Toast.LENGTH_SHORT).show();
                    }
                });*/
            }
        });

        //DatabaseReference users = databaseReference.child("users");
        //DatabaseReference usuarioPesquisa = users.child("-M4qRl9qL_PQA2pr4AXi");
        //Query usuarioPesquisa = users.orderByChild("nome").equalTo("Isaac");
        //Query usuarioPesquisa = users.orderByKey().limitToFirst(3);
        //Query usuarioPesquisa = users.orderByKey().limitToLast(2);
        //maior ou igual
        //Query usuarioPesquisa = users.orderByChild("idade").startAt(35);
        //menor ou igual
        //Query usuarioPesquisa = users.orderByChild("idade").endAt(35);
        //entre dois valores
        //Query usuarioPesquisa = users.orderByChild("idade").startAt(20).endAt(35);
        //fitrarpalvaras
        /*Query usuarioPesquisa = users.orderByChild("nome").startAt("L").endAt("L"+"\uf8ff");
        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                /*User user = dataSnapshot.getValue(User.class);
                Log.i("Dados usuario:",user.getNome());
                Log.i("Dados usuario:",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */
        /*
        User user = new User();
        user.setNome("Lee");
        user.setIdade(19);
        user.setSobrenome("Dias");
        users.push().setValue(user);*/
        //deslogar user
        //usuario.signOut();

        //logar user
        /*usuario.signInWithEmailAndPassword("isaaclopes11@hotmail.com","16021998").addOnCompleteListener(MainActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("CreateUser","Logado com sucesso!");
                        }else{
                            Log.i("CreateUser","Falha ao logar");
                        }

                    }
                });*/

        //Verificar usuario logado
        /*if(usuario.getCurrentUser() != null){
            Log.i("CreateUser","User logado!");
        }else{
            Log.i("CreateUser","User não esta logado!");
        }*/
        //cadastra usuario
        /*usuario.createUserWithEmailAndPassword("isaaclopes11@hotmail.com","16021998")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("CreateUser","Sucesso ao cadastrar o usuario!");
                        }else{
                            Log.i("CreateUser","Falha ao cadastras o usuario");
                        }
                    }
                });*/

        /*DatabaseReference users = databaseReference.child("users").child("001");
        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        DatabaseReference users = databaseReference.child("users");
        User user = new User();
        user.setNome("Rabisco");
        user.setIdade(18);
        user.setSobrenome("Flausino");
        users.child("002").setValue(user);*/
    }
}
