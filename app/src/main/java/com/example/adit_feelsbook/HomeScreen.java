package com.example.adit_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    private ArrayList<Feeling> mFeelingsList;
    private FeelingsManager mFeelingsManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mFeelingsManager = new FeelingsManager();
        mFeelingsList = new ArrayList<>();
        // load all saved emotions
    }

    // Adding feelings
    public void addLove(View view)       { mFeelingsList.add(new Feeling(FeelingState.Love)); }
    public void addJoy(View view)        { mFeelingsList.add(new Feeling(FeelingState.Joy)); }
    public void addSurprise(View view)   { mFeelingsList.add(new Feeling(FeelingState.Surprise)); }
    public void addAnger(View view)      { mFeelingsList.add(new Feeling(FeelingState.Anger)); }
    public void addSadness(View view)    { mFeelingsList.add(new Feeling(FeelingState.Sadness)); }
    public void addFear(View view)       { mFeelingsList.add(new Feeling(FeelingState.Fear)); }

    @Override
    protected void onPause()
    {
        super.onPause();
        Feeling[] feelings;
        Log.d("Serializer", Integer.toString(mFeelingsList.size()));
        feelings = mFeelingsList.toArray(new Feeling[mFeelingsList.size()]);
        mFeelingsManager.SaveFeelings(feelings);
    }

    public void ShowHistory(View view)
    {
        // Navigate to History Screen
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
}
