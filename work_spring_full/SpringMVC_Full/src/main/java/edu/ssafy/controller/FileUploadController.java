package edu.ssafy.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileUploadController {
	@RequestMapping("/uploadForm")
	public void flieUploadForm() {}
	
	@RequestMapping("/fileupload")
	public String fileUpload(HttpServletRequest req,  Model m)  {
		// file upload coding
		String path = "c://fileup";
		MultipartHttpServletRequest mhsr =  (MultipartHttpServletRequest) req;
		Iterator<String> iter = mhsr.getFileNames();
		ArrayList<Map> list = new ArrayList();
		
		File dir = new File(path);
		if(!dir.isDirectory()) {
			dir.mkdirs();
		}
		String fieldName = "";
		while(iter.hasNext()) {
			fieldName = iter.next();
			MultipartFile mfile = mhsr.getFile(fieldName);
			
			// 한글깨짐처리
			String fileName;
			try {
				fileName = new String(mfile.getOriginalFilename().getBytes("8859_1"),"UTF-8");
				// 파일이 없는 경우 처리
				if("".equals(fileName)) {
					continue;
				}
				File serverFile = new File(path+File.separator+fileName);
				System.out.println(path+File.separator+fileName);
				mfile.transferTo(serverFile);
				
				Map map = new HashMap();
				map.put("serverFile", serverFile);
				list.add(map);
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "index";
	}
}
