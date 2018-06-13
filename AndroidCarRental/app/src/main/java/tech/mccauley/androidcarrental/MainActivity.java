package tech.mccauley.androidcarrental;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // declarations
    private RecyclerView mainRv;
    private RecyclerView.Adapter mainRvAdapter;
    private RecyclerView.LayoutManager mainRvLayoutManager;
    private RentalCar[] rentalCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set recyclerview
        mainRv = findViewById(R.id.main_rv);

        // set layoutmanager
        mainRvLayoutManager = new GridLayoutManager(this, 3);
        mainRv.setLayoutManager(mainRvLayoutManager);

        // set rentalcars
        rentalCars = new RentalCar[] {
                new RentalCar(R.drawable.economy, "Economy", 54.99),
                new RentalCar(R.drawable.compact, "Compact", 56.99),
                new RentalCar(R.drawable.intermediate, "Intermediate", 58.99),
                new RentalCar(R.drawable.standard, "Standard", 60.99),
                new RentalCar(R.drawable.fullsize, "Full Size", 62.99),
                new RentalCar(R.drawable.premium, "Premium", 92.99)
        };

        // set adapter
        mainRvAdapter = new RecyclerViewAdapter(this, rentalCars, (ImageView)findViewById(R.id.main_iv));
        mainRv.setAdapter(mainRvAdapter);
    }
}
