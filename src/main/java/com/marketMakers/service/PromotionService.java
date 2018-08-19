package com.marketMakers.service;

import com.marketMakers.model.Company;
import com.marketMakers.model.Promotion;
import com.marketMakers.repository.CompanyRepository;
import com.marketMakers.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    public Promotion getPromotion(Long id) {
        return promotionRepository.findOne(id);
    }

    public Promotion save(Promotion promocao) {
        return promotionRepository.save(promocao);
    }

    public Promotion updatePromotion(Long id, Promotion promo) {
        Promotion promocao = promotionRepository.findOne(id);
        if (promocao != null && promo != null) {
            promocao.setDescription(promo.getDescription());
            promocao.setType(promo.getType());
            promocao.setValue(promo.getValue());
            Company company = companyRepository.findOne(promo.getCompany().getId());
            if (company != null) {
                promocao.setCompany(company);
            }
            promo = promotionRepository.save(promocao);
        }
        return promo;
    }

    public void deletePromotion(Long id) {
        Promotion promocao = promotionRepository.findOne(id);
        promotionRepository.delete(promocao);
    }

    public Company findCompany(String id) {
        Company estabelecimento = companyRepository.findOne(Long.valueOf(id));
        return estabelecimento;
    }
}
