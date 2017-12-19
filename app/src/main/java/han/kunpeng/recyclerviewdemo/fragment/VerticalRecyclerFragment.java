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

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import han.kunpeng.recyclerviewdemo.R;
import han.kunpeng.recyclerviewdemo.adapter.BasicRecyclerViewAdapter;
import han.kunpeng.recyclerviewdemo.utility.GlobalContext;
import timber.log.Timber;

import static han.kunpeng.recyclerviewdemo.utility.RecyclerConstant.SCROLL_ORIENTATION_VERTICAL;

/**
 * VerticalRecyclerFragment
 *
 * @author William Han
 * @date 2017/12/18
 */
public class VerticalRecyclerFragment extends BaseFragment {
    private List<String> dataset;
    @BindArray(R.array.countries) String[] countries;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    private Unbinder unbinder;
    private RecyclerView.LayoutManager layoutManager;
    private LinearLayoutManager linearLayoutManager;

    public static VerticalRecyclerFragment newInstance() {
        return new VerticalRecyclerFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Timber.d("[onCreate] BEGIN");
        super.onCreate(savedInstanceState);
//        initData();
        Timber.d("[onCreate] END");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Timber.d("[onCreateView]");
        View view = inflater.inflate(R.layout.fragment_recycler_vertical, container, false);
        unbinder = ButterKnife.bind(this, view);
        initRecyclerView(GlobalContext.getContext());
        return view;
    }

    @Override
    public void onDestroy() {
        Timber.d("[onDestroy] BEGIN");
        super.onDestroy();
        unbinder.unbind();
        Timber.d("[onDestroy] END");
    }

    private void initData() {
        dataset = new ArrayList<>();

/*
        for (int i = 1; i <= 32; i++) {
            mDataset.add("福利 " + i);
        }
*/

/*
        CSVParser csvParser = new CSVParser("CountryFlag.csv");
        for (String[] row : csvParser.parse()) {
            mDataset.add(row[2]);
        }
*/

        for (String country: countries) {
            dataset.add(country);
        }
    }

    private void initRecyclerView(Context context) {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);

        initData();
        recyclerView.setAdapter(new BasicRecyclerViewAdapter(dataset, SCROLL_ORIENTATION_VERTICAL));
    }
}
