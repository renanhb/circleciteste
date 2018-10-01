package com.example.renanbolonha.projetocircleci;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recycler;

    private PlaceAdapter mAdapter;
    private List<Place> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initComponent();
        init();
    }

    public void initComponent() {
        recycler = findViewById(R.id.recycler);

        recycler.addOnItemTouchListener(new RecyclerItemClickListener(getBaseContext(), recycler, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Place place = mItems.get(position);
                Toast.makeText(getBaseContext(), "You are in " + place.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    public void init() {

        mItems = getItems();

        mAdapter = new PlaceAdapter(mItems);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recycler.setAdapter(mAdapter);

    }

    public List<Place> getItems() {

        List<Place> items = new ArrayList<>();

        int id = 1;
        Place place = null;

        place = new Place(id++, "Sao Paulo");
        items.add(place);

        place = new Place(id++, "Rio de Janeiro");
        items.add(place);

        place = new Place(id++, "Curitiba");
        items.add(place);

        place = new Place(id++, "Blumenau");
        items.add(place);

        place = new Place(id++, "Lencois Paulista");
        items.add(place);

        place = new Place(id++, "Bauru");
        items.add(place);

        place = new Place(id++, "Macatuba");
        items.add(place);

        return items;
    }
}
