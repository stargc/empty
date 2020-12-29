package com.ehualu.data.business.template.model;

import javax.validation.constraints.NotBlank;

/**
 * @author created by gouyifan on 2020/3/13
 */
public class AddrInfoReq {
	@NotBlank(message="用户编号不能为空")
	private String createUserId;

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	
}
