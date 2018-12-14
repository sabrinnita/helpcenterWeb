package sm.digital.helpcenter.web.HELPCENTER.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sm.digital.helpcenter.web.HELPCENTER.entity.Respuesta;
import sm.digital.helpcenter.web.HELPCENTER.service.ConsultaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/inicio")
    public String welcome(Map<String, Object> model) {
        model.put("message", "Bienvenido al HelpCenter");
        return "welcome";
    }

    @PostMapping("/consulta")
    @ResponseBody
    public String getResource(@RequestParam("texto") String texto) {
        List<Respuesta> preguntas = new ArrayList<>();
        preguntas = consultaService.consultar(texto);
         //return request.getTexto();
        String response = null;
        try {
            response = objectMapper.writeValueAsString(preguntas);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return response;
        //return "redirect:/";
    }

}
