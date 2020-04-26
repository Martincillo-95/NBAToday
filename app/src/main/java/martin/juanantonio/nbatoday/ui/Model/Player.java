package martin.juanantonio.nbatoday.ui.Model;

public class Player {

    private String idJugador;
    private String idEquipo;
    private String nombreJugador;
    private String apellidoJugador;
    private String posicionJugador;
    private String estaturaJugador;

    public Player(){

    }

    public Player(String idJugador, String idEquipo, String nombreJugador, String apellidoJugador, String posicionJugador, String estaturaJugador) {
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
        this.nombreJugador = nombreJugador;
        this.apellidoJugador = apellidoJugador;
        this.posicionJugador = posicionJugador;
        this.estaturaJugador = estaturaJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getPosicionJugador() {
        return posicionJugador;
    }

    public void setPosicionJugador(String posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    public String getEstaturaJugador() {
        return estaturaJugador;
    }

    public void setEstaturaJugador(String estaturaJugador) {
        this.estaturaJugador = estaturaJugador;
    }

    public String getApellidoJugador() {
        return apellidoJugador;
    }

    public void setApellidoJugador(String apellidoJugador) {
        this.apellidoJugador = apellidoJugador;
    }
}
