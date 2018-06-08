package tech.mccauley.androidtechgadgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRecycler;
    private RecyclerView.Adapter mainRecyclerAdapter;
    private RecyclerView.LayoutManager mainRecyclerLayoutManager;

    private TechGadgetManager techGadgetManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get recyclerview
        mainRecycler = findViewById(R.id.main_recycler_view);

        // set layoutmanager
        mainRecyclerLayoutManager = new LinearLayoutManager(this);
        mainRecycler.setLayoutManager(mainRecyclerLayoutManager);

        // get techgadgetmanager
        techGadgetManager = new TechGadgetManager(this);

        // set adapter
        mainRecyclerAdapter = new MainRecyclerAdapter(techGadgetManager);
        mainRecycler.setAdapter(mainRecyclerAdapter);

    }
}
