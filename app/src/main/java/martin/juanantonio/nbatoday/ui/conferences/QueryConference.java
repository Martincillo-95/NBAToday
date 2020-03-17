package martin.juanantonio.nbatoday.ui.conferences;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class QueryConference {

    public QueryConference() {
    }

    public static List<Conference> extractFeatureFromJSON(String conferenceJSON, String conferenceTeam){

        if(TextUtils.isEmpty(conferenceJSON)){
            return null;
        }

        List<Conference> conferenceList = new ArrayList<>();

        try{
            JSONObject baseJSONResponse = new JSONObject(conferenceJSON);
            JSONObject objectLeague = baseJSONResponse.getJSONObject("league");
            JSONObject objectStandard = objectLeague.getJSONObject("standard");
            JSONObject objectConference = objectStandard.getJSONObject("conference");
            JSONArray arrayEast = objectConference.getJSONArray("east");

            for (int i = 0; i < arrayEast.length(); i++) {
                JSONObject currentResult = arrayEast.getJSONObject(i);

                String teamID = currentResult.getString("teamId");
                String teamWin = currentResult.getString("win");
                String teamLoss = currentResult.getString("loss");
                String confRank = currentResult.getString("confRank");

                JSONObject teamSitesOnly = currentResult.getJSONObject("teamSitesOnly");

                String teamName = teamSitesOnly.getString("teamName");
                String teamNickname = teamSitesOnly.getString("teamNickname");

                if(conferenceTeam.equals("East")){
                    Conference conference = new Conference(teamID, confRank, teamName, teamNickname, teamWin, teamLoss, "East");
                    conferenceList.add(conference);
                }
            }

            JSONArray arrayWest = objectConference.getJSONArray("west");

            for (int i = 0; i < arrayWest.length(); i++) {
                JSONObject currentResult = arrayWest.getJSONObject(i);

                String teamID = currentResult.getString("teamId");
                String teamWin = currentResult.getString("win");
                String teamLoss = currentResult.getString("loss");
                String confRank = currentResult.getString("confRank");

                JSONObject teamSitesOnly = currentResult.getJSONObject("teamSitesOnly");

                String teamName = teamSitesOnly.getString("teamName");
                String teamNickname = teamSitesOnly.getString("teamNickname");


                if(conferenceTeam.equals("West")){
                    Conference conference = new Conference(teamID, confRank, teamName, teamNickname, teamWin, teamLoss, "West");
                    conferenceList.add(conference);
                }
            }

        }catch(JSONException e){
            Log.e("QueryResultConferences", "Problemas obteniendo los datos del JSON de los resultados", e);
        }

        return conferenceList;
    }
}
