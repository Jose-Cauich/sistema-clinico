package Salud.dtos.TipoCita;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TipoCitaGetDTO {
    private Long idTipo;
    private String descripcion;
    private Long duracionMinutos;
    private BigDecimal costo;
}
