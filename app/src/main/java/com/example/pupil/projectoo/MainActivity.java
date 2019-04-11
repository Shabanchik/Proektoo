package com.example.pupil.projectoo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Comment;

public class MainActivity extends AppCompatActivity {
    Button btnClose;
    Button pub;
    Button coment;
    ISharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClose=findViewById(R.id.btnClose);
        pub=findViewById(R.id.pub);
        coment=findViewById(R.id.coment);
        preference= new MySharedPreferences(this);
        if(preference.isFirstStart()){
            Toast.makeText(this,"Application first start",Toast.LENGTH_LONG).show();
            preference.setisFirstStart(false);
        }

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        coment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CommentActivity.class);
                startActivity(intent);
            }
        });



        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        firestore.setFirestoreSettings(settings);
        firestore.collection("Tablee")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.i("Tablee", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.e("Tablee", "Error getting documents.", task.getException());
                        }
                    }
                });
    }


}
