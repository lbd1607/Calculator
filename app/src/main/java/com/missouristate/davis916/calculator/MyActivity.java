/*
 * Laura Davis CIS 262-902
 * 16 February 2018
 * This program creates and runs a basic
 * calculator app. MyActivity.java uses
 * the SimpleExpressions class to
 * compute basic mathematical computations.
 */

package com.missouristate.davis916.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    private TextView mNumberDisplay;
    private SimpleExpression mExpression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mNumberDisplay = (TextView) findViewById(R.id.textView1);

        mExpression = new SimpleExpression();
    }//end onCreate

    public void goAC(View view){
        mExpression.clearOperands();
        mNumberDisplay.setText("0");
    }//end goAC

    public void goOperand(View view){
        String val = (String) mNumberDisplay.getText();
        String digit = (String) view.getContentDescription();
        if(val.charAt(0) == '0')
            mNumberDisplay.setText(digit);
        else
            mNumberDisplay.setText((String) mNumberDisplay.getText() + digit.charAt(0));
    }//end goOperand

    public void goOperator(View view){
        String operator = (String) view.getContentDescription();
        try{
            String val = (String) mNumberDisplay.getText();
            mExpression.setOperand1((int) Integer.parseInt(val.toString()));
        }
        catch (NumberFormatException e){
            mExpression.setOperand1(0);
        }
        mNumberDisplay.setText("0");
        mExpression.setOperator(operator);
    }//end goOperator

    //When the = button is clicked, compute and display value
    public void goCompute(View view){
        try{
            String val = (String) mNumberDisplay.getText();
            mExpression.setOperand2((int) Integer.parseInt(val.toString()));
        }
        catch (NumberFormatException e){
            mExpression.setOperand2(0);
        }
        mNumberDisplay.setText(mExpression.getValue().toString());
    }//end goCompute

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }//end onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        /*
         * Handle menu bar item clicks here. The action
         * bar will automatically handle clicks on the
         * Home/Up button, as long as you specify a
         * parent activity in AndroidManifest.xml
        */
        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);

    }//end onOptionsItemSelected

}//end MyActivity
