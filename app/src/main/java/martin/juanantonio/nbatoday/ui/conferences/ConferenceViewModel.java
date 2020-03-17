package martin.juanantonio.nbatoday.ui.conferences;

import android.app.Application;
import android.net.Uri;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

import martin.juanantonio.nbatoday.ui.teams.QueryTeams;
import martin.juanantonio.nbatoday.ui.teams.Team;

public class ConferenceViewModel extends AndroidViewModel {

    String conference;
    public MutableLiveData<List<Conference>> conferenceList;
    private Application application;
    public static final String URL_DATA_EQUIPOS = "http://data.nba.net/10s/prod/v1/current/standings_conference.json";

    public ConferenceViewModel(Application application) {
        super(application);
        this.application = application;
    }

    public LiveData<List<Conference>> getConference(String conference){
        this.conference = conference;

        if(conferenceList == null){
            conferenceList = new MutableLiveData<>();
            loadEquipos();
        }

        return conferenceList;
    }

    public void loadEquipos(){

        Uri baseUri = Uri.parse(URL_DATA_EQUIPOS);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        final RequestQueue requestQueue = Volley.newRequestQueue(application);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, uriBuilder.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                List<Conference> listaEquipos = QueryConference.extractFeatureFromJSON(response, conference);
                conferenceList.setValue(listaEquipos);

                Log.d("onReponse", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onErrorReponse", error.getMessage());
            }
        });

        requestQueue.add(stringRequest);
    }
}
