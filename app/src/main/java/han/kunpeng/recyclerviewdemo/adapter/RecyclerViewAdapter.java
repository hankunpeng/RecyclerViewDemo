package han.kunpeng.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import han.kunpeng.recyclerviewdemo.R;
import han.kunpeng.recyclerviewdemo.fragment.dummy.DummyContent;
import timber.log.Timber;

/**
 * RecyclerViewAdapter
 *
 * @author William Han
 * @date 2017/12/12
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {
//    private List<String> mDataset;
    private final List<DummyContent.DummyItem> mDataset;
    private Context mContext;

    // Provide a suitable constructor (depends on the kind of dataset)
//    public RecyclerViewAdapter(List<String> dataset) {
    public RecyclerViewAdapter(List<DummyContent.DummyItem> items) {
        mDataset = items;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public DummyContent.DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recycler_item, parent, false);

        // set the view's size, margins, paddings and layout parameters
        //...

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if (holder instanceof ViewHolder) {
            holder.mItem = mDataset.get(position);
            holder.mIdView.setText(mDataset.get(position).id);
            holder.mContentView.setText(mDataset.get(position).content);
        } else {
            Timber.d("[onBindViewHolder] holder instanceof");
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
