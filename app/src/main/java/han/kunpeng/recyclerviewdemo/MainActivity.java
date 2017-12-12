package han.kunpeng.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import han.kunpeng.recyclerviewdemo.adapter.BasicRecyclerViewAdapter;

import static han.kunpeng.recyclerviewdemo.RecyclerViewConstant.VIEW_TYPE_ORIENTATION_HORIZONTAL;
import static han.kunpeng.recyclerviewdemo.RecyclerViewConstant.VIEW_TYPE_ORIENTATION_VERTICAL;

public class MainActivity extends Activity {
    private List<String> mDataset;
    private RecyclerView mRecyclerViewVertical;
    private RecyclerView mRecyclerViewHorizontal;
    private RecyclerView.Adapter mRecyclerViewAdapter;
    private RecyclerView.LayoutManager mRecyclerViewLayoutManagerVertical;
    private RecyclerView.LayoutManager mRecyclerViewLayoutManagerHorizontal;
    private LinearLayoutManager mLinearLayoutManagerVertical;
    private LinearLayoutManager mLinearLayoutManagerHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        findView();
//        initRefreshLayout();
        initRecyclerView();


    }

    private void initData() {
        mDataset = new ArrayList<>();
        for (int i = 1; i <= 32; i++) {
            mDataset.add("福利 " + i);
        }
    }

    private void findView() {
//        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        mRecyclerViewVertical = (RecyclerView) findViewById(R.id.recycler_view_vertical);
        mRecyclerViewHorizontal = (RecyclerView) findViewById(R.id.recycler_view_horizontal);
    }

/*
    private void initRefreshLayout() {
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light,
                android.R.color.holo_orange_light, android.R.color.holo_green_light);
        refreshLayout.setOnRefreshListener(this);
    }
*/

    private void initRecyclerView() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerViewVertical.setHasFixedSize(true);
        mRecyclerViewHorizontal.setHasFixedSize(true);

        // use a linear layout manager - VERTICAL
        mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewLayoutManagerVertical = mLinearLayoutManagerVertical;
        mRecyclerViewVertical.setLayoutManager(mRecyclerViewLayoutManagerVertical);

        // use a linear layout manager - HORIZONTAL
        mLinearLayoutManagerHorizontal = new LinearLayoutManager(this);
        mLinearLayoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewLayoutManagerHorizontal = mLinearLayoutManagerHorizontal;
        mRecyclerViewHorizontal.setLayoutManager(mRecyclerViewLayoutManagerHorizontal);

        // specify an adapter (see also next example)
//        mRecyclerViewAdapter = new RecyclerViewAdapter(mDataset);
        mRecyclerViewVertical.setAdapter(new BasicRecyclerViewAdapter(mDataset, VIEW_TYPE_ORIENTATION_VERTICAL));
        mRecyclerViewHorizontal.setAdapter(new BasicRecyclerViewAdapter(mDataset, VIEW_TYPE_ORIENTATION_HORIZONTAL));
    }
}
