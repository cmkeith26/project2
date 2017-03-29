package com.cornez.shippingcalculator;
/*
* Programmer: Candace Keith
* Date: 02/27/17
* Lab: 10
* Purpose: To create shipping calculator in landscape view
*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends AppCompatActivity {
    //DATA MODEL FOR SHIP ITEM
    private ShipItem shipItem;

    //VIEW OBJECTS FOR LAYOUT UI REFERENCE
    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TASK 1: SET ACTIVITY CONTENT
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //TASK 2: CREATE A DATA MODEL FOR STORING AN ITEM TO BE SHIPPED
        shipItem = new ShipItem();

        //TASK 3: ESTABLISH THE REFERENCES TO INPUT WEIGHT ELEMENT
        weightET = (EditText) findViewById(R.id.editText1);

        //TASK 4: ESTABLISH THE REFERENCES TO OUTPUT ELEMENTS
        baseCostTV = (TextView) findViewById(R.id.textView4);
        addedCostTV = (TextView) findViewById(R.id.textView6);
        totalCostTV = (TextView) findViewById(R.id.textView8);

        //TASK 5: REGISTER THE LISTENER EVENT FOR WEIGHT INPUT
        weightET.addTextChangedListener(weightTextWatcher);

    }//End onCreate for shipping calculator
    private TextWatcher weightTextWatcher = new TextWatcher() {
        //THE INPUT ELEMENT IS ATTACHED TO AN EDITABLE,
        //THEREFORE THESE METHODS ARE CALLED WHEN THE TEXT IS CHANGED

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try{
                shipItem.setWeight((int)
                    Double.parseDouble(s.toString()));
            }catch (NumberFormatException e){
                shipItem.setWeight(0);
            }//End catch
            displayShipping();
        }//End onTextChanged

        @Override
        public void afterTextChanged(Editable s) {}
        public void beforeTextChanged(CharSequence s,
                                       int start, int count, int after){}
    };//End TextWatcher
    private void displayShipping() {
        //DISPLAY THE BASE COST, ADDED COST, AND TOTAL COST
        baseCostTV.setText("$" + String.format("%.02f",
                    shipItem.getmBaseCost()));
        addedCostTV.setText("$" + String.format("%.02f",
                    shipItem.getmAddedCost()));
        totalCostTV.setText("$" + String.format("%.02f",
                shipItem.getTotalCost()));
    }//End displayShipping


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
        //Inflate the menu;
          getMenuInflater().inflate(R.menu.my, menu);
          return true;
        }//End boolean onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle action bar item clicks here. The action bar will
        //automatically handle clicks on the Home/Up butotn, so long
        //as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_setttings){
            return true;
        }//End if
        return super.onOptionsItemSelected(item);
    }//End boolean onOptionsItemSelected
}// End public class MyActivity
