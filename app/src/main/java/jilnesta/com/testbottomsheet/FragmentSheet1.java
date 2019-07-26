package jilnesta.com.testbottomsheet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import jilnesta.com.testbottomsheet.adapter.Sheet1Adapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSheet1 extends Fragment {

    public static final String TAG = FragmentSheet1.class.getSimpleName();


    public FragmentSheet1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_sheet1, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

//        SnapHelper snapHelper = new PagerSnapHelper();
//        snapHelper.attachToRecyclerView(recyclerView);

        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(String.format("Item %d", i));
        }

        Sheet1Adapter adapter = new Sheet1Adapter(new Sheet1Adapter.Sheet1DiffCallback());
        recyclerView.setAdapter(adapter);
        adapter.submitList(items);

        return rootView;
    }

}
