package martin.juanantonio.nbatoday.ui.conferences;

public class Conference {

    private String idEquipoConferencia;
    private String posicionEquipoConferencia;
    private String nombreEquipoConferencia;
    private String apellidoEquipoConferencia;
    private String victoriasEquipoConferencia;
    private String derrotasEquipoConferencia;
    private String conferenciaEquipo;

    public Conference(){

    }

    public Conference(String idEquipoConferencia, String posicionEquipoConferencia, String nombreEquipoConferencia, String apellidoEquipoConferencia, String victoriasEquipoConferencia, String derrotasEquipoConferencia, String conferenciaEquipo) {
        this.idEquipoConferencia = idEquipoConferencia;
        this.posicionEquipoConferencia = posicionEquipoConferencia;
        this.nombreEquipoConferencia = nombreEquipoConferencia;
        this.apellidoEquipoConferencia = apellidoEquipoConferencia;
        this.victoriasEquipoConferencia = victoriasEquipoConferencia;
        this.derrotasEquipoConferencia = derrotasEquipoConferencia;
        this.conferenciaEquipo = conferenciaEquipo;
    }

    public String getIdEquipoConferencia() {
        return idEquipoConferencia;
    }

    public void setIdEquipoConferencia(String idEquipoConferencia) {
        this.idEquipoConferencia = idEquipoConferencia;
    }

    public String getPosicionEquipoConferencia() {
        return posicionEquipoConferencia;
    }

    public void setPosicionEquipoConferencia(String posicionEquipoConferencia) {
        this.posicionEquipoConferencia = posicionEquipoConferencia;
    }

    public String getNombreEquipoConferencia() {
        return nombreEquipoConferencia;
    }

    public void setNombreEquipoConferencia(String nombreEquipoConferencia) {
        this.nombreEquipoConferencia = nombreEquipoConferencia;
    }

    public String getApellidoEquipoConferencia() {
        return apellidoEquipoConferencia;
    }

    public void setApellidoEquipoConferencia(String apellidoEquipoConferencia) {
        this.apellidoEquipoConferencia = apellidoEquipoConferencia;
    }

    public String getVictoriasEquipoConferencia() {
        return victoriasEquipoConferencia;
    }

    public void setVictoriasEquipoConferencia(String victoriasEquipoConferencia) {
        this.victoriasEquipoConferencia = victoriasEquipoConferencia;
    }

    public String getDerrotasEquipoConferencia() {
        return derrotasEquipoConferencia;
    }

    public void setDerrotasEquipoConferencia(String derrotasEquipoConferencia) {
        this.derrotasEquipoConferencia = derrotasEquipoConferencia;
    }

    public String getConferenciaEquipo() {
        return conferenciaEquipo;
    }

    public void setConferenciaEquipo(String conferenciaEquipo) {
        this.conferenciaEquipo = conferenciaEquipo;
    }
}
