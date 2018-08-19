package com.marketMakers.repository;

import org.springframework.data.repository.CrudRepository;

import com.marketMakers.model.User;
import com.marketMakers.model.UserPromotion;

public interface UserPromotionRepository extends CrudRepository<UserPromotion, String> {

}
