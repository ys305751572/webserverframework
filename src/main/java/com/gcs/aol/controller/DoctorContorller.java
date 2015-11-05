package com.gcs.aol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gcs.aol.entity.Doctor;
import com.gcs.aol.service.impl.DoctorManagerImpl;
import com.gcs.sysmgr.controller.GenericEntityController;
import com.gcs.utils.JSONResponse;

@Controller
@RequestMapping("/management/doctor/")
public class DoctorContorller extends GenericEntityController<Doctor, Doctor, DoctorManagerImpl>{

	private static final String DOCTORLIST = "management/aol/doctorMgr/doctorList"; // 医师列表页面
	private static final String DOCTORADD = "management/aol/doctorMgr/doctorAdd"; // 医师新增页面
	private static final String DOCTOREDIT = "management/aol/doctorMgr/doctorEdit"; // 医师编辑页面
	
	@RequestMapping(value = "pageAdd", method = RequestMethod.POST)
	@ResponseBody
	public String pageAdd() {
		return DOCTORADD;
	}
	
	public JSONResponse createDoctor(Doctor doctor) {
		this.getEntityManager().save(doctor);
		return successed(doctor);
	}
	
	public String pageEdit() {
		return DOCTOREDIT;
	} 
	
	public JSONResponse modifyDoctor(Doctor doctor) {
		
		return null;
	}
	
	public String pageDetail(Doctor doctor) {
		return DOCTORLIST;
	}
	
	public JSONResponse pageList(Doctor doctor) {
		return null;
	}
}
