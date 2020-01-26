package edu.quinnipiac.ser210.ch02demo;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Called when the user clicks the button
    public void onClickFindBeer(View view) {
        //Get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);

        //Get a reference to the spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        //Get selected item in the spinner
        String beerType = String.valueOf(color.getSelectedItem());

        //Get reccomendations from the BeerExpert class
       List<String> brandsList = expert.getBrands(beerType);
       StringBuilder brandsFormatted = new StringBuilder();
       for(String brand:brandsList){
           brandsFormatted.append(brand).append('\n');
       }

       //Display Beers
        brands.setText(brandsFormatted);
    }
}
