package fast.cleaner.battery.saver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import fast.cleaner.battery.saver.Classes.power_item;

import com.andromob.masterclean.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by intag pc on 2/19/2017.
 */

public class Ultra_PopUp extends Activity{

    RecyclerView recyclerView;
    PowerAdapter mAdapter;
    List<power_item> items;
    ImageView applied;
    TextView extendedtime,extendedtimedetail;
    int hour;
    int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b=getIntent().getExtras();
        setContentView(R.layout.ultra_popup);
        applied =(ImageView) findViewById(R.id.applied);
        extendedtime=(TextView) findViewById(R.id.addedtime);
        extendedtimedetail=(TextView) findViewById(R.id.addedtimedetail);


        try {

            hour = Integer.parseInt(b.getString("hour").replaceAll("[^0-9]", "")) - Integer.parseInt(b.getString("hournormal").replaceAll("[^0-9]", ""));
            min = Integer.parseInt(b.getString("minutes").replaceAll("[^0-9]", "")) - Integer.parseInt(b.getString("minutesnormal").replaceAll("[^0-9]", ""));
        }
        catch(Exception e)
        {
            hour=4;
            min=7;
        }

        if(hour==0 && min==0)
        {
            hour=4;
            min=7;
        }

        extendedtime.setText("(+"+hour+" h " +Math.abs(min)+" m)");
        extendedtimedetail.setText("Extended Battery Up to "+Math.abs(hour)+"h "+Math.abs(min)+"m");

        applied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Ultra_PopUp.this,Applying_Ultra.class);
                startActivity(i);
//                if (Build.VERSION.SDK_INT >= 21) {
//                    getWindow().setNavigationBarColor(Color.parseColor("#000000"));
//                    getWindow().setStatusBarColor(Color.parseColor("#000000"));
//                }

                finish();

            }
        });

        items =new ArrayList<>();

        recyclerView =(RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setItemAnimator(new SlideInLeftAnimator());
//                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
//                recyclerView.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));

        recyclerView.getItemAnimator().setAddDuration(200);

        mAdapter = new PowerAdapter(items);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));
        recyclerView.computeHorizontalScrollExtent();
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                add("Limit Brightness Upto 90%", 0);


            }
        }, 1000);

        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                add("Decrease Device Performance", 1);


            }
        }, 2000);

        final Handler handler3 = new Handler();
        handler3.postDelayed(new Runnable() {
            @Override
            public void run() {
                add("Close All Battery Consuming Apps", 2);


            }
        }, 3000);

        final Handler handler4 = new Handler();
        handler4.postDelayed(new Runnable() {
            @Override
            public void run() {
                add("Use Black and White Scheme To Avoid Battery Draning", 3);
            }
        }, 4000);



        final Handler handler5 = new Handler();
        handler5.postDelayed(new Runnable() {
            @Override
            public void run() {
                add("Block Acess to Memory and Battery Draning Apps", 4);

            }
        }, 5000);

        final Handler handler6 = new Handler();
        handler6.postDelayed(new Runnable() {
            @Override
            public void run() {
                add("Closes System Services like Bluetooth,Screen Rotation,Sync etc.", 5);

            }
        }, 6000);

//        final Handler handler6 = new Handler();
//        handler4.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                add("Use Black and White Scheme To Avoid Battery Draning", 3);
//            }
//        }, 4000);



    }

    public void add(String text, int position) {
        power_item item=new power_item();
        item.setText(text);
        items.add(item);
//        mDataSet.add(position, text);
        mAdapter.notifyItemInserted(position);

    }

//    if(position==4)
//    {
//        mAdapter.notifyItemMoved(4,0);
//    }
//    else  if(position==5)
//    {
//        mAdapter.notifyItemMoved(5,0);
//    }

//    @Override
//    public void onBackPressed() {
////        super.onBackPressed();
//    }

}
