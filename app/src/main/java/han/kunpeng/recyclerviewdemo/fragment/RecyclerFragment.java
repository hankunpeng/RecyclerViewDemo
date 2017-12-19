package han.kunpeng.recyclerviewdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import han.kunpeng.recyclerviewdemo.R;
import han.kunpeng.recyclerviewdemo.adapter.RecyclerViewAdapter;
import han.kunpeng.recyclerviewdemo.fragment.dummy.DummyContent;
import han.kunpeng.recyclerviewdemo.fragment.dummy.DummyContent.DummyItem;
import han.kunpeng.recyclerviewdemo.utility.RecyclerConstant;

/**
 * RecyclerFragment
 *
 * @author William Han
 * @date 2017/12/18
 */
public class RecyclerFragment extends Fragment {

    // Customize parameter argument names
    private static final String ARG_ORIENTATION = "orientation";
    // Customize parameters
    private int scrollOrientation = RecyclerConstant.SCROLL_ORIENTATION_VERTICAL;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecyclerFragment() {
    }

    @SuppressWarnings("unused")
    public static RecyclerFragment newInstance() {
        return RecyclerFragment.newInstance(RecyclerConstant.SCROLL_ORIENTATION_VERTICAL);
    }

    @SuppressWarnings("unused")
    public static RecyclerFragment newInstance(int orientation) {
        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ORIENTATION, orientation);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            scrollOrientation = getArguments().getInt(ARG_ORIENTATION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context, scrollOrientation, false));
            recyclerView.setAdapter(new RecyclerViewAdapter(DummyContent.ITEMS));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
