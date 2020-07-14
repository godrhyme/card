package com.example.card.Repository;

import com.example.card.Enity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyDao extends JpaRepository<CompanyEntity,Long> {

    @Query(value = "select c from CompanyEntity c where c.cid=?1")
    CompanyEntity findCompanyEntityByCid(Long cid);

    @Query(value = "select c from CompanyEntity c where  c.name=?1")
    CompanyEntity findCompanyEntityByName(String name);
}
