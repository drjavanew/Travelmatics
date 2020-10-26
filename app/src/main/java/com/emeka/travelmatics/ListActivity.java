package com.emeka.travelmatics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ArrayList<TravelDeal> deals;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        FirebaseUtil.openFbReference("traveldeals");

        RecyclerView rvDeals = (RecyclerView) findViewById(R.id.rvDeals);
        final DealAdapter adapter = new DealAdapter();
        rvDeals.setAdapter(adapter);
        LinearLayoutManager dealsLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvDeals.setLayoutManager(dealsLayoutManager);
    }
}