package controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@RequestMapping("fileUploadForm.do")
	public String fileUploadForm() {
		return "fileUploadForm";
	}
	//1.라이브러리 등록 (pom.xml) 
	//2.멀티파트리졸버 등록 (dispatcher-servlet.xml)
	//3.화면제공 (jsp만들기 form은 post방식만 가능, enctype="multipart/form-data")
	//4.컨트롤러 (파라미터로 MultipartFile (input type="file" name="attached_file") name 가져오기
	@RequestMapping("fileUpload.do")
	public String fileUpload(@RequestParam("attached_file") MultipartFile attached_file) {
		System.out.println(attached_file.getOriginalFilename());
		System.out.println(attached_file.getSize());
		//파일을 원하는 위치에 저장시키기  "원하는경로user/ssafy..."
		//디폴트값은 현재 spring tool suite 실행파일 있는 곳 
		File file = new File(attached_file.getOriginalFilename());
		
		try {
			attached_file.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "redirect:fileUploadForm.do";
	}
}
