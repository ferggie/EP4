package ineappep4.ep4.cambio;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransaccionResponse {
    private Double resultado;
    private String from;
    private String to;
    private String tipoCambio;
    private BasicResponse basicResponse;
}
