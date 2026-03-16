package Salud.mapper;

import Salud.dtos.Empleados.EmpleadosRegisterDTO;
import Salud.dtos.Empleados.EmpleadosResponseDTO;
import Salud.dtos.Empleados.EmpleadosUpdateDTO;
import Salud.dtos.Direccion.DireccionDTO;
import Salud.entity.DireccionesEntity;
import Salud.entity.EmpleadosEntity;
import Salud.entity.RolEntity;
import Salud.enums.Genero;
import Salud.enums.NombreRol;

import java.time.LocalDateTime;

public class EmpleadoMapper {

    public static EmpleadosResponseDTO toDtoGet(EmpleadosEntity entity) {
        if (entity == null) return null;

        EmpleadosResponseDTO dto = new EmpleadosResponseDTO();
        dto.setNombres(entity.getNombres());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setCorreo(entity.getCorreo());
        dto.setTelefono(entity.getTelefono());
        dto.setFechaRegistro(entity.getFechaRegistro());
        dto.setRol(entity.getRol().name());//THIS
        dto.setDireccion(DireccionesMapper.toDto(entity.getDireccion()));

        return dto;
    }

    public static EmpleadosEntity toEntity(EmpleadosRegisterDTO dto, RolEntity rol) {
        if (dto == null) return null;

        EmpleadosEntity entity = new EmpleadosEntity();
        entity.setNombres(dto.getNombres());
        entity.setApellidoPaterno(dto.getApellidoPaterno());
        entity.setApellidoMaterno(dto.getApellidoMaterno());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setCorreo(dto.getCorreo());
        entity.setTelefono(dto.getTelefono());
        entity.setPasswordHash(dto.getPasswordHash());
        entity.setFechaRegistro(LocalDateTime.now()); //Asignacion de tiempo de hora y fecha del sistema
        entity.setActivo(true);
        entity.setRol(rol.getNombreRol());
        //mapper-direccion
        entity.setDireccion(DireccionesMapper.toEntity(dto.getDireccion()));

        return entity;
    }


    public static EmpleadosEntity updateEntity(EmpleadosUpdateDTO dto, EmpleadosEntity entity) {
        if (dto == null || entity == null) return entity;

        //mapear datos generales
        if (dto.getNombres() != null) entity.setNombres(dto.getNombres());
        if (dto.getApellidoPaterno() != null) entity.setApellidoPaterno(dto.getApellidoPaterno());
        if (dto.getApellidoMaterno() != null) entity.setApellidoMaterno(dto.getApellidoMaterno());
        if (dto.getCorreo() != null) entity.setCorreo(dto.getCorreo());
        if (dto.getTelefono() != null) entity.setTelefono(dto.getTelefono());
        if (dto.getActivo() != null) entity.setActivo(dto.getActivo());

        //mapear direcciones
        if (dto.getDireccion() != null && entity.getDireccion() != null) {
            DireccionesEntity dir = entity.getDireccion();
            DireccionDTO dDto = dto.getDireccion();

            if (dDto.getCalle() != null) dir.setCalle(dDto.getCalle());
            if (dDto.getColonia() != null) dir.setColonia(dDto.getColonia());
            if (dDto.getMunicipio() != null) dir.setMunicipio(dDto.getMunicipio());
            if (dDto.getEstado() != null) dir.setEstado(dDto.getEstado());
            if (dDto.getCodigoPostal() != null) dir.setCodigoPostal(dDto.getCodigoPostal());
        }

        return entity;
    }
}