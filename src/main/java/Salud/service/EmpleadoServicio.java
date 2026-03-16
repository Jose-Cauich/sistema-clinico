package Salud.service;

import Salud.dtos.Empleados.EmpleadosRegisterDTO;
import Salud.dtos.Empleados.EmpleadosResponseDTO;
import Salud.dtos.Rol.RolRequestDTO;
import Salud.entity.EmpleadosEntity;
import Salud.entity.RolEntity;
import Salud.enums.NombreRol;
import Salud.mapper.CitaMapper;
import Salud.mapper.EmpleadoMapper;
import Salud.repository.EmpleadosRepository;
import Salud.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

public class EmpleadoServicio {

    @Autowired
    EmpleadosRepository empleadoRepository;
    @Autowired
    RolRepository rolRepository;

    public List<EmpleadosResponseDTO> obtenerEmpleados() {
        return empleadoRepository.findAll().stream().map(EmpleadoMapper::toDtoGet).collect(Collectors.toList());
    }

    public EmpleadosResponseDTO obtenerEmpleados(Long idEmpleado) {
        EmpleadosEntity entity = empleadoRepository.findById(idEmpleado).orElseThrow(() -> new RuntimeException("No existe el Administrador con el id " + idEmpleado));
        return EmpleadoMapper.toDtoGet(entity);
    }

    //repasar mañana
    public EmpleadosResponseDTO empleadoRegistro(EmpleadosRegisterDTO dto) {

        RolEntity rol = rolRepository.findById(dto.getIdRol()).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        EmpleadosEntity nuevoEmpleado = EmpleadoMapper.toEntity(dto, rol);
        return EmpleadoMapper.toDtoGet(empleadoRepository.save(nuevoEmpleado));

    }


}
