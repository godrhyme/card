package com.example.card.Service;

import com.example.card.Enity.UserEntity;
import com.example.card.Pojo.CompanyPojo;
import com.example.card.Repository.CardtableDao;
import com.example.card.Repository.CompanyDao;
import com.example.card.Repository.UserDao;
import com.example.card.Enity.CompanyEntity;
import com.example.card.Service.IService.CompanyIService;
import com.example.card.Vo.CompanyVo;
import com.example.card.status.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService implements CompanyIService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CardtableDao cardtableDao;

    @Override
    public Object company_creat(CompanyVo companyVo) {
        CompanyEntity companyEntity =new CompanyEntity();
        UserEntity userEntity =userDao.findUserEnityByUid(companyVo.getUid());
        companyEntity.setName(companyVo.getName());
        companyEntity.setLocation(companyVo.getLocation());
        companyEntity.setDescription(companyVo.getDescription());
        companyEntity.setCreator(userEntity);
        userEntity.getMy_company().add(companyEntity);

        companyDao.save(companyEntity);
        userDao.save(userEntity);
        return ResponseBody.Success(new CompanyPojo(companyEntity));
    }

    @Override
    public Object company_change(CompanyVo companyVo,Long cid) {
        CompanyEntity companyEntity = companyDao.findById(cid).get();
        companyEntity.setName(companyVo.getName());
        companyEntity.setLocation(companyVo.getLocation());
        companyEntity.setDescription(companyVo.getDescription());
        return ResponseBody.Success(new CompanyPojo(companyEntity));
    }

    @Override
    public Object company_delete(Long cid) {
        companyDao.deleteById(cid);
        return ResponseBody.Success();
    }

    @Override
    public Object company_search(String name) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByName(name);
        return ResponseBody.Success(new CompanyPojo(companyEntity));
    }

    @Override
    public Object company_search(Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        return ResponseBody.Success(new CompanyPojo(companyEntity));
    }

    @Override
    @Transactional
    public Object company_join(Long uid, Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        UserEntity userEntity =userDao.findUserEnityByUid(uid);
        userEntity.getMy_company().add(companyEntity);
        companyEntity.getJoiners().add(userEntity);
        userDao.save(userEntity);
        companyDao.save(companyEntity);
        return ResponseBody.Success();
    }

    @Override
    public Object company_exit(Long uid, Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        UserEntity userEntity =userDao.findUserEnityByUid(uid);
        companyEntity.getJoiners().remove(userEntity);
        userEntity.getMy_company().remove(companyEntity);
        userDao.save(userEntity);
        companyDao.save(companyEntity);
        return ResponseBody.Success();
    }

    @Override
    public Object company_card(Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        return null;
    }

    @Override
    public Object company_member(Long cid) {
        return null;
    }
}
