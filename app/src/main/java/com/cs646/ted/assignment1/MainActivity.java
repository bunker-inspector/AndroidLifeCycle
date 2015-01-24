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
    String functionName;

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

        functionName = getString(R.string.on_create_text) + "\n";

        calledFunctionsText += functionName;
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        Log.d(getString(R.string.log_type_text), functionName);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        functionName = getString(R.string.on_restart_text) + "\n";

        calledFunctionsText += functionName;
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        Log.d(getString(R.string.log_type_text), functionName);
    }

    @Override
    protected void onStart() {
        super.onStart();

        functionName = getString(R.string.on_start_text) + "\n";

        calledFunctionsText += functionName;
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        Log.d(getString(R.string.log_type_text), functionName);
    }

    @Override
    protected void onPause() {
        super.onPause();

        functionName = getString(R.string.on_pause_text) + "\n";

        calledFunctionsText += functionName;
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        Log.d(getString(R.string.log_type_text), functionName);
    }

    @Override
    protected void onResume() {
        super.onResume();

        functionName = getString(R.string.on_resume_text) + "\n";

        calledFunctionsText += functionName;;
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        Log.d(getString(R.string.log_type_text), functionName);
    }

    /**
     * Saves current text in main TextView object in Bundle object
     *
     * @param savedInstanceState
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        functionName = getString(R.string.on_saveinst_text) + "\n";

        calledFunctionsText += functionName;
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        savedInstanceState.putString(USER_STATE, calledFunctionsText);

        Log.d(getString(R.string.log_type_text), functionName);
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

        functionName = getString(R.string.on_restinst_text) + "\n";

        calledFunctionsText = savedStateText + calledFunctionsText + functionName;
        calledFunctionsOutput = (TextView) this.findViewById(R.id.calledFunctionsOutput);
        calledFunctionsOutput.setText(calledFunctionsText);

        Log.d(getString(R.string.log_type_text), functionName);
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
