package fast.cleaner.battery.saver;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.andromob.masterclean.R;

public class Splachscreen extends AppCompatActivity  {
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splachscreen);
        getSupportActionBar().hide();
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splachscreen.this,MainActivity.class);
                Splachscreen.this.startActivity(mainIntent);
                Splachscreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);


    }


}
