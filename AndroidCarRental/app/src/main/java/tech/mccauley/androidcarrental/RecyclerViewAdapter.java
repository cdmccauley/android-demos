package tech.mccauley.androidcarrental;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    // viewholder definition
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mCar;

        public ViewHolder(View itemView) {
            super(itemView);
            mCar = itemView.findViewById(R.id.car_iv);
        }
    }

    // declarations
    private Context mainContext;
    private RentalCar[] rentalCars;
    private ImageView mainIv;
    private Toast infoToast;

    // constructor
    public RecyclerViewAdapter(Context mainContext, RentalCar[] rentalCars, ImageView mainIv) {
        this.mainContext = mainContext;
        this.rentalCars = rentalCars;
        this.mainIv = mainIv;
        infoToast = Toast.makeText(mainContext, "", Toast.LENGTH_SHORT);
    }

    // adapter implementation
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // build view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapter.ViewHolder holder, final int position) {
        // set image
        holder.mCar.setImageResource(rentalCars[position].getCarImage());
        // set click event handler
        holder.mCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainIv.setImageResource(rentalCars[position].getCarImage());
                infoToast.setText("The " + rentalCars[position].getCarName() + " will cost $" + rentalCars[position].getCarPrice() + " per day.");
                infoToast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rentalCars.length;
    }
}
