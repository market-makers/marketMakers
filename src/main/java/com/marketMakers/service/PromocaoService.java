package com.marketMakers.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketMakers.model.Promocao;
import com.marketMakers.repository.PromocaoRepository;

@Service
public class PromocaoService {
	
	@Autowired
	private PromocaoRepository promocaoRepository;

	public Iterable<Promocao> obterTodasPromocoes() {
		return promocaoRepository.findAll();
	}

	public Promocao obterPromocao(Long id) {
		return promocaoRepository.findOne(id);
	}

	public Promocao salvarPromocao(Promocao promocao) {
		return promocaoRepository.save(promocao);
	}

	public Promocao atualizarPromocao(Long id, Promocao promo) {
		Promocao promocao = promocaoRepository.findOne(id);
		if (promocao != null && promo != null) {
			promocao.setDataEdicao(new Date());
			promocao.setDescricao(promo.getDescricao());
			promocao.setTipo(promo.getTipo());
			promocao.setValor(promo.getValor());
			//promocao.get().setEstabelecimento();
			promo = promocaoRepository.save(promocao);
		}
		return promo;
	}

	public void deletarPromocao(Long id) {
		Promocao promocao = promocaoRepository.findOne(id);
		promocaoRepository.delete(promocao);
	}
}
