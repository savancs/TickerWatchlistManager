package com.example.tickerwatchlistmanager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    FragmentManager fg;
    WebView webView;
    //ListView list;
    private MyViewModel sharedModel;
    //adding fragments to main activty xml causes app to crash
    //or crashes my entire emulator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] perms = new String[]{"Manifest.permission.RECEIVE_SMS"};
        ActivityCompat.requestPermissions(this, perms, 101);
        sharedModel = new ViewModelProvider(this).get(MyViewModel.class);
        //list.findViewById(R.id.listView1);


       // webView.findViewById(R.id.webView1);
        //webView.loadUrl("https://seekingalpha.com/");

        //fg = getSupportFragmentManager();
        //setContentView(R.layout.activity_main);
        /*if (savedInstanceState == null) {
            fg.beginTransaction().replace(R.id.webFragment, new InfoWebFragment()).commit();
            fg.beginTransaction().replace(R.id.listFragment, new TickerListFragment()).commit();
        }*/
    }
 /*   private void useStringResource() {
        String[] values = getResources().getStringArray(R.array.);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        list.setAdapter(adapter);
    }*/

}