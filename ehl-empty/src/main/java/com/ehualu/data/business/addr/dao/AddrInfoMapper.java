package com.ehualu.data.business.addr.dao;

import com.ehualu.data.business.addr.model.AddrInfo;
import com.ehualu.data.business.addr.model.AddrInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddrInfoMapper {
    int countByExample(AddrInfoExample example);

    int deleteByExample(AddrInfoExample example);

    int insert(AddrInfo record);

    int insertSelective(AddrInfo record);

    List<AddrInfo> selectByExample(AddrInfoExample example);

    int updateByExampleSelective(@Param("record") AddrInfo record, @Param("example") AddrInfoExample example);

    int updateByExample(@Param("record") AddrInfo record, @Param("example") AddrInfoExample example);
}