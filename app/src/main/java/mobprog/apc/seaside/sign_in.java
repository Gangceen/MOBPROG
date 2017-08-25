package mobprog.apc.seaside;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class sign_in extends AppCompatActivity {
    public static String User_Email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Button button = (Button) findViewById(R.id.button2);
        final Intent intent = new Intent(this, MainActivity.class);
        final EditText editText = (EditText) findViewById(R.id.editText1);

        button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        User_Email = editText.getText().toString();
                        intent.putExtra(User_Email, User_Email);
                        startActivity(intent);
                    }
                }
        );
    }
}
