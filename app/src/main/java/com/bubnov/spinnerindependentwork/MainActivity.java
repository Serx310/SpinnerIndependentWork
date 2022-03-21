package com.bubnov.spinnerindependentwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private List<Coffee> coffee;

    private Utils utils = new Utils();
    public double drinkPrice, sizePrice, totalPrice;
    Spinner drinksSpinner;
    Button totalBtn;
    TextView txtPrice;
    RadioButton m,l,s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coffee = utils.getCoffeeFormJsonFile((Context) this, "coffee.json");
        drinksSpinner = findViewById(R.id.drinksSpinner);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, coffee);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drinksSpinner.setAdapter(adapter);
        drinksSpinner.setOnItemSelectedListener(this);
        totalBtn = findViewById(R.id.totalBtn);
        txtPrice = findViewById(R.id.txtPrice);
        m = findViewById(R.id.radio_medium);
        l = findViewById(R.id.radio_large);
        s = findViewById(R.id.radio_small);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {



            for(Coffee drink : coffee) {
                if(position != 0){
                    totalBtn.setEnabled(true);
                    if(drink.getId() == position){
                        drinkPrice = drink.getPrice();
                        txtPrice.setText(drink.getDescription());

                        sizePrice = 0;
                        if(m.isChecked()){
                            sizePrice = 1.0;
                        }else if(l.isChecked()){
                            sizePrice = 1.5;
                        }




                        drinksSpinner.setSelection(0);
                        s.isChecked();
                        totalPrice = drinkPrice + sizePrice;
                        txtPrice.setText("Total: "+totalPrice+"€");
                    }
                }else{
                    totalBtn.setEnabled(false);
                    txtPrice.setText("");
                }
            }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void calculateTotal(View view){

    }
}