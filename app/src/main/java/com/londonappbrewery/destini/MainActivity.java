package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare member variables
    private TextView storyTextView;
    private Button topButton;
    private Button bottomButton;
    private int storyId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wire up the 3 views from the layout to the member variables:
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        topButton = (Button) findViewById(R.id.topButton);
        bottomButton = (Button) findViewById(R.id.bottomButton);

        // Initialize story index to represent the first story
        storyId = R.string.T1_Story;
    }
    
    public void onStoryPathSelected(View view) {
        Button pathSelectedButton = (Button) view;
        String pathSelected = pathSelectedButton.getText().toString();
        switch (storyId) {
            case R.string.T1_Story:
                storyId = pathSelected.equals(getString(R.string.T1_Ans1)) ?
                        R.string.T3_Story : R.string.T2_Story;
                break;
            case R.string.T2_Story:
                storyId = pathSelected.equals(getString(R.string.T2_Ans1)) ?
                        R.string.T3_Story : R.string.T4_End;
                break;
            case R.string.T3_Story:
                storyId = pathSelected.equals(getString(R.string.T3_Ans1)) ?
                        R.string.T6_End : R.string.T5_End;
                break;
            default:
                Log.e("Destiny", "Incorrect story index.");
                finish();
        }

        updateViewState();
    }

    private void updateViewState() {
        switch (storyId) {
            case R.string.T1_Story:
                storyTextView.setText(R.string.T1_Story);
                topButton.setText(R.string.T1_Ans1);
                bottomButton.setText(R.string.T1_Ans2);
                break;
            case R.string.T2_Story:
                storyTextView.setText(R.string.T2_Story);
                topButton.setText(R.string.T2_Ans1);
                bottomButton.setText(R.string.T2_Ans2);
                break;
            case R.string.T3_Story:
                storyTextView.setText(R.string.T3_Story);
                topButton.setText(R.string.T3_Ans1);
                bottomButton.setText(R.string.T3_Ans2);
                break;
            case R.string.T4_End:
                storyTextView.setText(R.string.T4_End);
                hideButtons();
                break;
            case R.string.T5_End:
                storyTextView.setText(R.string.T5_End);
                hideButtons();
                break;
            case R.string.T6_End:
                storyTextView.setText(R.string.T6_End);
                hideButtons();
                break;
            default:
                Log.e("Destiny", "Error occurred while trying to update view state.");
                finish();
        }
    }

    private void hideButtons() {
        topButton.setVisibility(View.GONE);
        bottomButton.setVisibility(View.GONE);
    }

}
