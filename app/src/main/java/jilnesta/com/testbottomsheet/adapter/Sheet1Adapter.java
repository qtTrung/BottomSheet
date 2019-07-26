package jilnesta.com.testbottomsheet.adapter;

//public class Sheet1Adapter extends RecyclerView.Adapter<Sheet1Adapter.ItemViewHolder> {
//
//    private static final String TAG = Sheet1Adapter.class.getSimpleName();
//
//    List<String> stringList;
//    Context context;
//
//    public Sheet1Adapter(Context context) {
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(context).inflate(R.layout.list_item_horizontal, viewGroup, false);
//        return new ItemViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
//        itemViewHolder.tvText.setText(stringList.get(i));
//    }
//
//    @Override
//    public int getItemCount() {
//        return stringList.size();
//    }
//
//    public class ItemViewHolder extends RecyclerView.ViewHolder {
//        TextView tvText;
//
//        public ItemViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tvText = itemView.findViewById(R.id.tv_text);
//        }
//
//    }
//
//    public synchronized void setItems(final List<String> items) {
//        if (stringList == items) {
//            return;
//        }
//
//        new DiffResultTask(this.stringList, items, new DiffResultTask.Action0<DiffUtil.DiffResult>() {
//            @Override
//            public void call(DiffUtil.DiffResult diffResult) {
//
//                stringList = items;
//                diffResult.dispatchUpdatesTo(Sheet1Adapter.this);
//
//                if (BuildConfig.DEBUG)
//                    diffResult.dispatchUpdatesTo(new ListUpdateCallback() {
//                        @Override
//                        public void onInserted(int position, int count) {
//                            Log.i(TAG, String.format("onInserted: position: %d, count: %d", position, count));
//                        }
//
//                        @Override
//                        public void onRemoved(int position, int count) {
//                            Log.i(TAG, String.format("onRemoved:position: %d, count: %d", position, count));
//                        }
//
//                        @Override
//                        public void onMoved(int fromPosition, int toPosition) {
//                            Log.i(TAG, String.format("onMoved: from: %d, to: %d", fromPosition, fromPosition));
//                        }
//
//                        @Override
//                        public void onChanged(int position, int count, Object payload) {
//                            Log.i(TAG, String.format("onChanged: position: %d, count: %d", position, count));
//                        }
//                    });
//            }
//        }).execute();
//    }
//
//    private static class DiffCallback extends DiffUtil.Callback {
//
//        private List<String> oldList;
//        private List<String> newList;
//
//        DiffCallback(List<String> oldList, List<String> newList) {
//            this.oldList = oldList;
//            this.newList = newList;
//        }
//
//        @Override
//        public int getOldListSize() {
//            return oldList != null ? oldList.size() : 0;
//        }
//
//        @Override
//        public int getNewListSize() {
//            return newList != null ? newList.size() : 0;
//        }
//
//        Object getOldItem(int oldItemPosition) {
//            return oldList.get(oldItemPosition);
//        }
//
//        Object getNewItem(int newItemPosition) {
//            return newList.get(newItemPosition);
//        }
//
//        @Override
//        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
//
//            Object oldItem = getOldItem(oldItemPosition);
//            Object newItem = getNewItem(newItemPosition);
//
//            return !(oldItem == null || newItem == null) && oldItem.equals(newItem);
//        }
//
//        @Override
//        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
//
//            Object oldItem = getOldItem(oldItemPosition);
//            Object newItem = getNewItem(newItemPosition);
//
//            if (oldItem instanceof ContentsComparator) {
//                return ((ContentsComparator) oldItem).areContentsEqual(newItem);
//            } else {
//                return areItemsTheSame(oldItemPosition, newItemPosition);
//            }
//        }
//
//        @Nullable
//        @Override
//        public Object getChangePayload(int oldItemPosition, int newItemPosition) {
//            return 0;
//        }
//    }
//
//    static class DiffResultTask extends AsyncTask<Void, Void, DiffUtil.DiffResult> {
//
//        interface Action0<R> {
//            void call(R result);
//        }
//
//        List<String> oldItems;
//        List<String> newItems;
//
//        WeakReference<Sheet1Adapter.DiffResultTask.Action0<DiffUtil.DiffResult>> callBackReference;
//
//        DiffResultTask(List<String> oldItems, List<String> newItems, Sheet1Adapter.DiffResultTask.Action0<DiffUtil.DiffResult> callBack) {
//            this.oldItems = oldItems;
//            this.newItems = newItems;
//            this.callBackReference = new WeakReference<>(callBack);
//        }
//
//        @Override
//        protected DiffUtil.DiffResult doInBackground(Void... voids) {
//            return DiffUtil.calculateDiff(new Sheet1Adapter.DiffCallback(oldItems, newItems));
//        }
//
//        @Override
//        protected void onPostExecute(DiffUtil.DiffResult diffResult) {
//            super.onPostExecute(diffResult);
//
//            Sheet1Adapter.DiffResultTask.Action0<DiffUtil.DiffResult> callback = callBackReference.get();
//            if (callback != null) {
//                callback.call(diffResult);
//            }
//        }
//    }
//}

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jilnesta.com.testbottomsheet.R;

public class Sheet1Adapter extends ListAdapter<String, Sheet1Adapter.ItemViewHolder> {

    private static final String TAG = Sheet1Adapter.class.getSimpleName();

    public Sheet1Adapter(@NonNull Sheet1DiffCallback diffCallback) {
        super(diffCallback);
    }

    public static class Sheet1DiffCallback extends DiffUtil.ItemCallback<String> {

        @Override
        public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return oldItem.equals(newItem);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_horizontal, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.bind(getItem(i));
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_text);
        }

        public void bind(String string){
            tvText.setText(string);
        }
    }

}
