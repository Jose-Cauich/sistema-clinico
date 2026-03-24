package Salud.dtos.Empleados;

import Salud.dtos.Direccion.DireccionDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmpleadosGetDTO {
    private Integer idPersonal; //para operaciones
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDateTime fechaNacimiento;
    private String correo;
    private String telefono;
    private String nombreRol;
    private LocalDateTime fechaRegistro;
    private DireccionDTO direccion;
    private String rol;
}
