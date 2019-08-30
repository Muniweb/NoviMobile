package innoac.demo.com.innoacdemo.receiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.estimotelib.EstimoNotificationsManager;

public class ActionButtonReceiver extends BroadcastReceiver {
    EstimoNotificationsManager mNm;

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equalsIgnoreCase("YES_MUTE"))
        {
            //For cancel the notification on click of mute action button
            int noti_id = intent.getIntExtra("notification_id", 0);
            String url = intent.getStringExtra("url");

            mNm = new EstimoNotificationsManager(context);
            mNm.storeMutedUrl(url);

            NotificationManager notificationManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.cancel(noti_id);
        }
    }
}
