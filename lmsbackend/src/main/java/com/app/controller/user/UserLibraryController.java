package com.app.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LibraryName_SerialNo_dto;
import com.app.dto.ResultDto;
import com.app.service.LibraryServiceImpl;

@RestController
@CrossOrigin("http://localhost:3060")
@RequestMapping("/user/library")
public class UserLibraryController {

	@Autowired
	public LibraryServiceImpl libraryServiceImpl;
	
	public UserLibraryController() {
		System.out.println("in constructor of"+getClass().getName());
	}

	
	@GetMapping("/get-librarys")
	public ResponseEntity<?> getLibrarys(){
		System.out.println("in getLibrarys method of "+getClass().getName());
		ResultDto result=new ResultDto("error","something went wrong");
		try {
			List<LibraryName_SerialNo_dto> object=libraryServiceImpl.GetLibrarysNameAndSerialNo();
			System.out.println(object);
			if(object!=null) {
				result.setStatus("success");
				result.setData(object);
			}
		} catch (Exception e) {
			result.setData(e.getMessage());
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok(result);
	}

}
