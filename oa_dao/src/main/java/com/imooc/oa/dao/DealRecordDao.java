package com.imooc.oa.dao;

import com.imooc.oa.entity.DealRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

//处理记录接口，类似于日志，不能有删除功能
@Repository("dealRecordDao")
public interface DealRecordDao {
    void insert(DealRecord dealRecord);//插入
    List<DealRecord> selectByClaimVoucher(int cvid);
}
