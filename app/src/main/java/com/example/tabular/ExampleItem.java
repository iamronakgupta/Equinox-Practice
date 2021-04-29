package com.example.tabular;

public class ExampleItem {
    private String mOccasion;
    private String mDate;

    public ExampleItem(String occasion,String date){
        mOccasion=occasion;
        mDate=date;
    }
    public String getOcassion(){
        return this.mOccasion;
    }
    public String getDate(){
        return this.mDate;
    }

}
