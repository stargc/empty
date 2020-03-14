package com.ehualu.data.business.addr.service;

import com.ehualu.data.business.addr.dao.AddrInfoMapper;
import com.ehualu.data.business.addr.model.AddrInfo;
import com.ehualu.data.business.addr.model.AddrInfoExample;
import com.ehualu.data.business.addr.model.AddrInfoReq;
import com.ehualu.data.business.addr.model.AddrInfoResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author created by guanchen on 2020/3/12 20:01
 */
@Service
public class AddrInfoService {

    @Autowired
    private AddrInfoMapper addrInfoMapper;
    private Logger logger = LoggerFactory.getLogger(AddrInfoService.class);

    public List<AddrInfo> searchByAddr(AddrInfo info){
        AddrInfoExample example = new AddrInfoExample();
        example.createCriteria().andTownCodeEqualTo(info.getTownCode())
                .andAreaCodeEqualTo(info.getAreaCode())
                .andHouseNameEqualTo(info.getHouseName())
                .andAddrNameEqualTo(info.getAddrName());

        return addrInfoMapper.selectByExample(example);
    }

    public String add(AddrInfo info){
        String addrID = UUID.randomUUID().toString().replaceAll("-","");
        info.setAddrId(addrID);
        info.setCreateTime(new Date());
        addrInfoMapper.insertSelective(info);

        return addrID;
    }

    public AddrInfoResp searchRecentAddr(AddrInfoReq addrInfoReq){
    	logger.info("do AddrInfoReq ：" + addrInfoReq + " , " + addrInfoReq.getCreateUserId());

    	AddrInfoExample addrInfoExample = new AddrInfoExample();
    	addrInfoExample.createCriteria().andCreateUserIdEqualTo(addrInfoReq.getCreateUserId());
    	addrInfoExample.setOrderByClause("create_time DESC");
        List<AddrInfo> addrInfoList = addrInfoMapper.selectByExample(addrInfoExample);
        AddrInfoResp addrInfoResp = new AddrInfoResp();
        if(addrInfoList!=null && addrInfoList.size()>0) {
        	addrInfoResp = new AddrInfoResp(addrInfoList.get(0));
        }
        return addrInfoResp;
    }

    public AddrInfo searchById(String addrId){
        AddrInfoExample example = new AddrInfoExample();
        example.createCriteria().andAddrIdEqualTo(addrId);
        List<AddrInfo> addrInfoList = addrInfoMapper.selectByExample(example);
        if (addrInfoList.isEmpty()){
            return null;
        }
        return addrInfoList.get(0);
    }

    public boolean update(AddrInfo info){
        AddrInfoExample example = new AddrInfoExample();
        example.createCriteria().andAddrIdEqualTo(info.getAddrId());
        info.setUpdateTime(new Date());
        return addrInfoMapper.updateByExampleSelective(info,example) > 0;
    }
}
