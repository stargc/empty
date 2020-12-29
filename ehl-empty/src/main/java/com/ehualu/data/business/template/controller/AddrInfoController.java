package com.ehualu.data.business.template.controller;

import com.ehualu.data.business.template.model.AddrInfoReq;
import com.ehualu.data.business.template.model.AddrInfoResp;
import com.ehualu.data.business.template.service.AddrInfoService;
import com.ehualu.data.common.model.Message;
import com.ehualu.data.common.util.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author created by gouyifan on 2020/3/13
 */
@RestController
@Validated
@RequestMapping("/addr")
public class AddrInfoController {
	
	@Autowired
	private AddrInfoService addrInfoService;
	
    @PostMapping("/_recentaddr")
    public Message<AddrInfoResp> loadRecentAddr(@RequestBody @Valid AddrInfoReq addrInfoReq) {
    	AddrInfoResp resp = addrInfoService.searchRecentAddr(addrInfoReq);
        return new MessageBuilder.Builder<AddrInfoResp>()
                .setStatus(Message.Code.OK)
                .setData(resp)
                .builder();
    }
}
