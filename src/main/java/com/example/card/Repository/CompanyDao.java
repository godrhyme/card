package com.example.card.Repository;

import com.example.card.Enity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyDao extends JpaRepository<CompanyEntity,Long> {

    @Query(value = "select b from CompanyEntity b where b.cid=?1")
    CompanyEntity findCompanyEntityByCid(Long cid);

    @Query(value = "select b from CompanyEntity b where  b.name=?1")
    CompanyEntity findCompanyEntityByName(String name);

    @Query(value = "select b from CompanyEntity b where  b.creator.uid=?1")
    List<CompanyEntity> findCompanyEntityByCreator(Long uid);

//    @Query(value = "select b from CompanyEntity b where  b.joiners.uid=?1")
//    List<CompanyEntity> findCompanyEntityByJoiners(Long uid);


}
