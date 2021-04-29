package com.streamliners.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.streamliners.menu.Operations;


public class Transaction {
    public static String TYPE_EXPENSE = "e";
    public static String TYPE_INCOME = "i";

    private String type;
    private String date;
    private float amt;
    private String description;

    //date format
    SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");

     public Transaction(String type, String date, float amt, String description){
         try {
             this.date = String.valueOf(dateFormat.parse(date));
         } catch (ParseException e) {
             System.out.println("e");
         }
         this.description = description;
        this.amt = amt;
        this.type = type;

    }

    //All setter and getter methods of the class
    //set - to set format
    //get - return statement

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setAmt(float amt){
        this.amt = amt;
    }

    public float getAmt(){
        return amt;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}

