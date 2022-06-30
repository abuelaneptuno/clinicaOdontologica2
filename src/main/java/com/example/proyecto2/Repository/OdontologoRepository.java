package com.example.proyecto2.Repository;

import com.example.proyecto2.entity.Odontologo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long>{

}
