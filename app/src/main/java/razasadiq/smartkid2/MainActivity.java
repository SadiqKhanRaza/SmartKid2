package razasadiq.smartkid2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements OnClickListener, OnInitListener {
    public static final String QUIZ_BACKGROUND = "settings_quiz_background";
    public static final String QUIZ_FONT = "settings_quiz_font";
    static Typeface Remachine;
    static Typeface Southern;
    static Typeface Starlight;
    static Typeface chunkfive;
    static String fileName;
    static String[] fl = new String[]{"Dahlia", "Daisy", "Jasmine", "Lily", "Lotus", "Rose", "Sun Flower", "Orchid", "Tulip"};
    static byte flag = (byte) 0;
    static Typeface fontlerybrown;
    static String[] fr = new String[]{"Apple", "Banana", "Grapes", "Mango", "Orange", "Papaya", "Pear", "Pine Apple", "Pome-granate", "Straw berry"};
    static int id;
    static int is = 0;
    static String[] pa = new String[]{"Cat", "Cows", "Dog", "Elephant",
            "GoldFish", "Hen", "Horse", "Mouse", "Rabbit", "Tortoise"};
    static String[] f16s = new String[]{"Bear", "Black Panther", "Donkey",
            "Elephant", "Fox", "Giraffe", "Jaguar", "Kangaroo", "Lion", "Rhino-ceros",
            "Snake", "Swamp Dear", "Tiger", "White Tiger", "Wolf", "Zebra"};
    static Typeface wonderbarDemo;
    static String[] xx;
    ImageView f17I;
    Button f18b;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    LinearLayout f19l;
    Random randomNumber;
    int[] secure = new int[6];
    private OnSharedPreferenceChangeListener settingsChangeListener = new C02571();
    TextToSpeech tts;
    String[] f20x;

    class C02571 implements OnSharedPreferenceChangeListener {
        C02571() {
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (key.equals(MainActivity.QUIZ_BACKGROUND)) {
                MainActivity.this.modifyBackground(sharedPreferences);
            } else if (key.equals(MainActivity.QUIZ_FONT)) {
                MainActivity.this.modifyQuizFont(sharedPreferences);
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        this.f19l = (LinearLayout) findViewById(R.id.mainActivity);
        this.b1 = (Button) findViewById(R.id.btn1);
        this.b2 = (Button) findViewById(R.id.btn2);
        this.b3 = (Button) findViewById(R.id.btn3);
        this.b4 = (Button) findViewById(R.id.btn4);
        this.b5 = (Button) findViewById(R.id.btn5);
        this.b6 = (Button) findViewById(R.id.btn6);
        this.b1.setOnClickListener(this);
        this.b2.setOnClickListener(this);
        this.b3.setOnClickListener(this);
        this.b4.setOnClickListener(this);
        this.b5.setOnClickListener(this);
        this.b6.setOnClickListener(this);
        this.f17I = (ImageView) findViewById(R.id.imgAnimal);
        this.randomNumber = new Random();
        this.tts = new TextToSpeech(this, this);
        xx = new String[f16s.length];
        xx = (String[]) f16s.clone();
        fileName = "Wild_Animals/Wild_Animals-";
        chunkfive = Typeface.createFromAsset(getAssets(), "fonts/Chunkfive.otf");
        fontlerybrown = Typeface.createFromAsset(getAssets(), "fonts/FontleroyBrown.ttf");
        wonderbarDemo = Typeface.createFromAsset(getAssets(), "fonts/Wonderbar Demo.otf");
        Starlight = Typeface.createFromAsset(getAssets(), "fonts/Starlight.ttf");
        Remachine = Typeface.createFromAsset(getAssets(), "fonts/Remachine.ttf");
        Southern = Typeface.createFromAsset(getAssets(), "fonts/Southern.ttf");
        PreferenceManager.setDefaultValues(this, R.xml.setting_screen, false);
        PreferenceManager.getDefaultSharedPreferences(this)
                .registerOnSharedPreferenceChangeListener(this.settingsChangeListener);
        questionWildAnimals();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(this, Settings.class));
        return super.onOptionsItemSelected(item);
    }

    public void modifyBackground(SharedPreferences sharedPreferences) {
        String background = sharedPreferences.getString(QUIZ_BACKGROUND, null);
        int obj = -1;
        switch (background.hashCode()) {
            case -1818419758:
                if (background.equals("Simple")) {
                    obj = 3;
                    break;
                }
                break;
            case 65203733:
                if (background.equals("Cloud")) {
                    obj = 1;
                    break;
                }
                break;
            case 69916416:
                if (background.equals("House")) {
                    obj = 4;
                    break;
                }
                break;
            case 81072245:
                if (background.equals("Trees")) {
                    obj = 0;
                    break;
                }
                break;
            case 2010799181:
                if (background.equals("Cactus")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case 0:
                this.f19l.setBackgroundResource(R.drawable.trees);
                return;
            case 1:
                this.f19l.setBackgroundResource(R.drawable.cloud);
                return;
            case 2:
                this.f19l.setBackgroundResource(R.drawable.cactus);
                return;
            case 3:
                this.f19l.setBackgroundResource(R.drawable.simple);
                return;
            case 4:
                this.f19l.setBackgroundResource(R.drawable.pic1);
                return;
            default:
                return;
        }
    }

    public void questionWildAnimals() {
        try {
            category();
            InputStream ims = getAssets().open(fileName + xx[is] + ".jpg");
            this.f17I.setImageDrawable(Drawable.createFromStream(ims, null));
            ims.close();
            uniqueRandomNumbers();
            this.b1.setText(xx[this.secure[0]]);
            this.b2.setText(xx[this.secure[1]]);
            this.b3.setText(xx[this.secure[2]]);
            this.b4.setText(xx[this.secure[3]]);
            this.b5.setText(xx[this.secure[4]]);
            this.b6.setText(xx[this.secure[5]]);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Asset file not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void uniqueRandomNumbers() {
        int i;
        ArrayList<Integer> list = new ArrayList();
        for (i = 0; i < xx.length - 1; i++) {
            list.add(new Integer(i));
        }
        list.remove(is);
        int rrr = this.randomNumber.nextInt(6) + 0;
        Collections.shuffle(list);
        for (i = 0; i <= 5; i++) {
            this.secure[i] = ((Integer) list.get(i)).intValue();
        }
        this.secure[rrr] = is;
    }

    public void check() {
        if (this.f18b.getText().toString().equals(xx[is])) {
            flag = (byte) 1;
            speakOut();
            Toast.makeText(getApplicationContext(), "RIGHT", Toast.LENGTH_SHORT).show();
            if (is < xx.length - 2) {
                is++;
                questionWildAnimals();
            } else {
                is = 0;
            }
            questionWildAnimals();
            return;
        }
        flag = (byte) 0;
        Toast.makeText(getApplicationContext(), "WRONG", Toast.LENGTH_SHORT).show();
        speakOut();
    }

    public void onClick(View view) {
        ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(50);
        id = view.getId();
        this.f18b = (Button) findViewById(id);
        check();
    }

    public void modifyQuizFont(SharedPreferences sharedPreferences) {
        String fontStringValue = sharedPreferences.getString(QUIZ_FONT, null);
        int obj = -1;
        switch (fontStringValue.hashCode()) {
            case -1118702196:
                if (fontStringValue.equals("Southern.ttf")) {
                    obj = 5;
                    break;
                }
                break;
            case 87752062:
                if (fontStringValue.equals("Wonderbar Demo.otf")) {
                    obj = 2;
                    break;
                }
                break;
            case 757304028:
                if (fontStringValue.equals("Starlight.ttf")) {
                    obj = 3;
                    break;
                }
                break;
            case 1643956108:
                if (fontStringValue.equals("Remachine.ttf")) {
                    obj = 4;
                    break;
                }
                break;
            case 1850506034:
                if (fontStringValue.equals("Chunkfive.otf")) {
                    obj = 0;
                    break;
                }
                break;
            case 1893109978:
                if (fontStringValue.equals("FontleroyBrown.ttf")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case 0:
                this.b1.setTypeface(chunkfive);
                this.b2.setTypeface(chunkfive);
                this.b3.setTypeface(chunkfive);
                this.b4.setTypeface(chunkfive);
                this.b5.setTypeface(chunkfive);
                this.b6.setTypeface(chunkfive);
                return;
            case 1:
                this.b1.setTypeface(fontlerybrown);
                this.b2.setTypeface(fontlerybrown);
                this.b3.setTypeface(fontlerybrown);
                this.b4.setTypeface(fontlerybrown);
                this.b5.setTypeface(fontlerybrown);
                this.b6.setTypeface(fontlerybrown);
                return;
            case 2:
                this.b1.setTypeface(wonderbarDemo);
                this.b2.setTypeface(wonderbarDemo);
                this.b3.setTypeface(wonderbarDemo);
                this.b4.setTypeface(wonderbarDemo);
                this.b5.setTypeface(wonderbarDemo);
                this.b6.setTypeface(wonderbarDemo);
                return;
            case 3:
                this.b1.setTypeface(Starlight);
                this.b2.setTypeface(Starlight);
                this.b3.setTypeface(Starlight);
                this.b4.setTypeface(Starlight);
                this.b5.setTypeface(Starlight);
                this.b6.setTypeface(Starlight);
                return;
            case 4:
                this.b1.setTypeface(Remachine);
                this.b2.setTypeface(Remachine);
                this.b3.setTypeface(Remachine);
                this.b4.setTypeface(Remachine);
                this.b5.setTypeface(Remachine);
                this.b6.setTypeface(Remachine);
                return;
            case 5:
                this.b1.setTypeface(Southern);
                this.b2.setTypeface(Southern);
                this.b3.setTypeface(Southern);
                this.b4.setTypeface(Southern);
                this.b5.setTypeface(Southern);
                this.b6.setTypeface(Southern);
                return;
            default:
                return;
        }
    }

    public void onDestroy() {
        if (this.tts != null) {
            this.tts.stop();
            this.tts.shutdown();
        }
        super.onDestroy();
    }

    public void onInit(int status) {
        if (status == 0) {
            int result = this.tts.setLanguage(Locale.US);
            if (result == -1 || result == -2) {
                Log.e("TTS", "This Language is not supported");
                return;
            }
            return;
        }
        Log.e("TTS", "Initilization Failed!");
    }

    private void speakOut() {
        String text = xx[is];
        String text1 = "No,Wrong ";
        if (flag == (byte) 1) {
            this.tts.speak("  " + text + "!Correct", 0, null, null);
            flag = (byte) 0;
            return;
        }
        this.tts.speak(text1, 0, null, null);
    }

    public void category() {
        if (Categ.cb2.isChecked()) {
            xx = new String[pa.length];
            xx = (String[]) pa.clone();
            fileName = "Tame_Animals/Tame_Animals-";
        } else if (Categ.cb3.isChecked()) {
            xx = new String[fr.length];
            xx = (String[]) fr.clone();
            fileName = "Fruits/Fruits-";
        } else if (Categ.cb4.isChecked()) {
            xx = new String[fl.length];
            xx = (String[]) fl.clone();
            fileName = "Flowers/Flowers-";
        } else {
            xx = new String[f16s.length];
            xx = (String[]) f16s.clone();
            fileName = "Wild_Animals/Wild_Animals-";
        }
    }
}

