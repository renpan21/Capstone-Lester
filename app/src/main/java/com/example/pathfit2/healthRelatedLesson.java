package com.example.pathfit2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class healthRelatedLesson extends AppCompatActivity {
    RecyclerView recyclerView;
    pathfitHealthRelatedAdapter cardAdapter;
    ArrayList<pathfitCardItem> cardItemList;
    String[] cardTitle;
    int[] imageResource;
    String[] description;
    String[] topic;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_health_related_lesson);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        dataInitialized();
        toolbarIconsAction();

        recyclerView = findViewById(R.id.recyclerHealthRelated);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        cardAdapter = new pathfitHealthRelatedAdapter(this, cardItemList);
        recyclerView.setAdapter(cardAdapter);
    }
    public void toolbarIconsAction(){
        ImageButton backIcon, nextIcon;
        toolbar = findViewById(R.id.toolbar);
        backIcon = findViewById(R.id.left_icon);
        nextIcon = findViewById(R.id.right_icon);
        backIcon.setOnClickListener(v -> {

            Intent intent =  new Intent(healthRelatedLesson.this, pathfitFitnessLesson.class);
            startActivity(intent);
        });
        nextIcon.setOnClickListener(v -> {
            Intent intent =  new Intent(healthRelatedLesson.this, typesOfWeightTrainingActivity.class);
            startActivity(intent);
        });


    }


    private void dataInitialized() {
        cardItemList = new ArrayList<>();
        cardTitle = new String[]{
                //add yung title ng lesson 2
                getString(R.string.lesson2_FiveHealthRelatedComponentsOfPE),
                getString(R.string.lesson2_parametersOfPhysicalFitness),
                getString(R.string.lesson2_benefitsOfAddressingHealthRelatedComponents),


        };
        description = new String[]{
                getString(R.string.context),
                getString(R.string.context),
                getString(R.string.context),


        };
        topic = new String[]{
                //add yung topic ng lesson 2 na nakapaloob sa title
                getString(R.string.lesson2_FiveHealthRelatedComponentsOfPETopic),
                getString(R.string.lesson2_parametersOfPhysicalFitnessTopic),
                getString(R.string.lesson2_benefitsOfAddressingHealthRelatedComponentsTopic),



        };

        imageResource = new int[]{
                //need palitan ng image na tugma sa lesson topic
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,
                R.drawable.ic_launcher_background,


        };

        for (int i = 0; i < cardTitle.length; i++) {
            //dito nag add ng item
            pathfitCardItem items = new pathfitCardItem(cardTitle[i], description[i], topic[i], imageResource[i]);
            cardItemList.add(items);
        }


    }

}