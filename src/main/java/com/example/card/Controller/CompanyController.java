package com.example.card.Controller;

import com.example.card.Service.CompanyService;
import com.example.card.Service.UserService;
import com.example.card.Vo.CompanyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/company")
@RestController
public class CompanyController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @PostMapping("/creat")
    Object company_creat(CompanyVo companyVo) {
        return companyService.company_creat(companyVo);
    }

    @PostMapping("/change")
    Object company_change(CompanyVo companyVo, Long cid) {
        return companyService.company_change(companyVo,cid);
    }

    @DeleteMapping("/delete/{cid}")
    Object company_delete(Long cid) {
        return companyService.company_delete(cid);
    }

    @GetMapping("/search")
    Object compay_search(String name) {
        return companyService.company_search(name);
    }

    @GetMapping("/search2")
    Object compay_search(Long cid) {
        return companyService.company_search(cid);
    }

    @GetMapping("/join")
    Object company_join(Long uid, Long cid) {
        return companyService.company_join(uid,cid);
    }

    @GetMapping("/exit")
    Object company_exit(Long uid, Long cid) {
        return companyService.company_exit(uid,cid);
    }

    @GetMapping("/card")
    Object company_card(Long cid) {
        return companyService.company_card(cid);
    }


}
