package com.intellectminds.cowsnbulls.activity;

import com.intellectminds.cowsnbulls.R;
import com.intellectminds.cowsnbulls.logic.GameLogic;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GamePageActivity extends Activity {

    private static boolean createRow = false;

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

        final TableLayout table = (TableLayout) findViewById(R.id.result_layout);
        //table.setLayoutParams(layoutParams);

        final GameLogic logic = new GameLogic();
        Button button = (Button) findViewById(R.id.match_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                logic.matchWord(wordText.getText().toString());

                {
                    TextView guessWord = new TextView(getApplicationContext());
                    guessWord.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    guessWord.setGravity(Gravity.CENTER_HORIZONTAL);
                    guessWord.setTextColor(Color.BLACK);
                    TextView cowsCount = new TextView(getApplicationContext());
                    cowsCount.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    cowsCount.setGravity(Gravity.CENTER_HORIZONTAL);
                    cowsCount.setTextColor(Color.BLACK);
                    TextView bullsCount = new TextView(getApplicationContext());
                    bullsCount.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
                    bullsCount.setGravity(Gravity.CENTER_HORIZONTAL);
                    bullsCount.setTextColor(Color.BLACK);

                    guessWord.setText(wordText.getText().toString());
                    cowsCount.setText(String.valueOf(logic.getCows()));
                    bullsCount.setText(String.valueOf(logic.getBulls()));

                    TableRow row = new TableRow(getApplicationContext());
                    row.addView(guessWord);
                    row.addView(cowsCount);
                    row.addView(bullsCount);

                    table.addView(row);
                    table.setStretchAllColumns(true);
                }

                wordText.setText("");

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
