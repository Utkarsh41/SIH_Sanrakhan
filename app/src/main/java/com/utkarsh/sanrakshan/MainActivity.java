package com.utkarsh.sanrakshan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    sAdapter adapter;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Loading Data ...", Toast.LENGTH_SHORT).show();

        databaseReference=FirebaseDatabase.getInstance().getReference().child("ut");


        recyclerView = findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<MyData> options = new FirebaseRecyclerOptions.Builder<MyData>().setQuery(databaseReference,MyData.class).build();
        adapter = new sAdapter(options);
        recyclerView.setAdapter(adapter);

        ProgressBar pb = (ProgressBar) findViewById(R.id.idPbLoading);
        pb.setVisibility(ProgressBar.VISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pb.setVisibility(ProgressBar.INVISIBLE);
            }
        }, 4000);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}