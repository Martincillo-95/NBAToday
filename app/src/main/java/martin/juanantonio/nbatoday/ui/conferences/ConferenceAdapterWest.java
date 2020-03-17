package martin.juanantonio.nbatoday.ui.conferences;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import martin.juanantonio.nbatoday.R;

public class ConferenceAdapterWest extends RecyclerView.Adapter<ConferenceAdapterWest.ViewHolder> {

    private List<Conference> conferenceList;
    private Context context;

    public ConferenceAdapterWest(List<Conference> conferenceList, Context context){
        this.conferenceList = conferenceList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_conference, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Conference conference = conferenceList.get(position);

        holder.posicionEquipo.setText(conference.getPosicionEquipoConferencia());
        holder.nombreEquipo.setText(conference.getNombreEquipoConferencia()+" "+conference.getApellidoEquipoConferencia());
        holder.victoriasEquipo.setText(conference.getVictoriasEquipoConferencia());
        holder.derrotasEquipo.setText(conference.getDerrotasEquipoConferencia());
    }

    @Override
    public int getItemCount() {
        return conferenceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView posicionEquipo;
        TextView nombreEquipo;
        TextView victoriasEquipo;
        TextView derrotasEquipo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            posicionEquipo = itemView.findViewById(R.id.numeroPosicion);
            nombreEquipo = itemView.findViewById(R.id.nombreEquipoResultados);
            victoriasEquipo = itemView.findViewById(R.id.numeroVictorias);
            derrotasEquipo = itemView.findViewById(R.id.numeroDerrotas);
        }
    }
}
