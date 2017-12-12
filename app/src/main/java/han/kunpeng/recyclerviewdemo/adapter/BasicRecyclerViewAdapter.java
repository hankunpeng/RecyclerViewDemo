package han.kunpeng.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import han.kunpeng.recyclerviewdemo.R;

import static han.kunpeng.recyclerviewdemo.RecyclerViewConstant.VIEW_TYPE_ORIENTATION_HORIZONTAL;
import static han.kunpeng.recyclerviewdemo.RecyclerViewConstant.VIEW_TYPE_ORIENTATION_VERTICAL;

public class BasicRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private List<String> mDataset;
    private Context mContext;
    private int mOrientation;

    // Provide a suitable constructor (depends on the kind of dataset)
    public BasicRecyclerViewAdapter(List<String> dataset) {
        mDataset = dataset;
    }

    public BasicRecyclerViewAdapter(List<String> dataset, int orientation) {
        mDataset = dataset;
        mOrientation = orientation;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class BasicViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView textView;

        public BasicViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view_info);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        // create a new view
        if (VIEW_TYPE_ORIENTATION_VERTICAL == mOrientation) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false);
        } else if (VIEW_TYPE_ORIENTATION_HORIZONTAL == mOrientation) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        }

        // set the view's size, margins, paddings and layout parameters
        //...

        return new BasicViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if (holder instanceof BasicViewHolder) {
            ((BasicViewHolder) holder).textView.setText(mDataset.get(position));
        } else {
            Log.d("HHHH", "onBindViewHolder - holder instanceof");
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
