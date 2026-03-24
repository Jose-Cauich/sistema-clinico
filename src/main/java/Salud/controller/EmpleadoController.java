package Salud.controller;

import Salud.dtos.Empleados.EmpleadosPostDTO;
import Salud.dtos.Empleados.EmpleadosGetDTO;
import Salud.dtos.Empleados.EmpleadosUpdateDTO;
import Salud.service.EmpleadoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoServicio empleadoServicio;

    @GetMapping
    public ResponseEntity<List<EmpleadosGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(empleadoServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadosGetDTO> obtenerEmpleado(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoServicio.obtenerPorId(id));
    }

    //Ya se entiende que es insertar
    @PostMapping()
    public ResponseEntity<EmpleadosGetDTO> insertarEmpleado(@RequestBody EmpleadosPostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoServicio.insertarEmpleado(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarEmpleado(@PathVariable Long id, @RequestBody EmpleadosUpdateDTO dto) {
        empleadoServicio.actualizarEmpleado(id, dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/desactivar/{id}")
    public ResponseEntity<Void> desactivarEmpleado(@PathVariable Long id) {
        empleadoServicio.desactivarEmpleado(id);
        return ResponseEntity.ok().build();
    }
}