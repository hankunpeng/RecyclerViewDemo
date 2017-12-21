package han.kunpeng.recyclerviewdemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TableLayout;

import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import han.kunpeng.recyclerviewdemo.R;
import han.kunpeng.recyclerviewdemo.adapter.RecyclerPagerAdapter;
import han.kunpeng.recyclerviewdemo.fragment.RecyclerFragment;
import han.kunpeng.recyclerviewdemo.fragment.dummy.DummyContent;
import han.kunpeng.recyclerviewdemo.utility.RecyclerConstant;
import timber.log.Timber;

/**
 * RecyclerActivity
 *
 * @author William Han
 * @date 2017/12/12
 */
public class RecyclerActivity extends BaseActivity implements RecyclerFragment.OnListFragmentInteractionListener {
    private Unbinder unbinder;
    @BindView(R.id.view_pager) ViewPager viewPager;
    @BindView(R.id.view_pager_indicator) CirclePageIndicator viewPagerIndicator;
    @BindView(R.id.tab_layout) TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.d("[onCreate] BEGIN");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        unbinder = ButterKnife.bind(this);
        viewPager.setAdapter(new RecyclerPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(RecyclerConstant.RECYCLER_FRAGMENT_COUNT);
        viewPagerIndicator.setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        Timber.d("[onCreate] END");
    }

    @Override
    protected void onDestroy() {
        Timber.d("[onDestroy] BEGIN");
        super.onDestroy();
        unbinder.unbind();
        Timber.d("[onDestroy] END");
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        // todo
    }


}
