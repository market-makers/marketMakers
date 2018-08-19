package com.marketMakers.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.marketMakers.model.UserPromotion;

public interface UserPromotionRepository extends CrudRepository<UserPromotion, String> {

	List<UserPromotion> findByUserId(String id);
}
