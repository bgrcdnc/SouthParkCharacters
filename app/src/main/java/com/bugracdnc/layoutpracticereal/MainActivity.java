package com.bugracdnc.layoutpracticereal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void showCharacterDetails(View view) {
        Intent intent = new Intent(this, CharacterDetails.class);
        intent.putExtra("clickedChar", view.getTag().toString());
        startActivity(intent);
    }

    public void easterEgg(View view) {
        AlertDialog.Builder easterEggAlert = new AlertDialog.Builder(this);
        easterEggAlert.setTitle("Error!");
        easterEggAlert.setMessage("You are supposed to click on the pictures!");
        easterEggAlert.setNegativeButton("NO! I'll do what I want!!", (dialog, which) -> {
            Toast.makeText(MainActivity.this, "Goodbye, my old friend...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Goodbye.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            this.finish();
        });
        easterEggAlert.setPositiveButton("Alright.", (dialog, which) -> Toast.makeText(MainActivity.this, "Good.", Toast.LENGTH_SHORT).show());
        easterEggAlert.show();
    }
}