package com.eyelindev.balancebuddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import model.Model;
import model.user.UserInfo;

import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText fNameInput;
    private EditText lNameInput;
    Model model = new Model();
    Context context;
    private UserInfo userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //gather name, confirm name and move on.
            }
        });



        fNameInput = (EditText) findViewById(R.id.fName);
        lNameInput = (EditText) findViewById(R.id.lName);

        //if user enters text in first name text box and presses enter
        fNameInput.setOnKeyListener(new OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                String fNameString = fNameInput.getText().toString();
                String lNameString = lNameInput.getText().toString();
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    fNameString = fNameInput.getText().toString();
                    lNameString = fNameInput.getText().toString();
                    System.out.println(">>>Line # 60: First name: " + fNameString);
                    System.out.println(">>>Line # 61: Last name: " + lNameString);
                    if (fNameInput.getText().toString().isEmpty() || lNameInput.getText().toString().isEmpty()) {
                        //do nothing
                        System.out.println("DOING NOTHING");
                        return false;
                    } else if (!fNameInput.getText().toString().isEmpty() && !lNameInput.getText().toString().isEmpty()) {
                        model.initUserInfo(fNameString, lNameString);
                        beginUserSetup();
                        return true;
                    }
                    return false;
                }
                return true;
            }
        });

        //if user enters text in last name text box and presses enter
        lNameInput.setOnKeyListener(new OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                String fNameString = fNameInput.getText().toString();
                String lNameString = lNameInput.getText().toString();
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    fNameString = fNameInput.getText().toString();
                    lNameString = fNameInput.getText().toString();
                    System.out.println(">>>Line # 88: First name: " + fNameString);
                    System.out.println(">>>Line # 89: Last name: " + lNameString);
                    if (fNameInput.getText().toString().isEmpty() || lNameInput.getText().toString().isEmpty()) {
                        //do nothing
                        return false;
                    } else if (!fNameInput.getText().toString().isEmpty() && !lNameInput.getText().toString().isEmpty()) {
                        model.initUserInfo(fNameString, lNameString);
                        beginUserSetup();
                        return true;
                    }
                    return false;
                }
                return true;
            }
        });


    }

    public boolean beginUserSetup() {


        Intent setupIntent = new Intent(context, SetupActivity1.class);
        setupIntent.putExtra("userInfo", userInfo);
        startActivity(setupIntent);

        return true;
    }

    public Model getModel() {
        return model;
    }
    /*


final EditText edittext = (EditText) findViewById(R.id.edittext);
edittext.setOnKeyListener(new OnKeyListener() {
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        // If the event is a key-down event on the "enter" button
        if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
            (keyCode == KeyEvent.KEYCODE_ENTER)) {
          // Perform action on key press
          Toast.makeText(HelloFormStuff.this, edittext.getText(), Toast.LENGTH_SHORT).show();
          return true;
        }
        return false;
    }
});


     */

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
