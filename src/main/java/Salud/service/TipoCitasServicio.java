package Salud.service;

import Salud.dtos.TipoCita.TipoCitaGetDTO;
import Salud.entity.TipoCitasEntity;
import Salud.mapper.TipoCitaMapper;
import Salud.repository.TipoCitaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TipoCitasServicio {


    private TipoCitaRepository repository;

    //Inyeccion de dependencias con constructor manual
    public TipoCitasServicio(TipoCitaRepository repository) {
        this.repository = repository;
    }

    public List<TipoCitaGetDTO> getAllTypes() {
        log.info("Consultando catálogo de tipos de cita");
        return repository.findAll().stream().map(TipoCitaMapper::toDto).collect(Collectors.toList());
    }

    public TipoCitaGetDTO getEntityById(Long id) {
        TipoCitasEntity tipo = repository.findById(id).orElseThrow(() -> new RuntimeException("Tipo de cita no encontrado con ID: " + id));
        return TipoCitaMapper.toDto(tipo);
    }
}