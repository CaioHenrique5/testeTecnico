package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pauta;
import com.example.demo.model.Session;
import com.example.demo.repository.associateRepository;

@Service
public class sessionService {
	
	@Autowired
	associateRepository aRepository;
	
	public void openSession(Pauta pauta) {
//		TODO
		
	}
	public String finishSession(Session session) {
		return "";
	}
}
