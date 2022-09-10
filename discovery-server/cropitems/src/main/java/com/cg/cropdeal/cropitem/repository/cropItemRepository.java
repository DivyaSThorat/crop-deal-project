package com.cg.cropdeal.cropitem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.cropdeal.cropitem.model.cropItem;

public interface cropItemRepository extends JpaRepository<cropItem, Long> {

}
