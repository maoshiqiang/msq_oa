package com.imooc.oa.biz;

import com.imooc.oa.entity.ClaimVoucher;
import com.imooc.oa.entity.ClaimVoucherItem;
import com.imooc.oa.entity.DealRecord;

import java.util.List;

//声明业务处理的接口
public interface ClaimVoucherBiz {

    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);//保存报销单

    ClaimVoucher get(int id);//获取-报销单编号
    List<ClaimVoucherItem> getItems(int cvid);//获取-报销单条目
    List<DealRecord> getRecords(int cvid);//获取-报销单审核记录

    List<ClaimVoucher> getForSelf(String sn);//声明-获取个人报销单
    List<ClaimVoucher> getForDeal(String sn);//声明-获取待处理报销单

    void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);
    void submit(int id);
    void deal(DealRecord dealRecord);
}
