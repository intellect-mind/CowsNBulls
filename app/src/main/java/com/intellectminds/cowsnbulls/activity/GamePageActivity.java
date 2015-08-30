package com.intellectminds.cowsnbulls.activity;

import com.intellectminds.cowsnbulls.R;
import com.intellectminds.cowsnbulls.logic.GameLogic;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GamePageActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_page_activity);

        final EditText wordText = (EditText) findViewById(R.id.word_text);
        wordText.setPaintFlags(wordText.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        InputFilter[] filterArray = new InputFilter[2];
        filterArray[0] = new InputFilter.AllCaps();
        filterArray[1] = new InputFilter.LengthFilter(10);
        wordText.setGravity(Gravity.CENTER);
        wordText.setFilters(filterArray);

        final TextView cows = (TextView) findViewById(R.id.cows);
        final TextView bulls = (TextView) findViewById(R.id.bulls);

        final GameLogic logic = new GameLogic();
        Button button = (Button) findViewById(R.id.match_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.matchWord(wordText.getText().toString());
                cows.setText(String.valueOf(logic.getCows()));
                bulls.setText(String.valueOf(logic.getBulls()));
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    public void showGamePageActivity(View view) {
    }
}
