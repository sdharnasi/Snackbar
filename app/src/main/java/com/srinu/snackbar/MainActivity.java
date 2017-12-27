package com.srinu.snackbar;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private CoordinatorLayout coordinatorLayout;
    private Button buttonSnackBarNormal;
    private Button buttonSnackBarCustomColor;
    private Button buttonSnackBarMultiTextColor;
    private Button buttonSnackBarWithActionCallBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();

    }

    private void initViews(){
        buttonSnackBarNormal = (Button) findViewById(R.id.buttonSnackBarNormal);
        buttonSnackBarCustomColor = (Button) findViewById(R.id.buttonSnackBarCustomColor);
        buttonSnackBarMultiTextColor = (Button) findViewById(R.id.buttonSnackBarMultiTextColor);
        buttonSnackBarWithActionCallBack = (Button) findViewById(R.id.buttonSnackBarWithActionCallBack);
         coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
    }

    private void initListeners(){
        buttonSnackBarNormal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout,"Snackbar Normal",Snackbar.LENGTH_SHORT).show();
            }
        });

        buttonSnackBarCustomColor.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View v){
                Snackbar mySnackbar = Snackbar.make(coordinatorLayout,"Server not Responding!",Snackbar.LENGTH_SHORT);
                mySnackbar.setActionTextColor(Color.WHITE);
                View snackbarView = mySnackbar.getView();
                TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.RED);
                mySnackbar.setAction("undo", new MySnackbarUndoListener());
                mySnackbar.show();
           }
        });

        buttonSnackBarMultiTextColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpannableStringBuilder snackbarText = new SpannableStringBuilder();
                snackbarText.append("Welcome to ");
                int boldStart = snackbarText.length();
                snackbarText.append("Android Tutorials Hub");
                snackbarText.setSpan(new ForegroundColorSpan(Color.CYAN),boldStart,snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                snackbarText.setSpan(new StyleSpan(Typeface.BOLD),boldStart,snackbarText.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                snackbarText.append(".");

                Snackbar.make(coordinatorLayout,snackbarText,Snackbar.LENGTH_SHORT).show();








                /*Snackbar.make(coordinatorLayout,"Snackbar Multi text color",Snackbar.LENGTH_SHORT).show();*/
            }
        });

        buttonSnackBarWithActionCallBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout,"Snackbar With Action callback",Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    public class MySnackbarUndoListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Snackbar.make(coordinatorLayout,"Undo operation Success",Snackbar.LENGTH_SHORT).show();
        }
    }
}
