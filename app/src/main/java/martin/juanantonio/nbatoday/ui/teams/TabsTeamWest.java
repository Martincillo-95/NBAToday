package martin.juanantonio.nbatoday.ui.teams;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import martin.juanantonio.nbatoday.R;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabsTeamWest extends Fragment {

    List<Team> listaEquipos;
    TeamAdapterWest teamAdapterWest;
    Team team;
    RecyclerView recyclerView;
    ImageView imageViewLogo, imageViewFavorite;
    TextView textViewNombre;

    public TabsTeamWest() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_tabs_team_west, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewTeamWest);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        textViewNombre = view.findViewById(R.id.nombreEquipo);

        imageViewLogo = view.findViewById(R.id.imageViewLogoEquipo);

        imageViewFavorite = view.findViewById(R.id.favoritoVacio);

        listaEquipos = new ArrayList<Team>();

        teamAdapterWest = new TeamAdapterWest(listaEquipos, getActivity());

        recyclerView.setAdapter(teamAdapterWest);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = info != null && info.isConnected();

        if(isConnected){
            TeamViewModel model = ViewModelProviders.of(this).get(TeamViewModel.class);
            model.getEquipos("West").observe(this, new Observer<List<Team>>() {
                @Override
                public void onChanged(@Nullable List<Team> teams) {
                    teamAdapterWest.notifyDataSetChanged();
                    listaEquipos.clear();
                    if(teamAdapterWest != null){
                        listaEquipos.addAll(teams);
                    }else{
                        Log.d("Hola", "error on changed de tab west");
                    }
                }
            });
        }else{
            Log.d("Hola", "error on resume de tab west");
        }
    }

}
