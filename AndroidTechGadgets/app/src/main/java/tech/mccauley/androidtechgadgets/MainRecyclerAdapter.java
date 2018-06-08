package tech.mccauley.androidtechgadgets;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    // declarations
    TechGadgetManager gadgetManager;

    // recyclerview implementation
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout mainRecyclerRow;
        public ViewHolder(ConstraintLayout c) {
            super(c);
            mainRecyclerRow = c;
        }
    }

    public MainRecyclerAdapter(TechGadgetManager manager) {
        this.gadgetManager = manager;
    }

    @Override
    public MainRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        ConstraintLayout c = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler_row, parent, false);
        ViewHolder v = new ViewHolder(c);
        return v;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        // set row event listener
        holder.mainRecyclerRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // set intent
                Intent rowIntent = new Intent(gadgetManager.getMainContext(), DetailActivity.class);

                // add techgadget to intent
                rowIntent.putExtra("techGadget", gadgetManager.getManagerGadgets()[position]);

                // open detailactivity
                gadgetManager.getMainContext().startActivity(rowIntent);

            }
        });

        // set row title
        TextView gadgetTitle = (TextView) holder.mainRecyclerRow.getChildAt(0);
        gadgetTitle.setText(gadgetManager.getManagerGadgets()[position].getGadgetName());
    }

    @Override
    public int getItemCount() {
        return gadgetManager.getManagerGadgets().length;
    }
}
