package com.example.pupil.projectoo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PublicActivity extends AppCompatActivity {
    public EditText editName;
    public EditText editSurName;
    public EditText editText;
    public TextView name;
    public TextView surname;
    public TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public);
        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);
        text=findViewById(R.id.text);
        editName=findViewById(R.id.editName);
        editSurName=findViewById(R.id.editSurName);
        editText=findViewById(R.id.editText);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> user = new HashMap<>();
        user.put("SurName", "Hanna");
        user.put("Name", "Hanna");
        user.put("Text", "BlaBlaBlaBlaBla");
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

}
