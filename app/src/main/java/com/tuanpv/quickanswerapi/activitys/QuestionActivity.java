package com.tuanpv.quickanswerapi.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tuanpv.quickanswerapi.R;

public class QuestionActivity extends Activity implements View.OnClickListener {
    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;

    private Button btChoice1;
    private Button btChoice2;
    private Button btChoice3;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);

        btChoice1 = (Button) findViewById(R.id.choice_one);
        btChoice2 = (Button) findViewById(R.id.choice_two);
        btChoice3 = (Button) findViewById(R.id.choice_three);

        btChoice1.setOnClickListener(this);
        btChoice2.setOnClickListener(this);
        btChoice3.setOnClickListener(this);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        if (isFirstRun) {
            updateQuestion();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.choice_one:
                String answerChoice1 = btChoice1.getText().toString();
                checkAnswer(answerChoice1);
                break;
            case R.id.choice_two:
                String answerChoice2 = btChoice2.getText().toString();
                checkAnswer(answerChoice2);
                break;
            case R.id.choice_three:
                String answerChoice3 = btChoice3.getText().toString();
                checkAnswer(answerChoice3);
                break;
        }
    }

    private void checkAnswer(String answer) {
        if (answer == mAnswer) {
            mScore = mScore + 1;
            updateScore(mScore);
            updateQuestion();
            Toast.makeText(QuestionActivity.this, "Correct", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(QuestionActivity.this, "Wrong", Toast.LENGTH_LONG).show();
            updateQuestion();
        }
    }

    private void updateScore(int score) {
        mScoreView.setText("" + score);
    }

    private void updateQuestion() {
        if (mQuestionNumber == mQuestionLibrary.getCountQuestion()) {
            Toast.makeText(QuestionActivity.this, "Finished", Toast.LENGTH_LONG).show();
            Intent intentFinish = new Intent(this, FinishQuestion.class);
            intentFinish.putExtra("score_sent", mScore);
            startActivity(intentFinish);
            this.finishActivity(0);
        } else {
            Log.i("m", "mQuestionNumber = " + mQuestionNumber);
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            btChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, mIndex));
            btChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, mIndex + 1));
            btChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, mIndex + 2));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
            mIndex = 0;
        }
    }
}
