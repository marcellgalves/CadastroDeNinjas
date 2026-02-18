package com.github.marcellgalves.cadastroapi.repository;

import com.github.marcellgalves.cadastroapi.models.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
