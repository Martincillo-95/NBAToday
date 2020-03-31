package martin.juanantonio.nbatoday.ui.ViewModel;

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

import martin.juanantonio.nbatoday.ui.Model.Conference;
import martin.juanantonio.nbatoday.ui.APIS.QueryConference;
import martin.juanantonio.nbatoday.ui.APIS.QueryTeams;
import martin.juanantonio.nbatoday.ui.Model.Player;
import martin.juanantonio.nbatoday.ui.Model.Team;

public class AppViewModel extends AndroidViewModel {

    String conference;

    public MutableLiveData<List<Conference>> conferenceList;
    public MutableLiveData<List<Team>> teamList;
    public MutableLiveData<List<Player>> playerList;

    private Application application;

    public static final String URL_DATA_CONFERENCE = "http://data.nba.net/10s/prod/v1/current/standings_conference.json";
    public static final String URL_DATA_EQUIPOS = "http://data.nba.net/10s/prod/v2/2018/teams.json";
    public static final String URL_DATA_PLAYERS = "http://data.nba.net/10s/prod/v1/2018/players.json";

    public AppViewModel(Application application) {
        super(application);
        this.application = application;
    }

    public LiveData<List<Conference>> getConference(String conference){
        this.conference = conference;

        if(conferenceList == null){
            conferenceList = new MutableLiveData<>();
            loadConference();
        }

        return conferenceList;
    }

    public LiveData<List<Team>> getEquipos(String conference){
        this.conference = conference;

        if(teamList == null){
            teamList = new MutableLiveData<>();
            loadEquipos();
        }

        return teamList;
    }

    public LiveData<List<Player>> getPlayers(){

        if(playerList == null){
            playerList = new MutableLiveData<>();
            loadPlayers();
        }

        return playerList;
    }

    public void loadConference(){

        Uri baseUri = Uri.parse(URL_DATA_CONFERENCE);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        final RequestQueue requestQueue = Volley.newRequestQueue(application);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, uriBuilder.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                List<Conference> listaConference = QueryConference.extractFeatureFromJSON(response, conference);
                conferenceList.setValue(listaConference);

                Log.d("onReponse", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onErrorReponse Conferen", error.getMessage());
            }
        });

        requestQueue.add(stringRequest);
    }

    public void loadEquipos(){

        Uri baseUri = Uri.parse(URL_DATA_EQUIPOS);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        final RequestQueue requestQueue = Volley.newRequestQueue(application);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, uriBuilder.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                List<Team> listaEquipos = QueryTeams.extractFeatureFromJSON(response, conference);
                teamList.setValue(listaEquipos);

                Log.d("onReponse", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onErrorReponse Equipos", error.getMessage());
            }
        });

        requestQueue.add(stringRequest);
    }

    public void loadPlayers(){

        Uri baseUri = Uri.parse(URL_DATA_PLAYERS);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        final RequestQueue requestQueue = Volley.newRequestQueue(application);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, uriBuilder.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("onErrorReponse Players", error.getMessage());
            }
        });
    }
}
