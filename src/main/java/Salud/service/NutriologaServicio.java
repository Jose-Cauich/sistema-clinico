package Salud.service;

import Salud.dtos.Nutricionista.NutriologaGetDTO;
import Salud.dtos.Nutricionista.NutriologaUpdateDTO;
import Salud.dtos.Nutricionista.NutriologalPostDTO;
import Salud.entity.NutriologasEntity;
import Salud.enums.Genero;
import Salud.mapper.NutricionistaMapper;
import Salud.repository.NutriologaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class NutriologaServicio {

    @Autowired
    NutriologaRepository nutriologaRepository;

    public List<NutriologaGetDTO> obtenerTodos() {
        return nutriologaRepository.findAll().stream().map(NutricionistaMapper::toGetDto).collect(Collectors.toList());
    }

    public NutriologaGetDTO obtenerPorId(Long id) {

        NutriologasEntity nutricionista= nutriologaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutriólogo no encontrado"));
        return NutricionistaMapper.toGetDto(nutricionista);
    }

    public NutriologaGetDTO insertarNutricionista(NutriologalPostDTO dto) {

        Genero genero = dto.getGenero();
        NutriologasEntity nuevaNutriologa = NutricionistaMapper.toEntity(dto, genero);
        log.info("Nutrióloga Registrada con éxito.");
        return NutricionistaMapper.toGetDto(nutriologaRepository.save(nuevaNutriologa));
    }

    @Transactional
    public void actualizarNutricionista(Long id, NutriologaUpdateDTO dto){
        NutriologasEntity entity = nutriologaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutricionista no encontrado"));
        NutricionistaMapper.toEntity(dto, entity);
    }

    @Transactional
    public void desactivarNutricionista(Long id) {

        NutriologasEntity entity = nutriologaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutricionista no encontrado"));
        entity.setActivo(true);
    }


    }

