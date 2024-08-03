package com.bugracdnc.layoutpracticereal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

public class CharacterDetails extends AppCompatActivity {

    Repository charRepo;
    TextView[] textViews = new TextView[5];
    int[] textViewsDict = {R.id.charName, R.id.nickname, R.id.firstAppear, R.id.createdBy, R.id.voicedBy};
    ImageView charImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_character_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        HashMap<String, Integer> imageMap = new HashMap<>();
        imageMap.put("stan", R.drawable.stanmarsh);
        imageMap.put("kyle", R.drawable.kylebroflovski);
        imageMap.put("eric", R.drawable.ericcartman);
        imageMap.put("kenny", R.drawable.kennymccormick);

        for(int i=0; i<textViews.length; i++) {
            textViews[i] = findViewById(textViewsDict[i]);
        }

        charImg = findViewById(R.id.charImg);

        charRepo = new Repository();

        Intent intent = getIntent();

        String charName =intent.getStringExtra("clickedChar");
        Character currChar = charRepo.characters.get(charName);

        if(currChar != null) {
            textViews[0].setText(String.format("%s %s", currChar.name, currChar.surname));
            if(!currChar.nickname.matches("")) {
                textViews[1].setText(String.format("%s %s", "Nickname : ", currChar.nickname));
            }
            else {
                textViews[1].setVisibility(View.GONE);
            }
            textViews[2].setText(String.format("%s %s", "First Appeared : ", currChar.firstAppearance));
            textViews[3].setText(String.format("%s %s", "Created by: ", currChar.createdBy));
            textViews[4].setText(String.format("%s %s", "Voiced by : ", currChar.voicedBy));
        }

        Integer imageId = imageMap.get(charName);
        if(imageId != null)
            charImg.setImageResource(imageId);
    }
}