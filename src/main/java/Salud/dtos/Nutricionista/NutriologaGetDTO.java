package Salud.dtos.Nutricionista;

import Salud.dtos.Direccion.DireccionDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class NutriologaGetDTO {

    private Long idNutriologa;
    private Long idUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String cedulaProfesional;
    private LocalDate fechaNacimiento;
    private String genero;
    private String telefono;
    private String correo;
    private LocalDateTime fechaRegistro;
    private DireccionDTO direccion;
}
