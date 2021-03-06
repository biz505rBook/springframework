package com.biz.gallery.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	@Autowired
	String filePath;
	
	public String file_up(MultipartFile mFile) {
		if(mFile == null) {
			return null;
		}
		// 폴더 객체 생성
		File dir = new File(filePath);
		if(!dir.exists()) {
			dir.mkdirs(); // mkdir. c:/bizwork/files 폴더인데 만약 bizwork폴더가 있고 files 폴더만 없을 때는 mkdir, bizwork부터 없으면 mkdirs(여러폴더생성)
		}
		String strUUID = UUID.randomUUID().toString();
		
		String originalName = mFile.getOriginalFilename();
		
		String upLoadFileName = strUUID + originalName;
		// 파일이름에 난수문자열을 붙여 중복되지 않게 처리

		// 업로드할 파일 객체를 생성
		File upLoadFile = new File(filePath, upLoadFileName);
		try {
			mFile.transferTo(upLoadFile);
			return upLoadFileName;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
