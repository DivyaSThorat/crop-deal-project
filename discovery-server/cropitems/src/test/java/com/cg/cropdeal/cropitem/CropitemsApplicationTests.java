package com.cg.cropdeal.cropitem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

//import org.apache.commons.math.stat.descriptive.summary.Product;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cropdeal.cropitem.model.cropItem;
import com.cg.cropdeal.cropitem.repository.cropItemRepository;

@SpringBootTest
class CropItemApplicationTests {
	@Autowired
	cropItemRepository cropitemRepository;
	
	@Test
	@Order(1)
	public void testCreate () {
		cropItem c = new cropItem();
		c.setCropid(1L);
		c.setCropname("Jackfruit");
		c.setCroptype("Fruit");
		c.setCropqnt("1000kg");
		c.setCropprice("100.00");
		cropitemRepository.save(c);
		assertNotNull(cropitemRepository.findById(1L).get());
	}
		
	@Test
	@Order(2)
	public void testReadAll () {
		List list = cropitemRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
		
	@Test
	@Order(3)
	public void testRead () {
		cropItem cropitem = cropitemRepository.findById(1L).get();
		assertEquals("Jackfruit", cropitem.getCropname());
	}
		
	@Test
	@Order(4)
	public void testUpdate () {
		cropItem c = cropitemRepository.findById(1L).get();
		c.setCropprice("800.00");
		cropitemRepository.save(c);
		assertNotEquals(700.00, cropitemRepository.findById(1L).get().getCropprice());
	}
		
	@Test
	@Order(5)
	public void testDelete () {
		cropitemRepository.deleteById(1L);
		assertThat(cropitemRepository.existsById(1L)).isFalse();
	}

}
