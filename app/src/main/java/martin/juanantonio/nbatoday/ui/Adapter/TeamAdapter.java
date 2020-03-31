package martin.juanantonio.nbatoday.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import martin.juanantonio.nbatoday.R;
import martin.juanantonio.nbatoday.ui.Model.Team;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private List<Team> teamList;
    private Context context;

    public TeamAdapter(List<Team> teamList, Context context) {
        this.teamList = teamList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_row_team, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Team team = teamList.get(position);

        holder.logoEquipo.setImageResource(team.getLogoEquipo());
        holder.nombreEquipo.setText(team.getNombreEquipo());
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView logoEquipo;
        TextView nombreEquipo;
        ImageView logoFavorito;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardViewTeam);
            logoEquipo = itemView.findViewById(R.id.imageViewLogoEquipo);
            nombreEquipo = itemView.findViewById(R.id.nombreEquipo);
            logoFavorito = itemView.findViewById(R.id.favoritoVacio);
        }
    }
}
