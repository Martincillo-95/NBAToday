package martin.juanantonio.nbatoday.ui.teams;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class QueryTeams {

    public QueryTeams() {
    }

    public static List<Team> extractFeatureFromJSON(String teamJSON, String conference){

        if(TextUtils.isEmpty(teamJSON)){
            return null;
        }

        List<Team> teamList = new ArrayList<>();

        try{
            JSONObject baseJSONResponse = new JSONObject(teamJSON);
            JSONObject objectLeague = baseJSONResponse.getJSONObject("league");
            JSONArray arrayStandard = objectLeague.getJSONArray("standard");

            for (int i = 0; i < arrayStandard.length(); i++) {
                JSONObject currentTeam = arrayStandard.getJSONObject(i);

                boolean nbaTeam = currentTeam.getBoolean("isNBAFranchise");

                String nameTeam = "";
                String conferenceTeam = "";
                String idTeam = "";

                if(nbaTeam==true){
                    nameTeam = currentTeam.getString("fullName");
                    conferenceTeam = currentTeam.getString("confName");
                    idTeam = currentTeam.getString("teamId");

                    if(conferenceTeam.equals(conference)){
                        Team team = new Team(nameTeam, conferenceTeam, idTeam);
                        teamList.add(team);
                    }
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return teamList;
    }
}
