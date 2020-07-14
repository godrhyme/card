package com.example.card.Service;

import com.example.card.Enity.UserEntity;
import com.example.card.Repository.CardtableDao;
import com.example.card.Repository.CompanyDao;
import com.example.card.Repository.UserDao;
import com.example.card.Enity.CompanyEntity;
import com.example.card.Service.IService.CompanyIService;
import com.example.card.Vo.CompanyVo;
import com.example.card.status.ResponseBody;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements CompanyIService {

    private CompanyDao companyDao;
    private UserDao userDao;
    private CardtableDao cardtableDao;

    @Override
    public Object company_creat(CompanyVo companyVo) {
        CompanyEntity companyEntity =new CompanyEntity();
        UserEntity userEntity =userDao.findUserEnityByUid(companyVo.getUid());
        companyEntity.setName(companyVo.getName());
        companyEntity.setLocation(companyVo.getLocation());
        companyEntity.setDescription(companyVo.getDescription());
        companyEntity.setUserEntity(userEntity);
        userEntity.getCompany_creat().add(companyEntity);

        companyDao.save(companyEntity);
        return ResponseBody.Success(companyEntity);
    }

    @Override
    public Object company_change(CompanyVo companyVo,Long cid) {
        CompanyEntity companyEntity = companyDao.findById(cid).get();
        companyEntity.setName(companyVo.getName());
        companyEntity.setLocation(companyVo.getLocation());
        companyEntity.setDescription(companyVo.getDescription());
        return ResponseBody.Success(companyEntity);
    }

    @Override
    public Object company_delete(Long cid) {
        companyDao.deleteById(cid);
        return ResponseBody.Success();
    }

    @Override
    public Object company_search(String name) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByName(name);
        return ResponseBody.Success(companyEntity);
    }

    @Override
    public Object company_search(Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        return ResponseBody.Success(companyEntity);
    }

    @Override
    public Object company_join(Long uid, Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        UserEntity userEntity =userDao.findUserEnityByUid(cid);
        userEntity.getCompany_join().add(companyEntity);
        companyEntity.getJoiners().add(userEntity);
        userDao.save(userEntity);
        return ResponseBody.Success();
    }

    @Override
    public Object company_exit(Long uid, Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        UserEntity userEntity =userDao.findUserEnityByUid(cid);
        companyEntity.getJoiners().remove(userEntity);
        userEntity.getCompany_join().remove(companyEntity);
        userDao.save(userEntity);
        return ResponseBody.Success();
    }

    @Override
    public Object company_card(Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        return null;
    }
}
