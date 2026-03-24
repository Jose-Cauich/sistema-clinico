package Salud.mapper;

import Salud.dtos.Rol.RolPostDTO;
import Salud.dtos.Rol.RolGetDTO;
import Salud.entity.RolEntity;

public class RolesMapper {

    public static RolGetDTO toDto(RolEntity entity) {
        if (entity == null) return null;

        RolGetDTO dto = new RolGetDTO();
        dto.setNombre(entity.getNombreRol().name());
        return dto;
    }

    public static RolEntity toEntity(RolPostDTO dto) {
        if (dto == null) return null;

        RolEntity entity = new RolEntity();
        entity.setNombreRol(dto.getNombre());
        return entity;
    }
}