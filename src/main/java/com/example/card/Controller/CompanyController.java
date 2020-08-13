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

    @PostMapping("/create")
    Object company_creat(@RequestBody CompanyVo companyVo) {
        return companyService.company_creat(companyVo);
    }

    @PostMapping("/change")
    Object company_change(@RequestBody CompanyVo companyVo) {
        return companyService.company_change(companyVo);
    }

    @DeleteMapping("/delete/{cid}")
    Object company_delete(@PathVariable Long cid) {
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

    @GetMapping("/apply")
    Object company_apply( Long uid, Long cid) {
        return companyService.company_apply(uid,cid);
    }

    @GetMapping("/disagree")
    Object company_disagree( Long uid, Long cid) {
        return companyService.company_disagree(uid,cid);
    }

    @GetMapping("/join")
    Object company_join( Long uid, Long cid) {
        return companyService.company_join(uid,cid);
    }

    @GetMapping("/exit")
    Object company_exit( Long uid, Long cid) {
        return companyService.company_exit(uid,cid);
    }

    @GetMapping("/card")
    Object company_card( Long cid) {
        return companyService.company_card(cid);
    }

    @GetMapping("/my_create")
    Object my_create(Long uid) {
        return companyService.my_create(uid);
    }

    @GetMapping("/my_join")
    Object my_join(Long uid) {
        return companyService.my_join(uid);
    }

    @GetMapping("/members")
    Object company_member(Long cid) {
        return companyService.company_member(cid);
    }

    @GetMapping("/applicant")
    Object company_applicant(Long cid) {
        return companyService.company_applicant(cid);
    }

}
