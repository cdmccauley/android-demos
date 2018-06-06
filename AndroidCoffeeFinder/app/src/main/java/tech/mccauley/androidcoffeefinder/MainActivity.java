package tech.mccauley.androidcoffeefinder;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Resources mResources;

    private CoffeeShop[] coffeeShops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResources = this.getResources();

        coffeeShops = new CoffeeShop[] {
                new CoffeeShop("Battlegrounds", mResources.getDrawable(R.drawable.battlegrounds), new Intent(MainActivity.this, Battlegrounds.class), this),
                new CoffeeShop("Sips", mResources.getDrawable(R.drawable.sips), new Intent(MainActivity.this, Sips.class), this),
                new CoffeeShop("Starbucks", mResources.getDrawable(R.drawable.starbucks), new Intent(MainActivity.this, Starbucks.class), this),
                new CoffeeShop("Beans & Brews", mResources.getDrawable(R.drawable.beansandbrews), new Intent(MainActivity.this, BeansAndBrews.class), this)
        };

        mRecyclerView = findViewById(R.id.coffee_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CoffeeAdapter(coffeeShops);
        mRecyclerView.setAdapter(mAdapter);

    }
}
