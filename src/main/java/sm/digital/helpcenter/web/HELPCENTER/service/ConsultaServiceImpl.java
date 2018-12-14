package sm.digital.helpcenter.web.HELPCENTER.service;

import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sm.digital.helpcenter.web.HELPCENTER.json.request.ConsultaRequest;
import sm.digital.helpcenter.web.HELPCENTER.entity.Respuesta;
import sm.digital.helpcenter.web.HELPCENTER.json.response.RespuestaResponse;
import java.util.List;

@Service
public class ConsultaServiceImpl implements ConsultaService{
    @Override
    public List<Respuesta> consultar(String texto) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ConsultaRequest request = new ConsultaRequest(texto);
        HttpEntity<ConsultaRequest> req = new HttpEntity<ConsultaRequest>(request, headers);
        ResponseEntity<RespuestaResponse> resp = restTemplate.exchange("http://localhost:8080" + "/obtenerPorPalabra", HttpMethod.POST, req, RespuestaResponse.class);
        //System.out.print("Cantidad coincidencias: " + resp.getBody().getCoincidencias().size());
        return resp.getBody().getCoincidencias();
    }
}
