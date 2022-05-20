package lut.bipika.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button secondActivityBtn = (Button)findViewById(R.id.secondActivityBtn);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent=new Intent((getApplicationContext()), SecondActivity.class);
                startIntent.putExtra("lut.bipika.quicklaucher.SOMETHING", "HELLO WORLD!!");
                startActivity(startIntent);
            }
        });

        Button googleBtn=(Button)findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google="https://www.google.com";
                Uri webaddress=Uri.parse(google);

                Intent gotoGoogle=new Intent(Intent.ACTION_VIEW, webaddress);
                //startActivity(gotoGoogle);
                if(gotoGoogle.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoGoogle);
                }
            }
        });
    }
}