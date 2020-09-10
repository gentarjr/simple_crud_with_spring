package com.karyawan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_karyawan")
public class ModelKaryawan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 20, unique = true, nullable = false)
	private Long id;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nik_karyawan", length = 8, unique = true)
	private String nik_karyawan;
	
	@Column(name = "nama_karyawan", length = 50)
	private String nama_karyawan;
	
	@Column(name = "divisi_karyawan", length = 20)
	private String divisi_karyawan;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNik_karyawan() {
		return nik_karyawan;
	}

	public void setNik_karyawan(String nik_karyawan) {
		this.nik_karyawan = nik_karyawan;
	}

	public String getNama_karyawan() {
		return nama_karyawan;
	}

	public void setNama_karyawan(String nama_karyawan) {
		this.nama_karyawan = nama_karyawan;
	}

	public String getDivisi_karyawan() {
		return divisi_karyawan;
	}

	public void setDivisi_karyawan(String divisi_karyawan) {
		this.divisi_karyawan = divisi_karyawan;
	}
}
