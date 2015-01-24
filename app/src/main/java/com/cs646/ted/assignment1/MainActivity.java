package com.cs646.ted.assignment1;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    TextView calledFunctionsOutput;
    String calledFunctionsText  = "";

    static final String USER_STATE = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Selects proper layout depending on device rotation
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_portrait);
        }
        else {
            setContentView(R.layout.activity_main_landscape);
        }

        //Creates Clear button which sets TextView object to empty string on click
        final Button clear = (Button) findViewById(R.id.clear_button);
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calledFunctionsOutput = (TextView) findViewById(R.id.calledFunctionsOutput);
                calledFunctionsText = "";
                calledFunctionsOutput.setText(calledFunctionsText);
            }
        });

        calledFunctionsText += "onCreate\n";
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        Log.d("Function name", "onCreate\n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        calledFunctionsText += "onRestart\n";
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        Log.d("Function name", "onRestart\n");
    }

    @Override
    protected void onStart() {
        super.onStart();

        calledFunctionsText += "onStart\n";
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        Log.d("Function name", "onStart\n");
    }

    @Override
    protected void onPause() {
        super.onPause();

        calledFunctionsText += "onPause\n";
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        Log.d("Function name", "onPause\n");
    }

    @Override
    protected void onResume() {
        super.onResume();

        calledFunctionsText += "onResume\n";
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        Log.d("Function name", "onResume\n");
    }

    /**
     * Saves current text in main TextView object in Bundle object
     *
     * @param savedInstanceState
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        calledFunctionsText += "onSavedInstanceState\n";
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        savedInstanceState.putString(USER_STATE, calledFunctionsText);

        Log.d("Function name", "onSaveInstanceState\n");
    }

    /**
     * Retrieves text saved in onSaveInstanceState and forms complete record of function calls
     * including those occuring between saving and loading state information
     *
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String savedStateText = savedInstanceState.getString(USER_STATE);
        calledFunctionsText = savedStateText + calledFunctionsText + "onRestoreInstanceState\n";
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        Log.d("Function name", "onRestoreInstanceState\n");
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
}
