package tech.mccauley.androidcoffeefinder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.ViewHolder> {
    private CoffeeShop[] mDataSet; // PLACEHOLDING !!

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout mConstraintLayout;
        public ViewHolder(ConstraintLayout v) {
            super(v);
            mConstraintLayout = v;
        }
    }

    public CoffeeAdapter(CoffeeShop[] coffeeDataSet) {
        mDataSet = coffeeDataSet;
    }

    @Override
    public CoffeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        ConstraintLayout cl = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_constraint_layout, parent, false);

        ViewHolder vh = new ViewHolder(cl);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ImageView shopIcon = (ImageView)holder.mConstraintLayout.getChildAt(0);
        shopIcon.setImageDrawable(mDataSet[position].getShopIcon());

        TextView shopName = (TextView)holder.mConstraintLayout.getChildAt(1);
        shopName.setText(mDataSet[position].getShopName());

        Button viewBtn = (Button)holder.mConstraintLayout.getChildAt(2);
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context contextPointer = mDataSet[position].getContextPointer();
                contextPointer.startActivity(mDataSet[position].getShopIntent());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
