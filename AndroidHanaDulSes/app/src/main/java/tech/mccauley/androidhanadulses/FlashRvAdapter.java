package tech.mccauley.androidhanadulses;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FlashRvAdapter extends RecyclerView.Adapter {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView rvItemText = (TextView)LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rv_item, parent, false);
        return new ViewHolder(rvItemText);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3; // HARDCODED NUMBER OF RV ITEMS !!!!!!
    }
}
