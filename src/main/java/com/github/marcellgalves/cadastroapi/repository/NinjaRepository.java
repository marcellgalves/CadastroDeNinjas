package com.github.marcellgalves.cadastroapi.repository;

import com.github.marcellgalves.cadastroapi.Ninjas.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
