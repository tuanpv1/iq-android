package com.tuanpv.quickanswerapi.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tuanpv.quickanswerapi.R;

public class StartGame extends Activity implements View.OnClickListener{
    private Button btStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        btStart = (Button)findViewById(R.id.bt_start);
        btStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_start:
                Intent intent = new Intent(this, QuestionActivity.class);
                startActivity(intent);
                break;
        }
    }
}
