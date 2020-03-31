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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import martin.juanantonio.nbatoday.R;
import martin.juanantonio.nbatoday.ui.Adapter.ConferenceAdapter;
import martin.juanantonio.nbatoday.ui.Model.Conference;
import martin.juanantonio.nbatoday.ui.ViewModel.AppViewModel;

import static android.content.Context.CONNECTIVITY_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabConferenceEast extends Fragment {

    List<Conference> listaConference;
    ConferenceAdapter conferenceAdapter;
    Conference conference;
    RecyclerView recyclerView;
    TextView textViewNombre, textViewPosicion, textViewVictorias, textViewDerrotas;

    public TabConferenceEast() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_conference_east, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewConferenceEast);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        textViewPosicion = view.findViewById(R.id.numeroPosicion);

        textViewNombre = view.findViewById(R.id.nombreEquipoResultados);

        textViewVictorias = view.findViewById(R.id.numeroVictorias);

        textViewDerrotas = view.findViewById(R.id.numeroDerrotas);

        listaConference = new ArrayList<>();

        conferenceAdapter = new ConferenceAdapter(listaConference, getActivity());

        recyclerView.setAdapter(conferenceAdapter);

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
            model.getConference("East").observe(this, new Observer<List<Conference>>() {
                @Override
                public void onChanged(@Nullable List<Conference> teams) {
                    conferenceAdapter.notifyDataSetChanged();
                    listaConference.clear();
                    if(conferenceAdapter != null){
                        listaConference.addAll(teams);
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
