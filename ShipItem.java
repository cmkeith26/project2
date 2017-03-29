package com.cornez.shippingcalculator;

/*
* Programmer: Candace Keith
* Date: 02/27/17
* Lab: 10
* Purpose: To create shipping calculator in landscape view
*/

public class ShipItem {

    //SHIPPING CONSTANTS
    static final Double BASE = 3.00; //BASE constant
    static final Double ADDED = .50; //ADDED constant
    static final int BASE_WEIGHT = 16; //BASE_WEIGHT constant
    static final double EXTRA_OUNCES = 4.0; //EXTRA_OUNCES constant

    //DATA MEMBERS
    private Integer mWeight; //Integer mWeight
    private Double mBaseCost; //Double mBaseCost
    private Double mAddedCost; //Double mAddedCost
    private Double mTotalCost; //Double mTotalCost

    public ShipItem() {
        mWeight = 0;
        mAddedCost = 0.0;
        mBaseCost = BASE;
        mTotalCost = 0.0;
    }//End ShipItem

    public void setWeight (int weight){
        mWeight = weight;
        computeCosts();
    }//End setWeight

    private void computeCosts() {
        mAddedCost = 0.0;
        mBaseCost = BASE;

        if (mWeight <= 0)
            mBaseCost = 0.0;
        else if (mWeight > BASE_WEIGHT)
            mAddedCost = Math.ceil((double)
              (mWeight - BASE_WEIGHT) / EXTRA_OUNCES) * ADDED;

        mTotalCost = mBaseCost + mAddedCost;
    }//End computeCosts

    public Double getmBaseCost() {
        return mBaseCost;
    }

    public Double getmAddedCost() {
        return mAddedCost;
    }

    public Double getTotalCost() {
        return mTotalCost;
    }
}//End public class ShipItem
