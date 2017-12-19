package han.kunpeng.recyclerviewdemo.utility;

import android.content.Context;

/**
 * GlobalContext
 *
 * @author William Han
 * @date 2017/12/12
 */
public class GlobalContext {
    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context context) {
        sContext = context;
    }
}
