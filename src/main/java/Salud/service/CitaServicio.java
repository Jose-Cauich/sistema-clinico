package Salud.service;

import Salud.dtos.Cita.CitaGetDTO;
import Salud.dtos.Cita.CitaPostDTO;
import Salud.dtos.Cita.CitaPutDTO;
import Salud.entity.CitasEntity;
import Salud.entity.TipoCitasEntity;
import Salud.entity.NutriologasEntity;
import Salud.entity.PacientesEntity;
import Salud.enums.EstadoCita;
import Salud.mapper.CitaMapper;
import Salud.repository.CitaRepository;
import Salud.repository.TipoCitaRepository;
import Salud.repository.NutriologaRepository;
import Salud.repository.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CitaServicio {

    @Autowired
    private CitaRepository CitaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private NutriologaRepository nutriologaRepository;
    @Autowired
    private TipoCitaRepository tipoCitaRepository;

    public List<CitaGetDTO> TodasCitas(Long pacienteId) {
        return CitaRepository.findByPatient_IdPaciente(pacienteId).stream().map(CitaMapper::toDto).collect(Collectors.toList());
    }

    public CitaGetDTO citaPaciente(Long citaId) {
        CitasEntity nuevaCita = CitaRepository.findById(citaId).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        return CitaMapper.toDto(nuevaCita);
    }

    public CitaGetDTO crearCita(CitaPostDTO dto) {

        PacientesEntity patient = pacienteRepository.findById(dto.getIdPaciente()).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        NutriologasEntity nutritionist = nutriologaRepository.findById(dto.getIdNutriologa()).orElseThrow(() -> new RuntimeException("Nutriólogo no encontrado"));
        TipoCitasEntity tipo = tipoCitaRepository.findById(dto.getIdTipoCita()).orElseThrow(() -> new RuntimeException("Tipo de cita no válido"));

        CitasEntity entity = CitaMapper.toEntity(dto, patient, nutritionist, tipo);
        return CitaMapper.toDto(CitaRepository.save(entity));
    }

    public void UpdateCita(Long citaId, CitaPutDTO dto) {
        CitasEntity cita = CitaRepository.findById(citaId).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        CitaMapper.toEntity(dto, cita);
    }

}