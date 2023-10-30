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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fg;
    WebView webView;
    //ListView list;
    MyViewModel sharedModel;


    public void websiteUrl(String ticker){
        String url = "https://seekingalpha.com/symbol/" + ticker;
        webView.loadUrl(url);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] perms = new String[]{"Manifest.permission.RECEIVE_SMS"};
        ActivityCompat.requestPermissions(this, perms, 101);
        sharedModel = new ViewModelProvider(this).get(MyViewModel.class);
        //sharedModel.addDefaults();
        fg = getSupportFragmentManager();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.webFragment, new InfoWebFragment())
                    .replace(R.id.listFragment, new TickerListFragment())
                    .commit();
        }

    }
    //add onnewintent method
    //validate sms format
    //print toasts
    protected void onNewIntent (Intent intent) {
        super.onNewIntent(intent);
        String text = intent.getStringExtra("sms");

        if(text.startsWith("Ticker:<<") && text.endsWith(">>")){
            String input = text.substring(9, text.length() -2);
            if(input.matches("[a-zA-Z]+")){
                input.toUpperCase();
                websiteUrl(input);
                //addticker
            }
            else{
                Toast.makeText(this,"Invalid. Do not input symbols or numbers.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}