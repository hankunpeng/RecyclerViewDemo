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

public class MultipleRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private List<String> mDataset;
    private Context mContext;

    public static enum VIEW_TYPE {
        ORIENTATION_VERTICAL,
        ORIENTATION_HORIZONTAL
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MultipleRecyclerViewAdapter(List<String> dataset) {
        mDataset = dataset;
    }

    public MultipleRecyclerViewAdapter(List<String> dataset, Context context) {
        mDataset = dataset;
        mContext = context;
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

    public static class VerticalViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public VerticalViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view_info);
        }
    }

    public static class HorizontalViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view_info);
        }
    }


    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;

        // create a new view
        if (VIEW_TYPE.ORIENTATION_HORIZONTAL.ordinal() == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
            viewHolder = new HorizontalViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false);
            viewHolder = new VerticalViewHolder(view);
        }

        // set the view's size, margins, paddings and layout parameters
        //...

        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if (holder instanceof VerticalViewHolder) {
            ((VerticalViewHolder) holder).textView.setText(mDataset.get(position));
        } else if (holder instanceof HorizontalViewHolder) {
            ((HorizontalViewHolder) holder).textView.setText(mDataset.get(position));
        } else {
            Log.d("Bug", "onBindViewHolder - holder instanceof");
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size() / 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? VIEW_TYPE.ORIENTATION_VERTICAL.ordinal() : VIEW_TYPE.ORIENTATION_HORIZONTAL.ordinal();
    }

}
