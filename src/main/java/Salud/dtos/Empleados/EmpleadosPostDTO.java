package Salud.dtos.Empleados;

import Salud.dtos.Direccion.DireccionDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmpleadosPostDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDateTime fechaNacimiento;
    private String correo;
    private String telefono;
    private String passwordHash;
    private Long idRol; // El ID del rol (Admin o Recepcionista)
    private LocalDateTime fechaRegistro;
    private DireccionDTO direccion;
    private boolean activo;
}
