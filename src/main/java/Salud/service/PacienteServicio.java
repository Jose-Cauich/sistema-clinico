package Salud.service;

import Salud.dtos.Paciente.PacienteRegisterDTO;
import Salud.dtos.Paciente.PacienteResponseDTO;
import Salud.dtos.Paciente.PacienteUpdateDTO;
import Salud.entity.NutriologasEntity;
import Salud.entity.PacientesEntity;
import Salud.enums.Genero;
import Salud.mapper.PacienteMapper;
import Salud.repository.NutriologaRepository;
import Salud.repository.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class PacienteServicio {

    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    NutriologaRepository nutriologaRepository;


    public PacienteResponseDTO obtenerPaciente(Long id) {
        PacientesEntity patient = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        return PacienteMapper.toDtoGet(patient);
    }

    public PacienteResponseDTO insertarPaciente(PacienteRegisterDTO dto) {

        //objetos-relación
        NutriologasEntity nutriologasEntity = nutriologaRepository.findById(dto.getIdNutriologa()).orElseThrow(()->new RuntimeException("Nutrióloga no encontrada"));
        Genero genero = dto.getGenero();

        PacientesEntity NuevoPaciente = PacienteMapper.toEntity(dto, nutriologasEntity, genero);
        return PacienteMapper.toDtoGet(pacienteRepository.save(NuevoPaciente));
    }

    @Transactional
    public void updatePatient(Long id, PacienteUpdateDTO dto) {

        PacientesEntity entity = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient no encontrado"));
        PacienteMapper.updatePaciente(dto, entity);
        //usando el @transaccional ya no uso el save "Dirty checking"

    }


    //@PathVariable
    @Transactional
    public  void desactivarPaciente(Long id) {

        PacientesEntity pacientesEntity = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        pacientesEntity.setActivo(false);
        log.info("Paciente con ID {} desactivado", id);

    }


}
