package han.kunpeng.recyclerviewdemo.activity;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import han.kunpeng.recyclerviewdemo.R;
import timber.log.Timber;

/**
 * MainActivity
 *
 * @author William Han
 * @date 2017/12/12
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.d("[onCreate] BEGIN");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Timber.d("[onCreate] END");
    }

    @OnClick(R.id.button_fragment_recycler_basic)
    public void openRecyclerViewActivity() {
        Timber.d("[openRecyclerViewActivity] BEGIN");
        openActivity(RecyclerActivity.class);
        Timber.d("[openRecyclerViewActivity] END");
    }

    public void openActivity(Class<?> cls) {
        Intent intent = new Intent(getApplicationContext(), cls);
        startActivity(intent);
    }
}
