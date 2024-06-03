package de.schrotthandel.notflix_streaming;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class EpisodeListFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<SeriesModel> seriesModelList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //Toolbar
        View view = inflater.inflate(R.layout.fragment_episode_list, container, false);

        androidx.appcompat.widget.Toolbar toolbar = view.findViewById(R.id.toolbar);


        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        SeriesAdapter seriesAdapter = new SeriesAdapter(seriesModelList, getContext());
        recyclerView.setAdapter(seriesAdapter);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        return view;


    }

    public void updateRecyclerView(List<SeriesModel> newSeriesList) {
        seriesModelList.clear();
        seriesModelList.addAll(newSeriesList);
    }
}