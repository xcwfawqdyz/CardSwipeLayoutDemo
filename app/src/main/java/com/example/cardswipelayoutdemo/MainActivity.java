package com.example.cardswipelayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import me.yuqirong.cardswipelayout.CardItemTouchHelperCallback;
import me.yuqirong.cardswipelayout.CardLayoutManager;
import me.yuqirong.cardswipelayout.OnSwipeListener;

public class MainActivity extends AppCompatActivity {
    private MyAdapter mMyAdapter;
    private List<Person> mPersons=new ArrayList<>();
    private RecyclerView mRecyclerView;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        mButton= (Button) findViewById(R.id.again);
        //mButton.setVisibility(View.GONE);
        mMyAdapter=new MyAdapter(mPersons);
        mRecyclerView.setAdapter(mMyAdapter);

        CardItemTouchHelperCallback cardCallback = new CardItemTouchHelperCallback(mRecyclerView.getAdapter(), mPersons);
        ItemTouchHelper touchHelper = new ItemTouchHelper(cardCallback); CardLayoutManager cardLayoutManager = new CardLayoutManager(mRecyclerView, touchHelper);
        mRecyclerView.setLayoutManager(cardLayoutManager);
        touchHelper.attachToRecyclerView(mRecyclerView);
        cardCallback.setOnSwipedListener(new OnSwipeListener() {
            @Override
            public void onSwiping(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {

            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, Object o, int direction) {

            }

            @Override
            public void onSwipedClear() {

            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPersons.clear();
                initData();
                mMyAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //mMyAdapter.notifyDataSetChanged();
    }

    private void initData() {
        mPersons.add(new Person("git",R.drawable.pk1));
        mPersons.add(new Person("git",R.drawable.pk2));
        mPersons.add(new Person("git",R.drawable.pk3));
        mPersons.add(new Person("git",R.drawable.pk4));
        mPersons.add(new Person("git",R.drawable.pk5));
        mPersons.add(new Person("git",R.drawable.pk6));
        mPersons.add(new Person("git",R.drawable.pk7));
        mPersons.add(new Person("git",R.drawable.pk8));

    }
}
