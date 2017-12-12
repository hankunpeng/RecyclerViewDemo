package han.kunpeng.recyclerviewdemo.activity;

import android.os.Bundle;

import han.kunpeng.recyclerviewdemo.R;
import han.kunpeng.recyclerviewdemo.fragment.BasicRecyclerFragment;
import timber.log.Timber;

/**
 * BasicRecyclerActivity
 *
 * @author William Han
 * @date 2017/12/12
 */
public class BasicRecyclerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.d("[onCreate] BEGIN");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        BasicRecyclerFragment basicRecyclerFragment = BasicRecyclerFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, basicRecyclerFragment, "basicRecyclerFragment")
                .commit();
        Timber.d("[onCreate] END");
    }
}
