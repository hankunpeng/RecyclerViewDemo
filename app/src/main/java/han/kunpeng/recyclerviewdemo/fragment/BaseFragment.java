package han.kunpeng.recyclerviewdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import han.kunpeng.recyclerviewdemo.R;
import timber.log.Timber;

/**
 * BaseFragment
 *
 * @author William Han
 * @date 2017/12/12
 */
public class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        Timber.d("[onAttach] BEGIN");
        super.onAttach(context);
        Timber.d("[onAttach] END");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Timber.d("[onCreate] BEGIN");
        super.onCreate(savedInstanceState);
        Timber.d("[onCreate] END");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Timber.d("[onViewCreated] BEGIN");
        super.onViewCreated(view, savedInstanceState);
        Timber.d("[onViewCreated] END");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Timber.d("[onActivityCreated] BEGIN");
        super.onActivityCreated(savedInstanceState);
        Timber.d("[onActivityCreated] END");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Timber.d("[onCreateView]");
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        return view;
    }

    @Override
    public void onStart() {
        Timber.d("[onStart] BEGIN");
        super.onStart();
        Timber.d("[onStart] END");
    }

    @Override
    public void onResume() {
        Timber.d("[onResume] BEGIN");
        super.onResume();
        Timber.d("[onResume] END");
    }

    @Override
    public void onPause() {
        Timber.d("[onPause] BEGIN");
        super.onPause();
        Timber.d("[onPause] END");
    }

    @Override
    public void onStop() {
        Timber.d("[onStop] BEGIN");
        super.onStop();
        Timber.d("[onStop] END");
    }

    @Override
    public void onDestroyView() {
        Timber.d("[onDestroyView] BEGIN");
        super.onDestroyView();
        Timber.d("[onDestroyView] END");
    }

    @Override
    public void onDestroy() {
        Timber.d("[onDestroy] BEGIN");
        super.onDestroy();
        Timber.d("[onDestroy] END");
    }

    @Override
    public void onDetach() {
        Timber.d("[onDetach] BEGIN");
        super.onDetach();
        Timber.d("[onDetach] END");
    }

    public static BaseFragment newInstance() {
        return new BaseFragment();
    }
}
