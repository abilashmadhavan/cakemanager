package com.waracle.cakemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waracle.cakemanager.domain.model.Cake;

/**
 * 
 * The repository layer for Cake entity
 * 
 * @author Abilash
 *
 */
public interface CakeRepository extends JpaRepository<Cake, Long> {

}
