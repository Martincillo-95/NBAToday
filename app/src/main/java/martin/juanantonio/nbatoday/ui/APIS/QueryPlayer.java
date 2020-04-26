package martin.juanantonio.nbatoday.ui.APIS;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import martin.juanantonio.nbatoday.ui.Model.Player;

public final class QueryPlayer {

    public QueryPlayer() {

    }

    public static List<Player> extractFeatureFromJSON(String playerJSON) {

        if (TextUtils.isEmpty(playerJSON)) {
            return null;
        }

        List<Player> playerList = new ArrayList<>();

        try {

            JSONObject baseJSONResponse = new JSONObject(playerJSON);
            JSONObject objectLeague = baseJSONResponse.getJSONObject("league");
            JSONArray arrayStandard = objectLeague.getJSONArray("standard");

            for (int i = 0; i < arrayStandard.length(); i++) {

                JSONObject currentPlayer = arrayStandard.getJSONObject(i);

                boolean active = currentPlayer.getBoolean("isActive");

                String personId = "", teamId = "", firstName = "", lastName = "", pos = "", heightMeters = "";

                if(active == true){//Compruebo si el jugador esta en activo

                    personId = currentPlayer.getString("personId");
                    teamId = currentPlayer.getString("teamId");
                    firstName = currentPlayer.getString("firstName");
                    lastName = currentPlayer.getString("lastName");
                    pos = currentPlayer.getString("pos");
                    heightMeters = currentPlayer.getString("heightMeters");

                }

                Player player = new Player(personId, teamId, firstName, lastName, pos, heightMeters);
                playerList.add(player);

            }

        } catch (JSONException e) {

            e.printStackTrace();

        }

        return playerList;

    }

}