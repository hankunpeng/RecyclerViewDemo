package han.kunpeng.recyclerviewdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import han.kunpeng.recyclerviewdemo.R;
import han.kunpeng.recyclerviewdemo.adapter.BasicRecyclerViewAdapter;
import han.kunpeng.recyclerviewdemo.config.GlobalContext;
import timber.log.Timber;

import static han.kunpeng.recyclerviewdemo.config.RecyclerViewConstant.VIEW_TYPE_ORIENTATION_HORIZONTAL;
import static han.kunpeng.recyclerviewdemo.config.RecyclerViewConstant.VIEW_TYPE_ORIENTATION_VERTICAL;

/**
 * BasicRecyclerFragment
 *
 * @author William Han
 * @date 2017/12/12
 */
public class BasicRecyclerFragment extends BaseFragment {
    private List<String> mDataset;
    private RecyclerView mRecyclerViewVertical;
    private RecyclerView mRecyclerViewHorizontal;
    private RecyclerView.Adapter mRecyclerViewAdapter;
    private RecyclerView.LayoutManager mRecyclerViewLayoutManagerVertical;
    private RecyclerView.LayoutManager mRecyclerViewLayoutManagerHorizontal;
    private LinearLayoutManager mLinearLayoutManagerVertical;
    private LinearLayoutManager mLinearLayoutManagerHorizontal;

    public static BasicRecyclerFragment newInstance() {
        return new BasicRecyclerFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Timber.d("[onCreate] BEGIN");
        super.onCreate(savedInstanceState);
        initData();
        Timber.d("[onCreate] END");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Timber.d("[onCreateView]");
        View view = inflater.inflate(R.layout.fragment_recycler_basic, container, false);
        findView(view);
        initRecyclerView(GlobalContext.getContext());
        return view;
    }

    private void initData() {
        mDataset = new ArrayList<>();
        for (int i = 1; i <= 32; i++) {
            mDataset.add("福利 " + i);
        }
    }

    private void findView(View view) {
        mRecyclerViewVertical = (RecyclerView) view.findViewById(R.id.recycler_view_vertical);
        mRecyclerViewHorizontal = (RecyclerView) view.findViewById(R.id.recycler_view_horizontal);
    }

    private void initRecyclerView(Context context) {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewVertical.setHasFixedSize(true);
        mRecyclerViewHorizontal.setHasFixedSize(true);

        // use a linear layout manager - VERTICAL
        mLinearLayoutManagerVertical = new LinearLayoutManager(context);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewLayoutManagerVertical = mLinearLayoutManagerVertical;
        mRecyclerViewVertical.setLayoutManager(mRecyclerViewLayoutManagerVertical);

        // use a linear layout manager - HORIZONTAL
        mLinearLayoutManagerHorizontal = new LinearLayoutManager(context);
        mLinearLayoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewLayoutManagerHorizontal = mLinearLayoutManagerHorizontal;
        mRecyclerViewHorizontal.setLayoutManager(mRecyclerViewLayoutManagerHorizontal);

        // specify an adapter (see also next example)
        mRecyclerViewVertical.setAdapter(new BasicRecyclerViewAdapter(mDataset, VIEW_TYPE_ORIENTATION_VERTICAL));
        mRecyclerViewHorizontal.setAdapter(new BasicRecyclerViewAdapter(mDataset, VIEW_TYPE_ORIENTATION_HORIZONTAL));
    }
}