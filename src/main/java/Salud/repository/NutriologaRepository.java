package Salud.repository;

import Salud.entity.NutriologasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NutriologaRepository extends JpaRepository<NutriologasEntity, Long> {

    Optional<NutriologasEntity> findByCorreo(String correo);

}
