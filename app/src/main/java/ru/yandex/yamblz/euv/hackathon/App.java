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

        // Так делать нельзя. По идее все, что не специфицировано доками, нельзя использовать.
        // И помните, что реализация фреймворка на девайсах может отличаться, так что не ровен час
        // приложения откажется запускаться на каком-нибудь xiaomi.
        uiThread = Thread.currentThread();
        context = getApplicationContext();
        handler = new Handler(context.getMainLooper());

        SpeechKit.getInstance().configure(getApplicationContext(), "a9fe913d-fd64-4ab3-ae68-48d507785725");
    }


    public static Context getContext() {
        return context;
    }


    public static void runOnUiThread(Runnable action) {
        // context.getMainLooper().isCurrentThread()
        if (Thread.currentThread() == uiThread) {
            action.run();
        } else {
            handler.post(action);
        }
    }
}
