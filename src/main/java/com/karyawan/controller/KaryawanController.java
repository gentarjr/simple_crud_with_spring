package com.karyawan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.karyawan.entity.ModelKaryawan;
import com.karyawan.service.ServiceKaryawan;

@Controller
public class KaryawanController {

	@Autowired
	private ServiceKaryawan service;

	@GetMapping("/index")
	public String list(Model model) {
		Page<ModelKaryawan> data = service.listAllKaryawan();
		List<ModelKaryawan> list = data.getContent();
		model.addAttribute("list_karyawan", list);
		return "data/index";
	}

	@GetMapping("/index/create")
	public String create(Model model) {
		model.addAttribute("employee", new ModelKaryawan());
		return "/data/insert-data";
	}

	@PostMapping("/index/create")
	public String create(Model model, @ModelAttribute("employee") ModelKaryawan employee) {
		service.save(employee);
		return "redirect:/index";
	}

	@GetMapping("/index/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long idKaryawan) {
		ModelKaryawan data = service.getKaryawan(idKaryawan);
		service.delete(data);
		return "redirect:/index";
	}

	@GetMapping("/index/edit/{id}")
	public String edit(Model mode, @PathVariable("id") Long idKaryawan) {
		ModelKaryawan data = service.getKaryawan(idKaryawan);
		mode.addAttribute("employee", data);
		return "data/edit-data";
	}

	@PostMapping("/index/edit")
	public String edit(Model model, @ModelAttribute("employee") ModelKaryawan data) {
		service.save(data);
		return "redirect:/index";
	}
}
