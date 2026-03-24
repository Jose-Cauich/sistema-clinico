package Salud.controller;

import Salud.dtos.Paciente.PacientePostDTO;
import Salud.dtos.Paciente.PacienteGetDTO;
import Salud.dtos.Paciente.PacienteUpdateDTO;
import Salud.service.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @GetMapping("/todos")
    public ResponseEntity<List<PacienteGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(pacienteServicio.obtenerTodos());
    }

    //Ya se entiende que es obtener
    @GetMapping("/{id}")
    public ResponseEntity<PacienteGetDTO> obtenerPaciente(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteServicio.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<PacienteGetDTO> insertarPaciente(@RequestBody PacientePostDTO pacientePostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteServicio.insertarPaciente(pacientePostDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarPaciente(@PathVariable Long id, @RequestBody PacienteUpdateDTO pacienteUpdateDTO) {
        pacienteServicio.actualizarPaciente(id, pacienteUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/desactivar/{id}")
    public ResponseEntity<Void>desactivarPaciente(@PathVariable Long id){
        pacienteServicio.desactivarPaciente(id);
        return ResponseEntity.ok().build();
    }

}
