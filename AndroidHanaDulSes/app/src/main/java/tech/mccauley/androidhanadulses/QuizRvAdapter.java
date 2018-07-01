package tech.mccauley.androidhanadulses;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QuizRvAdapter extends RecyclerView.Adapter {

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

        String itemTitle = LanguageManager.getInstance().getCategoryNames().get(position);
        TextView rvItemTv = holder.itemView.findViewById(R.id.rv_item_tv);
        rvItemTv.setText(itemTitle.substring(0, 1).toUpperCase() + itemTitle.substring(1));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), QuizActivity.class);
                // put title name for data extraction
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return LanguageManager.getInstance().getCategoryNames().size();
    }
}
