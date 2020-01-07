package com.imooc.oa.dao;

import com.imooc.oa.entity.ClaimVoucherItem;
import org.springframework.stereotype.Repository;

import java.util.List;

//报销单条目
@Repository("claimVoucherItemDao")
public interface ClaimVoucherItemDao {
    void insert(ClaimVoucherItem claimVoucherItem);//增
    void update(ClaimVoucherItem claimVoucherItem);//改
    void delete(int id);//删
    List<ClaimVoucherItem> selectByClaimVoucher(int cvid);
}
