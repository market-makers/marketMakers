package com.marketMakers.service;

import java.util.Date;
import java.util.Optional;

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

	public Optional<Promocao> obterPromocao(Long id) {
		return promocaoRepository.findById(id);
	}

	public Promocao salvarPromocao(Promocao promocao) {
		return promocaoRepository.save(promocao);
	}

	public Promocao atualizarPromocao(Long id, Promocao promo) {
		Optional<Promocao> promocao = promocaoRepository.findById(id);
		if (promocao.isPresent() && promo != null) {
			promocao.get().setDataEdicao(new Date());
			promocao.get().setDescricao(promo.getDescricao());
			promocao.get().setTipo(promo.getTipo());
			promocao.get().setValor(promo.getValor());
			//promocao.get().setEstabelecimento();
			promo = promocaoRepository.save(promocao.get());
		}
		return promo;
	}

	public void deletarPromocao(Long id) {
		Optional<Promocao> promocao = promocaoRepository.findById(id);
		promocaoRepository.delete(promocao.get());
	}
}
