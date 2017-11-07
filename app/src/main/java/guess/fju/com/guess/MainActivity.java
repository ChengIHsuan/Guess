package guess.fju.com.guess;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int ans = (int) (Math.random() * 10 + 1);

    public void guess(View view) {

        EditText edNum = (EditText) findViewById(R.id.ed_number);
        float num = Float.parseFloat(edNum.getText().toString());

        if (num > 0 & num <= 10) {
            if (num > ans) {
                TextView tv1 = (TextView) findViewById(R.id.tv_message);
                tv1.setText("小一點");
            } else if (num < ans) {
                TextView tv2 = (TextView) findViewById(R.id.tv_message);
                tv2.setText("大一點");
            } else if (num == ans) {
                TextView tv1 = (TextView) findViewById(R.id.tv_message);
                tv1.setText("答對了");
            }
        } else {
            TextView tv1 = (TextView) findViewById(R.id.tv_message);
            tv1.setText("輸入錯誤");
        }
    }
}
