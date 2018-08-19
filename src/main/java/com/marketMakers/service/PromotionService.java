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

    public Iterable<Promotion> obterTodasPromocoes() {
        return promotionRepository.findAll();
    }

    public Promotion obterPromocao(Long id) {
        return promotionRepository.findOne(id);
    }

    public Promotion save(Promotion promocao) {
        return promotionRepository.save(promocao);
    }

    public Promotion atualizarPromocao(Long id, Promotion promo) {
        Promotion promocao = promotionRepository.findOne(id);
        /*if (promocao != null && promo != null) {
            promocao.setDataEdicao(new Date());
            promocao.setDescricao(promo.getDescricao());
            promocao.setTipo(promo.getTipo());
            promocao.setValor(promo.getValor());
            Company company = companyRepository.findOne(promo.getCompany().getId());
            if (company != null) {
                promocao.setCompany(company);
            }
            promo = promotionRepository.save(promocao);
        }*/
        return promo;
    }

    public void deletarPromocao(Long id) {
        Promotion promocao = promotionRepository.findOne(id);
        promotionRepository.delete(promocao);
    }

    public Company findEstabelecimento(String id) {
        Company estabelecimento = companyRepository.findOne(Long.valueOf(id));
        return estabelecimento;
    }
}
