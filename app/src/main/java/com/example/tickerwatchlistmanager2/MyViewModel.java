package com.example.tickerwatchlistmanager2;

import android.widget.ArrayAdapter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;

public class MyViewModel extends ViewModel {
    MutableLiveData<LinkedList<String>> tickers;
    MutableLiveData<String> current;

    public MutableLiveData<String> getCurrent(){
        if(current == null){
            current = new MutableLiveData<>();
            current.setValue("BAC");
        }
        return current;
    }

    public void setCurrent(String newCurrent){
        current.setValue(newCurrent);
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

    private void addDefaults(){
        LinkedList<String> tickersList = tickers.getValue();
        tickersList.add("BAC");
        tickersList.add("AAPL");
        tickersList.add("DIS");
        tickers.setValue(tickersList);
    }



}
