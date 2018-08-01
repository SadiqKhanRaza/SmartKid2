package razasadiq.smartkid2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrontPage extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    MediaPlayer salman1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_front_page);
        this.b2 = (Button) findViewById(R.id.start);
        this.b4 = (Button) findViewById(R.id.sound);
        this.b5 = (Button) findViewById(R.id.abt);
        this.b3 = (Button) findViewById(R.id.follow);
        this.b2.setOnClickListener(this);
        this.b4.setOnClickListener(this);
        this.b5.setOnClickListener(this);
        this.b3.setOnClickListener(this);
        this.salman1 = MediaPlayer.create(this, R.raw.salman);
        this.salman1.start();
        this.salman1.setLooping(true);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                startActivity(new Intent(this, Categ.class));
                return;
            case R.id.sound:
                if (this.salman1.isPlaying()) {
                    this.b4.setText("on Music");
                    this.salman1.stop();
                    this.salman1.release();
                    this.salman1 = MediaPlayer.create(this, R.raw.salman);
                    return;
                }
                this.b4.setText("off music");
                this.salman1.start();
                this.salman1.setLooping(true);
                return;
            case R.id.abt:
                startActivity(new Intent(this, About.class));
                return;
            case R.id.follow:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.linkedin.com/in/sadiq-raza-741937127/")));
                return;
            default:
                return;
        }
    }

    protected void onStop() {
        super.onStop();
        if (isFinishing()) {
            this.salman1.stop();
            this.salman1.release();
        }
    }
}
