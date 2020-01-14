package martin.juanantonio.nbatoday.ui.teams;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import martin.juanantonio.nbatoday.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabsTeamEast extends Fragment {


    public TabsTeamEast() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tabs_team_east, container, false);
    }

}
