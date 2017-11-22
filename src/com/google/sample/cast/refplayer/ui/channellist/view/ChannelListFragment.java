package com.google.sample.cast.refplayer.ui.channellist.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.sample.cast.refplayer.JarriOnApplication;
import com.google.sample.cast.refplayer.R;
import com.google.sample.cast.refplayer.di.component.ApplicationComponent;
import com.google.sample.cast.refplayer.di.component.DaggerChannelListComponent;
import com.google.sample.cast.refplayer.navigation.ChannelActivityNavigator;
import com.google.sample.cast.refplayer.ui.channellist.model.ChannelListItemViewModel;
import com.google.sample.cast.refplayer.ui.channellist.presenter.ChannelListPresenter;

import java.util.List;

import javax.inject.Inject;

public class ChannelListFragment extends Fragment
        implements StationListView, StationListItemClickListener {
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView stationsRecyclerView;
    private StationListAdapter stationListAdapter;
    @Inject
    ChannelListPresenter presenter;
    @Inject
    ChannelActivityNavigator channelActivityNavigator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationComponent component = JarriOnApplication.getInstance().getComponent();
        DaggerChannelListComponent.builder()
                .applicationComponent(component)
                .build()
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_station_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(view);
        setupRefreshLayout(view);
        presenter.setView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getStations();
    }

    @Override
    public void onDestroyView() {
        if (presenter != null) {
            presenter.removeView();
        }
        super.onDestroyView();
    }

    private void setupRefreshLayout(View view) {
        swipeRefreshLayout = view.findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.getStations());
    }

    private void setupRecyclerView(View view) {
        stationsRecyclerView = view.findViewById(R.id.stations_recycler_view);
        stationListAdapter = new StationListAdapter(this);
        stationsRecyclerView.setAdapter(stationListAdapter);
    }

    @Override
    public void showStations(List<ChannelListItemViewModel> stations) {
        stationListAdapter.setStations(stations);
    }

    @Override
    public void hideRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemClick(ChannelListItemViewModel channelListItemViewModel) {
        channelActivityNavigator.navigate(getContext(), channelListItemViewModel.getJsonURL());
    }
}