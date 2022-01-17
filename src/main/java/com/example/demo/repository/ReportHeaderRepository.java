package com.example.demo.repository;

import com.example.demo.model.ReportHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportHeaderRepository extends JpaRepository<ReportHeader,Long> {

    List<ReportHeader> findByType( ReportHeader.TYPE type );

}
