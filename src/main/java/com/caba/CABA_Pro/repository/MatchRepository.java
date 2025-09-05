package com.caba.CABA_Pro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.caba.CABA_Pro.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    // 🔹 Método usando Spring Data JPA (sin necesidad de consulta nativa)
    // List<Match> findByMatchIdOrderByFechaDesc(Long pacienteId);

    // 🔹 Otra forma con Spring Data JPA: trae solo la última medición
    // Optional<Medicion> findFirstByPacienteIdOrderByFechaDesc(Long pacienteId);

    // 🔹 Consulta nativa para mayor control
    @Query(value = "SELECT * FROM match WHERE match_id = :pacienteId ORDER BY fecha DESC LIMIT 1", nativeQuery = true)
    Optional<Match> findLastMedicionByPacienteId(@Param("pacienteId") Long pacienteId);
}
