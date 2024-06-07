package de.schrotthandel.notflix_streaming;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextLink);
        button = findViewById(R.id.streambtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getStreamLink = "https://s.to/serie/stream/rick-and-morty";
               // String url = editText.getText().toString();
                if (getStreamLink.startsWith("https://")) {
                    Parsing parsing = new Parsing(getApplicationContext(), MainActivity.this);
                    parsing.getSeriesInformation(getStreamLink);


                } else {
                    Toast.makeText(MainActivity.this, "Bitte geben Sie eine gültige S.to-URL ein", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Handler handler = new Handler(Looper.getMainLooper());

                CheckConnection checkConnection = new CheckConnection();
                boolean isAvailable = checkConnection.checkConnection();

                Log.d("CheckConnection", String.valueOf(isAvailable));
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (!isAvailable) {
                            Toast.makeText(getApplicationContext(), "Es besteht kein Internet!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }).start();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
