package com.gcs.aol.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import com.gcs.aol.dao.DoctorDAO;
import com.gcs.aol.entity.Doctor;
import com.gcs.aol.service.IDoctorManager;
import com.gcs.sysmgr.service.impl.GenericManagerImpl;

public class DoctorManagerImpl extends GenericManagerImpl<Doctor, DoctorDAO> implements IDoctorManager {

	@Autowired
	private EntityManagerFactory em;
	
	@Autowired
	private DoctorDAO doctorDAO;
	
	@Override
	public int add(Doctor doctor) throws Exception {
		
		return 0;
	}

	@Override
	public int detele(String id) throws Exception {
		return 0;
	}

	@Override
	public int modify(Doctor doctor) throws Exception {
		return 0;
	}

	@Override
	public Doctor findById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<Doctor> findAll(Doctor doctor,Integer currentPage, Integer pageSize) throws Exception {
		
		Page<Doctor> page = doctorDAO.findAll(new Specification<Doctor>() {
			@Override
			public Predicate toPredicate(Root<Doctor> root, CriteriaQuery<?> query, CriteriaBuilder build) {
				root = query.from(Doctor.class);
				Path<String> name = root.get("NAME");
				List<Predicate> redicates =  new ArrayList<Predicate>();
				
				
				Predicate[] ps = new Predicate[redicates.size()];
				return build.and(redicates.toArray(ps));
			}
		}, new PageRequest(currentPage, pageSize, new Sort(Direction.DESC, "id")));
		return page;
	}
}
