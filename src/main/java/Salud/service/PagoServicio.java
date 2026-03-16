package Salud.service;

import Salud.dtos.Pago.PagoGetDTO;
import Salud.dtos.Pago.PagoPostDTO;
import Salud.entity.*;
import Salud.mapper.PagoMapper;
import Salud.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

public class PagoServicio {

    @Autowired
    private PagoRepository  pagoRepository;
    @Autowired
    private CitaRepository CitaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public PagoGetDTO consultaPago(Long idPago){
        PagosEntity pago = pagoRepository.findById(idPago).orElseThrow(()->new IllegalArgumentException("El pago no existe"));
        return PagoMapper.toDto(pago);
    }

    public PagoGetDTO nuevoPago(PagoPostDTO dto) {

        if(dto != null){}

        PacientesEntity pacientes = pacienteRepository.findById(dto.getIdPaciente()).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        CitasEntity tipo = CitaRepository.findById(dto.getIdCita()).orElseThrow(() -> new RuntimeException("No se encontro la cita"));

        PagosEntity nuevoPago = PagoMapper.toEntity(dto, pacientes, tipo);

        return PagoMapper.toDto(pagoRepository.save(nuevoPago));

    }
}
