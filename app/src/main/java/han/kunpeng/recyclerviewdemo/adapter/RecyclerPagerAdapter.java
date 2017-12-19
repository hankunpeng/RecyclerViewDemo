package han.kunpeng.recyclerviewdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import han.kunpeng.recyclerviewdemo.fragment.RecyclerFragment;
import han.kunpeng.recyclerviewdemo.utility.RecyclerConstant;

/**
 * RecyclerPagerAdapter
 *
 * @author William Han
 * @date 2017/12/18
 */
public class RecyclerPagerAdapter extends FragmentStatePagerAdapter {
    public RecyclerPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // getItem is called to instantiate the fragment for the given page.
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = RecyclerFragment.newInstance();

        if (0 == (position % 2)) {
            fragment = RecyclerFragment.newInstance(RecyclerConstant.SCROLL_ORIENTATION_HORIZONTAL);
        } else {
            fragment = RecyclerFragment.newInstance(RecyclerConstant.SCROLL_ORIENTATION_VERTICAL);
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return RecyclerConstant.RECYCLER_FRAGMENT_COUNT;
    }
}
