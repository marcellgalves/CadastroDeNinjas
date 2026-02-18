package com.github.marcellgalves.cadastroapi.repository;

import com.github.marcellgalves.cadastroapi.models.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<MissoesModel, Long> {
}
