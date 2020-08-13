package com.example.card.Service;

import com.example.card.Enity.UserEntity;
import com.example.card.Pojo.CompanyPojo;
import com.example.card.Pojo.UserPojo;
import com.example.card.Repository.CompanyDao;
import com.example.card.Repository.UserDao;
import com.example.card.Enity.CompanyEntity;
import com.example.card.Service.IService.CompanyIService;
import com.example.card.Vo.CompanyVo;
import com.example.card.status.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService implements CompanyIService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Object company_creat(CompanyVo companyVo) {
        if(companyDao.findCompanyEntityByName(companyVo.getName())!=null){
            return ResponseBody.UserHasBeenExist();
        }
        else {
            CompanyEntity companyEntity =new CompanyEntity();
            UserEntity userEntity =userDao.findUserEnityByUid(companyVo.getUid());
            companyEntity.setCreator(userEntity);
            companyEntity.setName(companyVo.getName());
            companyEntity.setLocation(companyVo.getLocation());
            companyEntity.setDescription(companyVo.getDescription());
            companyEntity.setCreator(userEntity);
            userEntity.getMy_company().add(companyEntity);

            companyDao.save(companyEntity);
            userDao.save(userEntity);
            return ResponseBody.Success(new CompanyPojo(companyEntity));
            }
    }

    @Override
    public Object company_change(CompanyVo companyVo) {
            CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(companyVo.getUid());
            companyEntity.setLocation(companyVo.getLocation());
            companyEntity.setDescription(companyVo.getDescription());
            companyDao.save(companyEntity);
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
        if (companyEntity==null){
            return ResponseBody.UserNotExist();
        }else {
            return ResponseBody.Success(new CompanyPojo(companyEntity));
        }
    }

    @Override
    public Object company_search(Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        return ResponseBody.Success(new CompanyPojo(companyEntity));
    }

    @Override
    public Object company_apply(Long uid, Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        if(companyEntity.getCreator().getUid()==uid){
            return ResponseBody.BadRequest();
        }else {
            UserEntity userEntity = userDao.findUserEnityByUid(uid);
            userEntity.getMy_apply().add(companyEntity);
            companyEntity.getApplicants().add(userEntity);
            userDao.save(userEntity);
            companyDao.save(companyEntity);
            return ResponseBody.Success();
        }
    }

    @Override
    @Transactional
    public Object company_join(Long uid, Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        UserEntity userEntity =userDao.findUserEnityByUid(uid);
        userEntity.getMy_join().add(companyEntity);
        companyEntity.getJoiners().add(userEntity);
        companyEntity.getApplicants().remove(userEntity);
        userDao.save(userEntity);
        companyDao.save(companyEntity);
        return ResponseBody.Success();
    }

    @Override
    public Object company_disagree(Long uid, Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        UserEntity userEntity =userDao.findUserEnityByUid(uid);
        userEntity.getMy_apply().remove(companyEntity);
        companyEntity.getApplicants().remove(userEntity);
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
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        List<UserPojo> list = new ArrayList<>();
        companyEntity.getJoiners().forEach(item->{{
            list.add(new UserPojo(item));}});
        return ResponseBody.Success(list);
    }

    @Override
    public Object company_applicant(Long cid) {
        CompanyEntity companyEntity = companyDao.findCompanyEntityByCid(cid);
        List<UserPojo> list = new ArrayList<>();
        companyEntity.getApplicants().forEach(item->{{
            list.add(new UserPojo(item));}});
        return ResponseBody.Success(list);
    }

    @Override
    public Object my_create(Long uid) {
        List<CompanyEntity> list=companyDao.findCompanyEntityByCreator(uid);
        List<CompanyPojo> pojos=new ArrayList<>();
        list.forEach(item->{{pojos.add(new CompanyPojo(item));}});
        return ResponseBody.Success(pojos);
    }

    @Override
    public Object my_join(Long uid) {
        UserEntity userEntity =userDao.findUserEnityByUid(uid);
        List<CompanyPojo> list=new ArrayList<>();
        userEntity.getMy_join().forEach(item->{{
            list.add(new CompanyPojo(item));
        }});
        return ResponseBody.Success(list);
    }
}
