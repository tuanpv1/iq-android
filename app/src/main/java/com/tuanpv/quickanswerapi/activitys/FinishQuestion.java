package com.tuanpv.quickanswerapi.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tuanpv.quickanswerapi.R;

public class FinishQuestion extends Activity implements View.OnClickListener {
    private Button btTryAgain;
    private TextView mScoreViewFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_question);

        int mScore = getIntent().getIntExtra("score_sent", 0);
        mScoreViewFinish = (TextView) findViewById(R.id.score_finish);
        mScoreViewFinish.setText("Your point is " + mScore);

        btTryAgain = (Button) findViewById(R.id.bt_try_again);
        btTryAgain.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_try_again:
                Intent openStartActivity = new Intent(this, StartGame.class);
                startActivity(openStartActivity);
                finish();
                break;
        }
    }
}
