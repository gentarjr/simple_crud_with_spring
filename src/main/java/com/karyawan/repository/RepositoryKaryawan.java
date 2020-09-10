package com.karyawan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karyawan.entity.ModelKaryawan;

@Repository
public interface RepositoryKaryawan extends JpaRepository<ModelKaryawan, Long> {

}
