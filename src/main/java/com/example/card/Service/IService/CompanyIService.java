package com.example.card.Service.IService;

import com.example.card.Vo.CompanyVo;

public interface CompanyIService {

    //创建公司
    Object company_creat(CompanyVo companyVo);

    //修改公司信息
    Object company_change(CompanyVo companyVo,Long cid);

    //删除公司
    Object company_delete(Long cid);

    //查询公司
    Object company_search(String name);

    Object company_search(Long cid);

    //加入公司
    Object company_join(Long uid,Long cid);

    //退出公司
    Object company_exit(Long uid,Long cid);

    //查询公司表单
    Object company_card(Long cid);

}
