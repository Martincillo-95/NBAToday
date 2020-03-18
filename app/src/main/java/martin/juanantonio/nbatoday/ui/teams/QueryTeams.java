package martin.juanantonio.nbatoday.ui.teams;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import martin.juanantonio.nbatoday.R;

public final class QueryTeams {

    public QueryTeams() {
    }

    public static List<Team> extractFeatureFromJSON(String teamJSON, String conference){

        TreeMap<String, Integer> coleccionImagenes;

        coleccionImagenes = imageTeam();

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

                int logoTeam = 0;
                String nameTeam = "";
                String conferenceTeam = "";
                String idTeam = "";

                if(nbaTeam==true){

                    nameTeam = currentTeam.getString("fullName");

                    if(coleccionImagenes.keySet().contains(nameTeam)){
                        logoTeam = coleccionImagenes.get(nameTeam);
                    }

                    conferenceTeam = currentTeam.getString("confName");
                    idTeam = currentTeam.getString("teamId");

                    if(conferenceTeam.equals(conference)){
                        Team team = new Team(nameTeam, conferenceTeam, idTeam, logoTeam);
                        teamList.add(team);
                    }
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return teamList;
    }

    public static TreeMap<String, Integer> imageTeam(){

        TreeMap<String, Integer> imageTeam = new TreeMap<>();

        imageTeam.put("Boston Celtics", R.drawable.boston);
        imageTeam.put("Los Angeles Lakers", R.drawable.lakers);
        imageTeam.put("LA Clippers", R.drawable.clippers);
        imageTeam.put("Cleveland Cavaliers", R.drawable.cavs);
        imageTeam.put("Orlando Magic", R.drawable.magic);
        imageTeam.put("Dallas Mavericks", R.drawable.mavericks);
        imageTeam.put("Memphis Grizzlies", R.drawable.memphis);
        imageTeam.put("Miami Heat", R.drawable.miami);
        imageTeam.put("Golden State Warriors", R.drawable.gsw);
        imageTeam.put("Utah Jazz", R.drawable.jazz);
        imageTeam.put("Chicago Bulls", R.drawable.bulls);
        imageTeam.put("Detroit Pistons", R.drawable.detroit);
        imageTeam.put("Denver Nuggets", R.drawable.denver_nuggets);
        imageTeam.put("Charlotte Hornets", R.drawable.hornets);
        imageTeam.put("Atlanta Hawks", R.drawable.hawks);
        imageTeam.put("Brooklyn Nets", R.drawable.nets);
        imageTeam.put("Indiana Pacers", R.drawable.pacers);
        imageTeam.put("New York Knicks", R.drawable.knicks);
        imageTeam.put("Philadelphia 76ers", R.drawable.sixers);
        imageTeam.put("Toronto Raptors", R.drawable.toronto);
        imageTeam.put("Washington Wizards", R.drawable.wizards);
        imageTeam.put("Milwaukee Bucks", R.drawable.bucks);
        imageTeam.put("Houston Rockets", R.drawable.rockets);
        imageTeam.put("Minnesota Timberwolves", R.drawable.timberwolves);
        imageTeam.put("New Orleans Pelicans", R.drawable.pelicans);
        imageTeam.put("Phoenix Suns", R.drawable.suns);
        imageTeam.put("Portland Trail Blazers", R.drawable.portland);
        imageTeam.put("Sacramento Kings", R.drawable.sacramento);
        imageTeam.put("San Antonio Spurs", R.drawable.spurspng);
        imageTeam.put("Oklahoma City Thunder", R.drawable.thunder);

        return imageTeam;
    }
}
