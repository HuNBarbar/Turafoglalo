package com.example.turafoglalo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HikingMainActivity extends AppCompatActivity {
    private static final String LOG_TAG = HikingMainActivity.class.getName();
    private FirebaseUser user;
    private FirebaseAuth mAuth;

    private TextView welcomeTextView;
    private Button btnNewBooking, btnMyBookings, btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiking_main);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        if (user == null) {
            Log.d(LOG_TAG, "Unauthenticated user, finishing.");
            finish();
            return;
        }

        // View-k bindolása
        welcomeTextView = findViewById(R.id.welcomeTextView);
        btnNewBooking = findViewById(R.id.buttonNewBooking);
        btnMyBookings = findViewById(R.id.buttonMyBookings);
        btnSignOut = findViewById(R.id.buttonSignOut);

        // Üdvözlő szöveg felhasználónévvel
        String name = user.getEmail(); // vagy user.getDisplayName()
        welcomeTextView.setText("Üdvözlünk, " + name + "!");

        // Gombok click listener-ei
        btnNewBooking.setOnClickListener(v -> {
            Log.d(LOG_TAG, "Új túra foglalása clicked");
            // TODO: navigáció a foglaló Activity-re
        });

        btnMyBookings.setOnClickListener(v -> {
            Log.d(LOG_TAG, "Foglalásaim clicked");
            // TODO: navigáció a foglalás listához
        });

        btnSignOut.setOnClickListener(v -> {
            mAuth.signOut();
            Log.d(LOG_TAG, "User signed out");
            finish();
        });
    }
}