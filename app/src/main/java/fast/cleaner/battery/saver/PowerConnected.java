package fast.cleaner.battery.saver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by intag pc on 3/14/2017.
 */

public class PowerConnected extends BroadcastReceiver{

    // bROAD CAST THAT lISTEN fOR charger Connected Events

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i=new Intent(context,MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
