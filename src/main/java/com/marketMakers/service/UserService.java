package com.marketMakers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketMakers.model.Promotion;
import com.marketMakers.model.User;
import com.marketMakers.model.UserPromotion;
import com.marketMakers.repository.PromotionRepository;
import com.marketMakers.repository.UserPromotionRepository;
import com.marketMakers.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    UserPromotionRepository userPromotionRepository;
    @Autowired
    PromotionRepository promotionRepository;
    

    public Iterable<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User findByUserApp(String userApp) {
        return repository.findByUserApp(userApp);
    }

	public User rescue(String userId, Long promotionId) {
		User user = repository.findByUserApp(userId);
		Promotion promotion = promotionRepository.findOne(promotionId);
		if (user != null && promotion != null) {
			Integer userDots = user.getDots();
			Integer promotionDots = promotion.getDots();
			Integer result = userDots - promotionDots;
			user.setDots(result);
			repository.save(user);
			
			UserPromotion userPromotion = new UserPromotion();
			userPromotion.setUserId(userId);
			userPromotion.setPromotionId(promotionId);
			userPromotionRepository.save(userPromotion);
			return user;
		}else {
			return null;
		}
	}
}