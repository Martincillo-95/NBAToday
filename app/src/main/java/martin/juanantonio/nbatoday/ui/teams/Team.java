package martin.juanantonio.nbatoday.ui.teams;

import java.io.Serializable;

public class Team{

    private String nombreEquipo;
    private String conferenciaEquipo;
    private String idEquipo;

    public Team() {
    }

    public Team(String nombreEquipo, String conferenciaEquipo, String idEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.conferenciaEquipo = conferenciaEquipo;
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getConferenciaEquipo() {
        return conferenciaEquipo;
    }

    public void setConferenciaEquipo(String conferenciaEquipo) {
        this.conferenciaEquipo = conferenciaEquipo;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }
}
