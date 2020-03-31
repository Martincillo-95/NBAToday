package martin.juanantonio.nbatoday.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import martin.juanantonio.nbatoday.R;
import martin.juanantonio.nbatoday.ui.Model.Player;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder>{

    private List<Player> playerList;
    private Context context;

    public PlayerAdapter(List<Player> playerList, Context context) {
        this.playerList = playerList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_players, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Player player = playerList.get(position);

        holder.nombreJugador.setText(player.getNombreJugador());
        holder.posicionJugador.setText(player.getPosicionJugador());
        holder.estaturaJugador.setText(player.getEstaturaJugador());
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombreJugador;
        TextView posicionJugador;
        TextView estaturaJugador;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreJugador = itemView.findViewById(R.id.nombreJugador);
            posicionJugador = itemView.findViewById(R.id.posicionJugador);
            estaturaJugador = itemView.findViewById(R.id.estaturaJugador);
        }
    }
}
