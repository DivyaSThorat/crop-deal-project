package com.cg.cropdeal.cropitems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cropdeal.cropitems.model.Cropitem;

public interface CropitemRepository extends JpaRepository<Cropitem, Long> {

}
