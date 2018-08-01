package razasadiq.smartkid2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Categ extends AppCompatActivity {

   public static RadioButton cb1;
   public static RadioButton cb2;
   public static RadioButton cb3;
   public static RadioButton cb4;
    Button bb1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_categ);
        cb1 = (RadioButton) findViewById(R.id.c1);
        cb2 = (RadioButton) findViewById(R.id.c2);
        cb3 = (RadioButton) findViewById(R.id.c3);
        cb4 = (RadioButton) findViewById(R.id.c4);
        cb1.setChecked(true);
        bb1 = (Button) findViewById(R.id.play);
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
