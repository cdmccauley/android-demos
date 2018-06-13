package tech.mccauley.androidweddingphotography;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    // declarations
    private RecyclerView mainRv;
    private RecyclerView.LayoutManager mainRvLayoutManger;
    private RecyclerView.Adapter mainRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainRv = findViewById(R.id.main_rv);

        mainRvLayoutManger = new GridLayoutManager(this, 2);
        mainRv.setLayoutManager(mainRvLayoutManger);

        mainRvAdapter = new MainRvAdapter(this, new PhotoManager(), (ImageView)findViewById(R.id.main_iv), (ScrollView)findViewById(R.id.main_sv));
        mainRv.setAdapter(mainRvAdapter);
    }
}
