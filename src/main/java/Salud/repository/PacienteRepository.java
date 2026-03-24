package Salud.repository;

import Salud.entity.PacientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<PacientesEntity, Long> {

    Optional<PacientesEntity> findByCorreo(String correo);

}
