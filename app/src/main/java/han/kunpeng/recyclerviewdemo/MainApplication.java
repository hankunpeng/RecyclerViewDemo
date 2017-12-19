package han.kunpeng.recyclerviewdemo;

import android.app.Application;

import han.kunpeng.recyclerviewdemo.utility.GlobalContext;
import han.kunpeng.recyclerviewdemo.utility.ThreadAwareDebugTree;
import timber.log.Timber;

/**
 * MainApplication
 *
 * @author William Han
 * @date 2017/12/12
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new ThreadAwareDebugTree());

        if (BuildConfig.DEBUG) {
            Timber.d("[onCreate] DEBUG true");
        } else {
            Timber.d("[onCreate] DEBUG false");
        }

        GlobalContext.setContext(this);
    }
}
