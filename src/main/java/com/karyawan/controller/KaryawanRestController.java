package com.karyawan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.karyawan.entity.ModelKaryawan;
import com.karyawan.service.ServiceKaryawan;

@RestController
public class KaryawanRestController {

	@Autowired
	ServiceKaryawan service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Home() {
		return "<center>SELAMAT DATANG DI DATA KARYAWAN</center>";
	}
	
	@RequestMapping(value = "/rest/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ModelKaryawan>> listKaryawan(){
		Page<ModelKaryawan> data = service.listAllKaryawan();
		List<ModelKaryawan> list = data.getContent();
		return new ResponseEntity<List<ModelKaryawan>>(list, HttpStatus.OK);
	}
}
