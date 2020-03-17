package martin.juanantonio.nbatoday.ui.conferences;


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

import static android.content.Context.CONNECTIVITY_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabConferenceEast extends Fragment {

    List<Conference> listaConference;
    ConferenceAdapterEast conferenceAdapterEast;
    Conference conference;
    RecyclerView recyclerView;
    TextView textViewNombre, textViewApellido, textViewPosicion, textViewVictorias, textViewDerrotas;

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

        textViewApellido = view.findViewById(R.id.apellidoEquipoResultados);

        textViewVictorias = view.findViewById(R.id.numeroVictorias);

        textViewDerrotas = view.findViewById(R.id.numeroDerrotas);

        listaConference = new ArrayList<>();

        conferenceAdapterEast = new ConferenceAdapterEast(listaConference, getActivity());

        recyclerView.setAdapter(conferenceAdapterEast);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = info != null && info.isConnected();

        if(isConnected){
            ConferenceViewModel model = ViewModelProviders.of(this).get(ConferenceViewModel.class);
            model.getConference("East").observe(this, new Observer<List<Conference>>() {
                @Override
                public void onChanged(@Nullable List<Conference> teams) {
                    conferenceAdapterEast.notifyDataSetChanged();
                    listaConference.clear();
                    if(conferenceAdapterEast != null){
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
