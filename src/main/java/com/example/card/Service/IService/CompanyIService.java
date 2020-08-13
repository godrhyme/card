package com.example.card.Service.IService;

import com.example.card.Vo.CompanyVo;

public interface CompanyIService {

    //创建公司
    Object company_creat(CompanyVo companyVo);

    //修改公司信息
    Object company_change(CompanyVo companyVo);

    //删除公司
    Object company_delete(Long cid);

    //查询公司
    Object company_search(String name);

    Object company_search(Long cid);

    //申请加入公司
    Object company_apply(Long uid,Long cid);

    //同意加入公司
    Object company_join(Long uid,Long cid);

    //拒绝加入公司
    Object company_disagree(Long uid,Long cid);

    //退出公司
    Object company_exit(Long uid,Long cid);

    //查询公司表单
    Object company_card(Long cid);

    //查询公司成员
    Object company_member(Long cid);

    //查询公司申请人
    Object company_applicant(Long cid);

    //我加入的公司
    Object my_create(Long uid);

    //我创建的公司
    Object my_join(Long uid);
}
