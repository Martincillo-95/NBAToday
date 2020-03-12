package martin.juanantonio.nbatoday.ui.teams;

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

public class TeamAdapterEast extends RecyclerView.Adapter<TeamAdapterEast.ViewHolder> {

    private List<Team> teamList;
    private Context context;

    public TeamAdapterEast(List<Team> teamList, Context context) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Team team = teamList.get(position);

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
