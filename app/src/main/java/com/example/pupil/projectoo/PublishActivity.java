package com.example.pupil.projectoo;

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
                Specs car = createCar(editSurName.getText().toString(),editName.getText().toString(), editText.getText().toString());
                start(car.getType(),car.getPassengers(),car.getName());
            }
        });

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
    public static Comment createCar(String name, String surname, String mtext){
        Comment specs = new Comment(type, pas, maxSpeed);
        return specs;
    }

}
