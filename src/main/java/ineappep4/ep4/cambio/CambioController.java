package ineappep4.ep4.cambio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CambioController {

    @Autowired
    private RestTemplate restTemplate;
    private static String url = "https://api.exchangerate.host/convert?from={1}&to={2}";

    @GetMapping
    @RequestMapping("/api/v1/tipo-cambio")
    public CambioResponse obtenerTipoCambio(@RequestParam String from, @RequestParam String to) {

        MonedaResponse response = restTemplate.getForObject(url
                , MonedaResponse.class, from, to);

        try {

            CambioResponseDetail cambioResponseDetail = CambioResponseDetail.builder()
                    .from(from)
                    .to(to)
                    .tipoCambio(String.format("%.4s", (response.getResult()))).build();

            return CambioResponse.builder()
                    .resultados(cambioResponseDetail)
                    .basicResponse(BasicResponse.whenSuccess()).build();
        } catch (Exception e) {
            return CambioResponse.builder()
                    .resultados(null)
                    .basicResponse(BasicResponse.whenError(e.getMessage()))
                    .build();
        }
    }

    @GetMapping
    @RequestMapping("/api/v1/valor-cambio")
    public TransaccionResponse TransaccionCambio( @RequestParam int monto,
                                                  @RequestParam String from,
                                                  @RequestParam String to)
    {

        MonedaResponse response = restTemplate.getForObject(url
                , MonedaResponse.class, from, to);

        try {
            Double Resultado = monto * Double.parseDouble(response.getResult());

            return TransaccionResponse.builder()
                    .from(from)
                    .to(to)
                    .tipoCambio(String.format("%.4s", (response.getResult())))
                    .resultado(Resultado)
                    .basicResponse(BasicResponse.whenSuccess()).build();
        } catch (Exception e) {
            return TransaccionResponse.builder()
                    .basicResponse(BasicResponse.whenError(e.getMessage()))
                    .build();
        }
    }

}

















