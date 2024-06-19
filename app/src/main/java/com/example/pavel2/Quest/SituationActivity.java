package com.example.pavel2.Quest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pavel2.Quest.Character;
import com.example.pavel2.Quest.Situation;
import com.example.pavel2.Quest.Story;
import com.example.pavel2.R;

public class SituationActivity extends AppCompatActivity {
    TextView kTv,aTv,rTv,textTv,nameTv;
    LinearLayout answers;
    Story story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.situation);
        kTv = findViewById(R.id.kTv);
        aTv = findViewById(R.id.aTv);
        rTv = findViewById(R.id.rTv);
        textTv = findViewById(R.id.textTV);
        nameTv = findViewById(R.id.nameTv);
        answers = findViewById(R.id.answers);
        story = new Story(new Character());
        show();
    }

    public void show() {

        String username = getIntent().getStringExtra("username");
        nameTv.setText(username);
        Situation s = story.getCurrent();
        textTv.setText(s.getDescription());
        answers.removeAllViews();
        for (int i = 0; i < s.getDirections().length; i++) {
            Button button = new Button(this);
            button.setText("" + (i +1));
            answers.addView(button);
            final int ii = i +1;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    story.go(ii);
                    show();
      //              if (story.isEnd()) {
      //                  finish();
      //              }
                }
            });
        }

    }
}