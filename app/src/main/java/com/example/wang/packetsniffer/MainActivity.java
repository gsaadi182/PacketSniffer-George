package com.example.wang.packetsniffer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startButtonOnClick(View view){
        ((TextView)findViewById(R.id.progressView)).setText("IN PROGRESS");
        //String commande="tcpdump > /data/local/output.txt\n";
        Process p;
        try {
            p = Runtime.getRuntime().exec(new String[]{"su", "-c", "chmod 777 /sdcard/programapp/tcpdump"});
            p = Runtime.getRuntime().exec(new String[]{"su", "-c", "tcpdump > /sdcard/programapp/test"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopButtonOnClick(View view) {
        ((TextView) findViewById(R.id.progressView)).setText("COMPLETED");

    }

}
