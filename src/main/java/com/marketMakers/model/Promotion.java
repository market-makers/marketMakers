package com.marketMakers.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.marketMakers.constant.TipoPromocaoEnum;

@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Column(name = "data_edicao")
    private Date dataEdicao;

    private String descricao;
    private Double valor;

    @Enumerated
    private TipoPromocaoEnum tipo;

    @ManyToOne
    private Company company;

    public Promotion() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(Date dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoPromocaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoPromocaoEnum tipo) {
        this.tipo = tipo;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Promocao other = (Promocao) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
=======
@Table(name = "promotion")
public class Promotion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "editionDate")
    private Date editionDate;
    
    @Column(name = "description")
	private String description;
    
    @Column(name = "value")
    private Double value;
	
    @Column(name = "type")
	private String type;
	
	@ManyToOne
    @Column(name = "company")
	private Estabelecimento estabelecimento;
	
	public Promotion() {
		
	}
	
	public Promotion(String description, Double value, String type, Estabelecimento estabelecimento) {
		this.description = description;
		this.value = value;
		this.type = type;
		this.estabelecimento = estabelecimento;
	}

	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promotion other = (Promotion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
>>>>>>> Stashed changes:src/main/java/com/marketMakers/model/Promotion.java
}