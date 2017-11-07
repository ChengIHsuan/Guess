package guess.fju.com.guess;

import android.content.DialogInterface;
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

        TextView tvMax = (TextView) findViewById(R.id.tv_max);
        TextView tvMin = (TextView) findViewById(R.id.tv_min);
        int iMax = Integer.parseInt(tvMax.getText().toString());
        int iMin = Integer.parseInt(tvMin.getText().toString());

        if (num >= iMin & num <= iMax) {
            if (num > ans) {
                tvMax.setText(stNum);
                iMax = num;
            } else if (num < ans) {
                tvMin.setText(stNum);
                iMin = num;
            } else if (num == ans) {
                new AlertDialog.Builder(this)
                        .setMessage(R.string.correct)
                        .setNegativeButton("關閉", null)
                        .show();
            }
        } else {
            TextView tv = (TextView) findViewById(R.id.tv_message);
            tv.setText(R.string.error);
        }
    }

}
