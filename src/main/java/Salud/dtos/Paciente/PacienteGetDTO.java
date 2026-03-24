package Salud.dtos.Paciente;

import Salud.dtos.Direccion.DireccionDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PacienteGetDTO {

    private Long idPaciente;
    private Long idNutriologa;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String genero;
    private String telefono;
    private String correo;
    public LocalDate fechaNacimiento;
    private LocalDateTime fechaRegistro;
    private String passwordHash;
    private boolean activo;

    //usamos objeto direccion en DTO
    private DireccionDTO direccion;
}
