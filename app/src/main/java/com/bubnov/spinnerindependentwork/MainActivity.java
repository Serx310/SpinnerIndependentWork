package com.bubnov.spinnerindependentwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public double drinkPrice, sizePrice, totalPrice;
    Button totalBtn;
    TextView txtPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner drinksSpinner = findViewById(R.id.drinksSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.drinks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drinksSpinner.setAdapter(adapter);
        drinksSpinner.setOnItemSelectedListener(this);
        totalBtn = findViewById(R.id.totalBtn);
        txtPrice = findViewById(R.id.txtPrice);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String chosenDrink = adapterView.getItemAtPosition(0).toString();
        if(position == 0){
            totalBtn.setEnabled(false);
        }else{
            totalBtn.setEnabled(true);
            if(position == 1){
                drinkPrice = 1.5;
            }else if(position == 2){
                drinkPrice = 2;
            }else if(position == 3){
                drinkPrice = 2.5;
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radio_small:
                if(checked){
                    sizePrice = 0;
                    break;
                }
            case R.id.radio_medium:
                if(checked){
                    sizePrice = 1.5;
                    break;
                }
            case R.id.radio_large:
                if(checked){
                    sizePrice = 2.5;
                    break;
                }
        }
    }

    public void calculateTotal(View view){
        totalPrice = drinkPrice + sizePrice;
        txtPrice.setText("Total: "+totalPrice+"€");

    }
}