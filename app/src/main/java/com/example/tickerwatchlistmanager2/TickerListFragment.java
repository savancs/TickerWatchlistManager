package com.example.tickerwatchlistmanager2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;

public class TickerListFragment extends Fragment {
    //should list BAC, AAPL, DIS
    //clicking on that item should open https://seekingalpha.com/symbol/nameofthinginlist
    //should not have >6 in list. if so, replace 6th entry (lifo, stack?)

    ListView listview;
    ArrayList<String> symbols;
    ArrayAdapter<String> arrayadapter;
    Context context;
    MyViewModel sharedModel;

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //webview loadURL https://seekingalpha.com/symbol/nameofthinginlist
        }
    };
    public TickerListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ticker_list, container, false);
        listview = view.findViewById(R.id.listView1);
        listview.setOnItemClickListener(listener);
        symbols = new ArrayList<String>();
        context = container.getContext();
        arrayadapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        listview.setAdapter(arrayadapter);
        symbols.add("BAC");
        symbols.add("AAPL");
        symbols.add("DIS");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        return view;
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedModel = new
                ViewModelProvider(requireActivity()).get(MyViewModel.class);
    }

    Observer<LinkedList<String>> observer = new Observer<LinkedList<String>>() {
        @Override
        public void onChanged(LinkedList<String> tickerListFragments) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                    android.R.layout.simple_list_item_1, sharedModel.getTickers().getValue());
            listview.setAdapter(adapter);
        }

    };

}