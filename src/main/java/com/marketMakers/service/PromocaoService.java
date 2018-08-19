package com.marketMakers.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketMakers.model.Estabelecimento;
import com.marketMakers.model.Promocao;
import com.marketMakers.repository.EstabelecimentoRepository;
import com.marketMakers.repository.PromocaoRepository;

@Service
public class PromocaoService {
	
	@Autowired
	private PromocaoRepository promocaoRepository;
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	public Iterable<Promocao> obterTodasPromocoes() {
		return promocaoRepository.findAll();
	}

	public Promocao obterPromocao(Long id) {
		return promocaoRepository.findOne(id);
	}
	
	public Promocao save(Promocao promocao) {
		promocao.setDataCriacao(new Date());
		return promocaoRepository.save(promocao);
	}

	public Promocao atualizarPromocao(Long id, Promocao promo) {
		Promocao promocao = promocaoRepository.findOne(id);
		if (promocao != null && promo != null) {
			promocao.setDataEdicao(new Date());
			promocao.setDescricao(promo.getDescricao());
			promocao.setTipo(promo.getTipo());
			promocao.setValor(promo.getValor());
			Estabelecimento estabelecimento = estabelecimentoRepository.findOne(promo.getEstabelecimento().getId());
			if (estabelecimento != null) {
				promocao.setEstabelecimento(estabelecimento);
			}
			promo = promocaoRepository.save(promocao);
		}
		return promo;
	}

	public void deletarPromocao(Long id) {
		Promocao promocao = promocaoRepository.findOne(id);
		promocaoRepository.delete(promocao);
	}

	public Estabelecimento findEstabelecimento(String id) {
		Estabelecimento estabelecimento = estabelecimentoRepository.findOne(Long.valueOf(id));
		return estabelecimento;
	}
}
