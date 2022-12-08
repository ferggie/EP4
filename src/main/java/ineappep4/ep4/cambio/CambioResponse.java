package ineappep4.ep4.cambio;

import lombok.Builder;
import lombok.Data;

import java.text.DecimalFormat;
import java.util.List;

@Data
@Builder
public class CambioResponse {
    private CambioResponseDetail resultados ;
    private BasicResponse basicResponse;
}
