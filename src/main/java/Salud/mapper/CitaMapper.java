package Salud.mapper;

import Salud.dtos.Cita.CitaGetDTO;
import Salud.dtos.Cita.CitaPostDTO;
import Salud.dtos.Cita.CitaPutDTO;
import Salud.entity.CitasEntity;
import Salud.entity.TipoCitasEntity;
import Salud.entity.NutriologasEntity;
import Salud.entity.PacientesEntity;
import Salud.enums.EstadoCita;
import Salud.enums.EstadoPago;
import jakarta.validation.constraints.Null;


public class CitaMapper {

    public static CitaGetDTO toDto(CitasEntity entity) {

        if (entity == null) return null;

        CitaGetDTO dto = new CitaGetDTO();
        dto.setIdCita(entity.getIdCita()); //para operaciones
        dto.setEstadoCita(entity.getEstadoCita().name());
        dto.setNombreNutriologa(entity.getNutriologa().getNombres());
        dto.setFecha(entity.getFecha());
        dto.setHoraFin(entity.getHoraFin());
        dto.setHoraInicio(entity.getHoraInicio());
        dto.setNombreTipoCita(entity.getTipoCita().getDescripcion());

        return dto;
    }

    public static CitasEntity toEntity(CitaPostDTO dto, PacientesEntity paciente, NutriologasEntity nutritiologa, TipoCitasEntity tipo) {

        if (dto == null) return null;

        CitasEntity entity = new CitasEntity();

        //registramos objetos
        entity.setPaciente(paciente);
        entity.setNutriologa(nutritiologa);
        entity.setTipoCita(tipo);

        //Al registrar se guarda como "PENDIENTE"
        entity.setEstadoCita(EstadoCita.PENDIENTE);
        entity.setFecha(dto.getFecha());
        entity.setHoraInicio(dto.getHoraInicio());
        entity.setHoraFin(dto.getHoraFin());

        return entity;
    }

    public static CitasEntity toEntity(CitaPutDTO dto, CitasEntity citas) {
        if (dto == null) return null;

        if (dto.getEstadoCita() !=null)citas.setEstadoCita(EstadoCita.valueOf(dto.getEstadoCita()));
        if (dto.getEstadoCita() != null)citas.setFecha(dto.getFecha());
        if (dto.getHoraInicio() != null)citas.setHoraInicio(dto.getHoraInicio());
        if (dto.getHoraFin() != null)citas.setHoraFin(dto.getHoraFin());

        return citas;
    }
}