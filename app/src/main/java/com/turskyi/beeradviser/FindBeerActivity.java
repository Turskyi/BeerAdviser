package com.turskyi.beeradviser;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

/** Shows a txt view and a button with a drop down list and then with second text view with only one beer */
public class FindBeerActivity extends AppCompatActivity {
private BeerExpert expert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView brands = findViewById(R.id.brands);
                Spinner color = findViewById(R.id.color);
                String beerType = String.valueOf(color.getSelectedItem());
                brands.setText(beerType);

                //Get recommendation from the BeerExpert class
                List<String>brandsList = expert.getBrands(beerType); //get a list of brands
                StringBuilder brandsFormatted = new StringBuilder(); //build a string using the value in the list
                for (String brand : brandsList) {
                    brandsFormatted.append(brand).append('\n');
                }
                //Display the beers
                brands.setText(brandsFormatted); //Display the result in the text view.
            }
        });
    }
}
