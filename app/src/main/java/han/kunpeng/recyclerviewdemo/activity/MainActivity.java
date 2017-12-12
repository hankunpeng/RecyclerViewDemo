package han.kunpeng.recyclerviewdemo.activity;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import han.kunpeng.recyclerviewdemo.R;
import timber.log.Timber;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.d("[onCreate] BEGIN");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Timber.d("[onCreate] END");
    }

    @OnClick(R.id.button_recycler_view_basic)
    public void openRecyclerViewActivity() {
        Timber.d("[openRecyclerViewActivity] BEGIN");
        openActivity(RecyclerViewActivity.class);
        Timber.d("[openRecyclerViewActivity] END");
    }

    public void openActivity(Class<?> cls) {
        Intent intent = new Intent(getApplicationContext(), cls);
        startActivity(intent);
    }
}
