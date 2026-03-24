package Salud.service;

import Salud.dtos.Empleados.EmpleadosPostDTO;
import Salud.dtos.Empleados.EmpleadosGetDTO;
import Salud.dtos.Empleados.EmpleadosUpdateDTO;
import Salud.entity.EmpleadosEntity;
import Salud.entity.RolEntity;
import Salud.mapper.EmpleadoMapper;
import Salud.repository.EmpleadosRepository;
import Salud.repository.RolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class EmpleadoServicio {

    @Autowired
    EmpleadosRepository empleadoRepository;
    @Autowired
    RolRepository rolRepository;

    public List<EmpleadosGetDTO> obtenerTodos() {
        return empleadoRepository.findAll().stream().map(EmpleadoMapper::toDtoGet).collect(Collectors.toList());
    }

    public EmpleadosGetDTO obtenerPorId(Long idEmpleado) {
        EmpleadosEntity entity = empleadoRepository.findById(idEmpleado).orElseThrow(() -> new RuntimeException("No existe el Administrador con el id " + idEmpleado));
        return EmpleadoMapper.toDtoGet(entity);
    }

    public EmpleadosGetDTO insertarEmpleado(EmpleadosPostDTO dto) {

        RolEntity rol = rolRepository.findById(dto.getIdRol()).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        EmpleadosEntity nuevoEmpleado = EmpleadoMapper.toEntity(dto, rol);
        log.info("Empleado guardado con éxito");
        return EmpleadoMapper.toDtoGet(empleadoRepository.save(nuevoEmpleado));
    }

    @Transactional
    public void actualizarEmpleado(Long id, EmpleadosUpdateDTO dto) {
        EmpleadosEntity entity = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
        EmpleadoMapper.updateEntity(dto, entity);
    }

    @Transactional
    public void desactivarEmpleado(Long id) {
        EmpleadosEntity entity = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
        entity.setActivo(false);
        log.info("Empleado con ID {} desactivado", id);
    }

}
