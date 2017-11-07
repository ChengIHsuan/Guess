package guess.fju.com.guess;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guess(View view){
        int ans = (int) (Math.random()*10+1);
        EditText edNum = (EditText) findViewById(R.id.ed_number);
        float num = Float.parseFloat(edNum.getText().toString());

        if (num == ans){
            new AlertDialog.Builder(this)
                    .setMessage(ans+"答對了!!")
                    .setNeutralButton("關閉", null)
                    .show();
        }else{
            if (num > ans){
                new AlertDialog.Builder(this)
                        .setMessage(ans+"小一點")
                        .setNeutralButton("關閉", null)
                        .show();
            }
            if (num < ans){
                new AlertDialog.Builder(this)
                        .setMessage(ans+"大一點")
                        .setNeutralButton("關閉", null)
                        .show();
            }
            
        }
    }

}
