package martin.juanantonio.nbatoday.ui.teams;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
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

public class TeamViewModel extends AndroidViewModel {

    String conference;
    public MutableLiveData<List<Team>> teamList;
    private Application application;
    public static final String URL_DATA_EQUIPOS = "http://data.nba.net/10s/prod/v2/2018/teams.json";

    public TeamViewModel(Application application) {
        super(application);
        this.application = application;
    }

    public LiveData<List<Team>> getEquipos(String conference){
        this.conference = conference;

        if(teamList == null){
            teamList = new MutableLiveData<>();
            loadEquipos();
        }

        return teamList;
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
                //teamList.postValue(QueryTeams.extractFeatureFromJSON(response, conference));

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
