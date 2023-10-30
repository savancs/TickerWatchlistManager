package com.example.tickerwatchlistmanager2;

import android.widget.ArrayAdapter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;

public class MyViewModel extends ViewModel {
    MutableLiveData<LinkedList<String>> tickers;
    MutableLiveData<String> current;
    LinkedList<String> history = new LinkedList<>();

    public MutableLiveData<String> getCurrent(){
        if(current == null){
            current = new MutableLiveData<>();
            current.setValue("BAC");
        }
        return current;
    }

    public void setCurrent(String newCurrent){
        if(current == null){
            current = new MutableLiveData<>();
            current.setValue(newCurrent);
        } else {current.setValue(newCurrent);}

    }
    public void addTicker(String newTicker){
        LinkedList<String> tickersList = tickers.getValue();
        tickersList.add(newTicker);
        tickers.setValue(tickersList);
    }
    public MutableLiveData<LinkedList<String>> getTickers(){
        if(tickers == null){
            tickers = new MutableLiveData<>();
            addDefaults();
        }
        return tickers;
    }

    public void setTickers(String name){
        if (tickers == null) {
            tickers= new MutableLiveData<>();
            getTickers();
        }
        history = tickers.getValue();
        if (history.size() == 6) {
            //remove oldest entry
            history.add(name);
        } else {
            history.add(name);
        }
    }



    public void addDefaults(){
        LinkedList<String> tickersList = tickers.getValue();
        tickersList.add("BAC");
        tickersList.add("AAPL");
        tickersList.add("DIS");
        tickers.setValue(tickersList);
    }


    //add ticker method to check size of list and then add to ticjer to list accordingly
    //and update cirrent ticker mutablelivedata using setTicker
}
