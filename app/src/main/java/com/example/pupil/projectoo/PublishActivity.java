package com.example.pupil.projectoo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Comment;

import java.util.HashMap;
import java.util.Map;

public class PublishActivity extends AppCompatActivity {
    public EditText editName;
    public EditText editSurName;
    public EditText editText;
    public TextView name;
    public TextView surname;
    public TextView text;
    private Button publish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);
        text=findViewById(R.id.text);
        editName=findViewById(R.id.editName);
        editSurName=findViewById(R.id.editSurName);
        editText=findViewById(R.id.editText);
        publish=findViewById(R.id.publish);

        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Need message = createMessage(editSurName.getText().toString(),editName.getText().toString(), editText.getText().toString());
//                start(message.getSurName(),message.getName(),message.getText());
            }
        });

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> user = new HashMap<>();
        user.put("surName", "Hanna");
        user.put("name", "Hanna");
        user.put("text", "BlaBlaBlaBlaBla");
        user.put("Comment", "what was that???");

        db.collection("Blog")

                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("", "Error adding document", e);
                    }
                });
    }
//    public static Comment createMessage(String name, String surName, String text){
//        Comment com = new Comment(name,surName,text);
//        return com;
//    }
//    private void start(String type, String pas, String maxSpeed){
//        Intent intent = new Intent(this,ResultActivity.class).putExtra("type",type).putExtra("pas",pas).putExtra("maxSpeed",maxSpeed);
//        startActivity(intent);
//    }


}
