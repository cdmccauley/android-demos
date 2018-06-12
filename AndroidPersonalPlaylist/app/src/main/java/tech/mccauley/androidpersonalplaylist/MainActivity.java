package tech.mccauley.androidpersonalplaylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    // declarations
    private RecyclerView mainRv;
    private RecyclerView.Adapter mainRvAdapter;
    private RecyclerView.LayoutManager mainRvLayoutManager;
    private PlaylistManager playlistManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get recyclerview
        mainRv = findViewById(R.id.main_rv);

        // set layoutmanager
        mainRvLayoutManager = new LinearLayoutManager(this);
        mainRv.setLayoutManager(mainRvLayoutManager);

        // get playlistmanager
        playlistManager = new PlaylistManager(this);

        // set adapter
        mainRvAdapter = new PlaylistAdapter(playlistManager);
        mainRv.setAdapter(mainRvAdapter);

        // set recyclerview decoration
        mainRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    public void testMethod() {

    }
}
