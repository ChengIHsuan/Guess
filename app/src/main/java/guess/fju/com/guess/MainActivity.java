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

    int ans = (int) (Math.random() * 100 + 1);

    public void guess(View view) {
        EditText edNum = (EditText) findViewById(R.id.ed_number);
        int num = Integer.parseInt((edNum.getText().toString()));
        String stNum = edNum.getText().toString();




        if (num >= 0 & num <= 100) {
            if (num > ans) {
                TextView tvMax = (TextView) findViewById(R.id.tv_max);
                tvMax.setText(stNum);
                
                //Toast.makeText(MainActivity.this, "小一點" , Toast.LENGTH_SHORT).show();

                /*TextView tv1 = (TextView) findViewById(R.id.tv_message);
                 tv1.setText("小一點");*/
            } else if (num < ans) {
                TextView tvMin = (TextView) findViewById(R.id.tv_min);
                tvMin.setText(stNum);

                //Toast.makeText(MainActivity.this, "大一點" , Toast.LENGTH_SHORT).show();

                /*TextView tv2 = (TextView) findViewById(R.id.tv_message);
                tv2.setText("大一點");*/
            } else if (num == ans) {
                new AlertDialog.Builder(this)
                        .setMessage("答對了!!!")
                        .setPositiveButton("OK", null)
                        .show();
                /*new AlertDialog.Builder(this)
                        .setMessage("答對了!!!")
                        .setPositiveButton("再玩一次", null)
                        .show();
                edNum.setText("");*/

                /*TextView tv1 = (TextView) findViewById(R.id.tv_message);
                tv1.setText("答對了");*/
            }
        } else {
            TextView tv1 = (TextView) findViewById(R.id.tv_message);
            tv1.setText("輸入錯誤");
        }
    }
}
