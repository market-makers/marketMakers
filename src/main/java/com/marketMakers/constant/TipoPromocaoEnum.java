package com.marketMakers.constant;

public enum TipoPromocaoEnum {
	
	DESCONTO("DESCONTO"),
	CUPOM("CUPOM");
	
	private String desc;
	
	private TipoPromocaoEnum(String desc){
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
}
