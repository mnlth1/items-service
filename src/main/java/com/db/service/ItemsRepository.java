/**
 * 
 */
package com.db.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.model.Items;

/**
 * @author Lalitha
 *
 */
public interface ItemsRepository extends JpaRepository<Items, Long> {
	
	Items findItem(Long itemId);

}
