package com.example.admin.homeapp01;

import android.app.Activity;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {
    Button button1;
    Button button2;
    Toast toast;
    ImageView imageView;
    LinearLayout toastImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_brightness_5_black_48dp));

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.button1:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_brightness_5_black_48dp));
                        setToastMethod("Выбрана картинка номер 1");
                        break;
                    case R.id.button2:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_brightness_6_black_48dp));
                        setToastMethod("Выбрана картинка номер 2");
                        break;
                    }

            }
        };



        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setToastMethod(String toastText){
        toast = Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_SHORT);
        LinearLayout toastImage1 = (LinearLayout) toast.getView();
        ImageView imageView1 = new ImageView(MainActivity.this);
        imageView1.setImageResource(R.drawable.logo);
        toastImage1.addView(imageView1, 0);
        toast.show();
    }
}
