package com.marketMakers.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< Updated upstream
import com.marketMakers.model.Company;
import com.marketMakers.model.Promocao;
import com.marketMakers.repository.CompanyRepository;
=======
import com.marketMakers.model.Estabelecimento;
import com.marketMakers.model.Promotion;
import com.marketMakers.repository.EstabelecimentoRepository;
>>>>>>> Stashed changes
import com.marketMakers.repository.PromocaoRepository;

@Service
public class PromocaoService {
	
	@Autowired
	private PromocaoRepository promocaoRepository;
	@Autowired
	private CompanyRepository companyRepository;
	
	public Iterable<Promotion> obterTodasPromocoes() {
		return promocaoRepository.findAll();
	}

	public Promotion obterPromocao(Long id) {
		return promocaoRepository.findOne(id);
	}
	
	public Promotion save(Promotion promocao) {
		promocao.setDataCriacao(new Date());
		return promocaoRepository.save(promocao);
	}

	public Promotion atualizarPromocao(Long id, Promotion promo) {
		Promotion promocao = promocaoRepository.findOne(id);
		if (promocao != null && promo != null) {
			promocao.setDataEdicao(new Date());
			promocao.setDescricao(promo.getDescricao());
			promocao.setTipo(promo.getTipo());
			promocao.setValor(promo.getValor());
			Company company = companyRepository.findOne(promo.getCompany().getId());
			if (company != null) {
				promocao.setCompany(company);
			}
			promo = promocaoRepository.save(promocao);
		}
		return promo;
	}

	public void deletarPromocao(Long id) {
		Promotion promocao = promocaoRepository.findOne(id);
		promocaoRepository.delete(promocao);
	}

	public Estabelecimento findEstabelecimento(String id) {
		Estabelecimento estabelecimento = estabelecimentoRepository.findOne(Long.valueOf(id));
		return estabelecimento;
	}
}
