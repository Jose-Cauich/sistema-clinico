package Salud.dtos.Paciente;

import Salud.dtos.Direccion.DireccionDTO;
import Salud.enums.Genero;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PacientePostDTO {
    private Long idPaciente;
    private Long idNutriologa;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Genero genero;
    private String telefono;
    private String correo;
    public LocalDate fechaNacimiento;
    private LocalDateTime fechaRegistro;
    private String passwordHash;
    private boolean activo;
    private String avatarUrl;

    //usamos objeto direccion en DTO
    private DireccionDTO direccion;
}