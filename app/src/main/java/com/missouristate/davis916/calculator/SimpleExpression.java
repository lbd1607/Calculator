package com.missouristate.davis916.calculator;

/**
 * Laura Davis CIS 262-902
 * 16 February 2018
 * The SimpleExpression class contains code that
 * declares, initializes, gets, and sets
 * variables then runs mathematical computations
 * with if-else statements for each operator.
 */

public class SimpleExpression {
    //Declare variables
    private Integer mOperand1;
    private Integer mOperand2;
    private String mOperator;
    private Integer mValue;

    //Initialize variables
    public SimpleExpression(){
        mOperand1 = 0;
        mOperand2 = 0;
        mOperator = "+";
        mValue = 0;
    }//end SimpleExpression constructor

    public void setOperand1(int v){
        mOperand1 = v;
    }

    public int getOperand1(){
        return mOperand1;
    }

    public void setOperand2(int v){
        mOperand2 = v;
    }

    public int getOperand2(){
        return mOperand2;
    }

    public void setOperator(String s){
        mOperator = s;
    }

    public String getOperator(){
        return mOperator;
    }

    public Integer getValue(){
        computeValue();
        return mValue;
    }

    /*
     * Clears the operands within an expression
     */
    public void clearOperands(){
        mOperand1 = 0;
        mOperand2 = 0;
    }

    /*
     * Computes the integer value of an expression
     */
    private void computeValue(){
        mValue = 0;
        if(mOperator.contentEquals("+"))
            mValue = mOperand1 + mOperand2;
        else if(mOperator.contentEquals("-"))
            mValue = mOperand1 - mOperand2;
        else if(mOperator.contentEquals("X"))
            mValue = mOperand1 * mOperand2;
        else if(mOperator.contentEquals("/"))
            mValue = mOperand1 / mOperand2;
        else
            mValue = mOperand1 % mOperand2;
    }//end computeValue

}//end SimpleExpression
