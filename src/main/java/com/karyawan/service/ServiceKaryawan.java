package com.karyawan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.karyawan.entity.ModelKaryawan;
import com.karyawan.repository.RepositoryKaryawan;

@Service
public class ServiceKaryawan {

	@Autowired
	private RepositoryKaryawan repo;
	
	public Page<ModelKaryawan> listAllKaryawan(){
		Pageable pageable = PageRequest.of(0, 1000);
		Page<ModelKaryawan> page = repo.findAll(pageable);
		return page;
	}
	
	public ModelKaryawan getKaryawan(Long id) {
		ModelKaryawan data = repo.findById(id).get();
		return data;
	}
	
	public void save(ModelKaryawan karyawan) {
		repo.save(karyawan);
	}
	
	public void delete(ModelKaryawan karyawan) {
		repo.delete(karyawan);
	}
}
