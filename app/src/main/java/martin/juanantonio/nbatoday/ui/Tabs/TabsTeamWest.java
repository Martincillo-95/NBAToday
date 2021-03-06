package martin.juanantonio.nbatoday.ui.Tabs;


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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import martin.juanantonio.nbatoday.R;
import martin.juanantonio.nbatoday.ui.Adapter.TeamAdapter;
import martin.juanantonio.nbatoday.ui.Listener.OnAdapterListener;
import martin.juanantonio.nbatoday.ui.Model.Team;
import martin.juanantonio.nbatoday.ui.ViewModel.AppViewModel;
import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabsTeamWest extends Fragment {

    List<Team> listaEquipos;
    TeamAdapter teamAdapter;
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

        /*imageViewFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(imageViewFavorite.set)

                imageViewFavorite.setImageResource(R.drawable.icono_favorito_relleno);
            }
        });*/

        listaEquipos = new ArrayList<Team>();

        teamAdapter = new TeamAdapter(listaEquipos, getActivity());

        teamAdapter.setOnAdapterListener(new OnAdapterListener() {
            @Override
            public void onTeamNameClicked(int position, String teamName) {
                Toast.makeText(getActivity(), "Posicion: "+position+"\n"+"Nombre equipo: "+teamName, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(teamAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = info != null && info.isConnected();

        if(isConnected){
            AppViewModel model = ViewModelProviders.of(this).get(AppViewModel.class);
            model.getEquipos("West").observe(this, new Observer<List<Team>>() {
                @Override
                public void onChanged(@Nullable List<Team> teams) {
                    teamAdapter.notifyDataSetChanged();
                    listaEquipos.clear();
                    if(teamAdapter != null){
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
