package com.marketMakers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketMakers.model.Promotion;
import com.marketMakers.model.User;
import com.marketMakers.repository.PromotionRepository;
import com.marketMakers.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
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
			return user;
		}else {
			return null;
		}
	}
}