package Salud.dtos.Nutricionista;
import Salud.dtos.Direccion.DireccionDTO;
import Salud.enums.Genero;
import lombok.Data;
import java.time.LocalDate;

    @Data
    public class NutriologalPostDTO {

        private String nombres;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String cedulaProfesional;
        private LocalDate fechaNacimiento;
        private Genero genero;
        private String telefono;
        private String correo;
        private String passwordHash;
        private LocalDate fechaRegistro;
        private DireccionDTO direccion;

}
