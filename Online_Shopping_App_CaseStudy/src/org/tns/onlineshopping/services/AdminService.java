package org.tns.onlineshopping.services;

import java.util.ArrayList;
import java.util.List;

import org.tns.onlineshopping.entities.Admin;

public class AdminService {
	private List<Admin> adminList;

	public AdminService() {
		this.adminList = new ArrayList<>();
	}

	public List<Admin> getAdmins(){
		return adminList;
	}
	
	public void addAdmin(Admin admin) {
        adminList.add(admin);
    }
	
}
