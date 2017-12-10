package guess.fju.com.guess;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.max;
import static android.R.attr.min;

public class MainActivity extends AppCompatActivity {

    private EditText edNum;
    private TextView tvMax;
    private TextView tvMin;
    int max;
    int min;
    int ans;
    private int num;

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
        range();

    }

    public void range() {

        tvMax = (TextView) findViewById(R.id.tv_max);
        tvMin = (TextView) findViewById(R.id.tv_min);


        final String[] items = new String[]{"10", "50", "100", "200"};
        new AlertDialog.Builder(this)
                .setTitle("請選擇數字範圍")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvMin.setText("0");
                        tvMax.setText(items[i]);
                        min = Integer.parseInt(tvMin.getText().toString());
                        max = Integer.parseInt(tvMax.getText().toString());
                        ans = (int) (Math.random() * (max - 1) + 1);
                    }
                })
                .show();
    }

    public void guess(View view) {
        edNum = (EditText) findViewById(R.id.ed_number);
        num = Integer.parseInt(edNum.getText().toString());
        String sNum = String.valueOf(num);
        if (num > min && num < max) {
            if (num > ans) {
                tvMax.setText(sNum);
                max = num;
            } else if (num < ans) {
                tvMin.setText(sNum);
                min = num;
            } else if (num == ans) {
                new AlertDialog.Builder(this)
                        .setMessage(R.string.correct)
                        .setPositiveButton("再玩一次", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                range();
                                edNum.setText("");
                            }
                        })
                        .setNegativeButton("關閉", null)
                        .show();
            }
        } else {
            Toast.makeText(MainActivity.this, getString(R.string.error_1) + min + "~" + max + getString(R.string.error_2), Toast.LENGTH_SHORT).show();
        }
    }

}
