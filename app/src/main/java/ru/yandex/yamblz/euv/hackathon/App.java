package ru.yandex.yamblz.euv.hackathon;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import ru.yandex.speechkit.SpeechKit;

public class App extends Application {
    private static Thread uiThread;
    private static Context context;
    private static Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();

        uiThread = Thread.currentThread();
        context = getApplicationContext();
        handler = new Handler(context.getMainLooper());

        SpeechKit.getInstance().configure(getApplicationContext(), "a9fe913d-fd64-4ab3-ae68-48d507785725");
    }


    public static Context getContext() {
        return context;
    }


    public static void runOnUiThread(Runnable action) {
        if (Thread.currentThread() == uiThread) {
            action.run();
        } else {
            handler.post(action);
        }
    }
}
