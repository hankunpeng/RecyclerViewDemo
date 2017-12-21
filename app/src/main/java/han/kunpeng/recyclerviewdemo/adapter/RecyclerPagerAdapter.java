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

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        switch (position) {
            case 0:
                title = "音乐";
                break;
            case 1:
                title = "导航";
                break;
            case 2:
                title = "电话";
                break;
            default:
                title = "Title";
                break;
        }
        return title;
    }
}
