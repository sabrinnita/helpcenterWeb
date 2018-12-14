package sm.digital.helpcenter.web.HELPCENTER.json.request;

public class ConsultaRequest {
    private String texto;

    public ConsultaRequest() {
    }

    public ConsultaRequest(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
