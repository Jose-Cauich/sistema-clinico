package Salud.mapper;
import Salud.dtos.Direccion.DireccionDTO;
import Salud.dtos.Paciente.PacienteRegisterDTO;
import Salud.dtos.Paciente.PacienteResponseDTO;
import Salud.dtos.Paciente.PacienteUpdateDTO;
import Salud.entity.*;
import Salud.enums.Genero;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@Slf4j
public class PacienteMapper {

    //convertir entity a dto
    public static PacienteResponseDTO toDtoGet(PacientesEntity pacientesEntity) {

        if (pacientesEntity == null) {
            return null;
        }

        PacienteResponseDTO dto = new PacienteResponseDTO();
        dto.setIdPaciente(pacientesEntity.getIdPaciente());
        dto.setIdNutriologa(pacientesEntity.getNutriologa().getIdNutriologa());
        dto.setNombres(pacientesEntity.getNombres());
        dto.setApellidoPaterno(pacientesEntity.getApellidoPaterno());
        dto.setApellidoMaterno(pacientesEntity.getApellidoMaterno());
        dto.setFechaNacimiento(pacientesEntity.getFechaNacimiento());
        dto.setGenero(pacientesEntity.getGenero().name());
        dto.setTelefono(pacientesEntity.getTelefono());
        dto.setCorreo(pacientesEntity.getCorreo());
        dto.setFechaRegistro(pacientesEntity.getFechaRegistro());

        dto.setDireccion(DireccionesMapper.toDto(pacientesEntity.getDireccion()));

        return dto;
    }

    public static PacientesEntity toEntity(PacienteRegisterDTO pacienteRegisterDTO, NutriologasEntity nutriologa, Genero genero) {


        if (pacienteRegisterDTO == null) {return null;}

        PacientesEntity pacientesEntity = new PacientesEntity();
        pacientesEntity.setNombres(pacienteRegisterDTO.getNombres());
        pacientesEntity.setApellidoPaterno(pacienteRegisterDTO.getApellidoPaterno());
        pacientesEntity.setApellidoMaterno(pacienteRegisterDTO.getApellidoMaterno());
        pacientesEntity.setFechaNacimiento(pacienteRegisterDTO.getFechaNacimiento());
        pacientesEntity.setTelefono(pacienteRegisterDTO.getTelefono());
        pacientesEntity.setCorreo(pacienteRegisterDTO.getCorreo());
        pacientesEntity.setPasswordHash(pacienteRegisterDTO.getPasswordHash());
        pacientesEntity.setFechaNacimiento(pacienteRegisterDTO.getFechaNacimiento());
        pacientesEntity.setFechaRegistro(LocalDateTime.now()); //asigancion de hora y fecha del sistema
        pacientesEntity.setActivo(true);
        pacientesEntity.setGenero(genero);

        //fecha registro

        //asignar pacientes al registrar
        pacientesEntity.setNutriologa(nutriologa);

        pacientesEntity.setDireccion(DireccionesMapper.toEntity(pacienteRegisterDTO.getDireccion()));

        return pacientesEntity;
    }

    public static PacientesEntity updatePaciente(PacienteUpdateDTO dto, PacientesEntity entity) {
        if (dto == null || entity == null) return entity;

        // Actualización de Paciente (Solo si no son nulos)
        if (dto.getNombres() != null) entity.setNombres(dto.getNombres());
        if (dto.getApellidoPaterno() != null) entity.setApellidoPaterno(dto.getApellidoPaterno());
        if (dto.getApellidoMaterno() != null) entity.setApellidoMaterno(dto.getApellidoMaterno());
        if (dto.getCorreo() != null) entity.setCorreo(dto.getCorreo());
        if (dto.getTelefono() != null) entity.setTelefono(dto.getTelefono());

        // Actualización de Dirección (Solo si ambos existen)
        if (dto.getDireccion() != null && entity.getDireccion() != null) {

            DireccionesEntity dir = entity.getDireccion();
            DireccionDTO dDto = dto.getDireccion();

            if (dDto.getCalle() != null) dir.setCalle(dDto.getCalle());
            if (dDto.getCodigoPostal() != null) dir.setCodigoPostal(dDto.getCodigoPostal());
            if (dDto.getMunicipio() != null) dir.setMunicipio(dDto.getMunicipio());
            if (dDto.getEstado() != null) dir.setEstado(dDto.getEstado());
            if (dDto.getColonia() != null) dir.setColonia(dDto.getColonia());
        }

        return entity;
    }

}
