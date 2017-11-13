package guess.fju.com.guess;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bInfo = (Button) findViewById(R.id.b_info);
        bInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(R.string.INFO)
                        .setPositiveButton("OK", null)
                        .show();
            }
        }
        );
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

        if (num > iMin & num < iMax) {
            if (num > ans) {
                tvMax.setText(stNum);
            } else if (num < ans) {
                tvMin.setText(stNum);
            } else if (num == ans) {
                new AlertDialog.Builder(this)
                        .setMessage(R.string.correct)
                        .setNegativeButton("關閉", null)
                        .show();
            }
        } else {
            Toast.makeText(MainActivity.this, getString(R.string.error_1) + iMin + "~" + iMax + getString(R.string.error_2), Toast.LENGTH_SHORT).show();
        }
    }

}
