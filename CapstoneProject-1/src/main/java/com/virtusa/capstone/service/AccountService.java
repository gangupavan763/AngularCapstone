package com.virtusa.capstone.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.virtusa.capstone.model.UserModel;

@Service
public class AccountService {
	public List<String> getAllUsersAdress() {
				List<String> userAddress = List.of("Hyderabad","KarimNagar","Medak");
				return userAddress;
	}

//	public List<UserModel> getById(int id) {
//		return getAllUsersAdress().stream().filter(user -> user.getId() == id).collect(Collectors.toList());
//	}
//
//	public List<UserModel> getByName(String name) {
//		return getAllUsersAdress().stream().filter(userName -> userName.getName().startsWith(name))
//				.collect(Collectors.toList());
//	}
	
	public String saveUser(UserModel userModel) {
		
		boolean status = checkAddress(userModel.getAddress());
		if(status) {
			return "Login Successful";
		}
		else {
			return "Invalid Address";
		}
	}

	private boolean checkAddress(String address) {
		List<String> allUsersAdress = getAllUsersAdress();
		for(String user:allUsersAdress) {
			if(user.equalsIgnoreCase(address)) {
				return false;
			}
		}
		return true;
	}
}
