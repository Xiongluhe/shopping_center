package com.xiong.controller;

import com.xiong.entity.ResultData;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@Controller
@RequestMapping("/img")
public class ImageController {
	
	//文件上传到这里
	private String uploadPath = "C:/Users/Administrator/Desktop/upload";
	
	@RequestMapping("/upload")
	@ResponseBody
	public ResultData<String> upload(MultipartFile file){
		
		String filename = UUID.randomUUID().toString() + file.getOriginalFilename();
		String path = uploadPath + "/" + filename;
		
		try(
			InputStream in = file.getInputStream();
			OutputStream out = new FileOutputStream(path);
		) {
			IOUtils.copy(in, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResultData<String>().setCode(ResultData.ResultCodeList.OK).setData(path);
	}
	
//	@RequestMapping("/showImg/{img}")
	@GetMapping("/showImg/{img}")
	public void showImg(HttpServletResponse response, @PathVariable String img) {
		System.out.println(img);
		try (
			InputStream in = new FileInputStream(img);
			ServletOutputStream out = response.getOutputStream();
		){
			IOUtils.copy(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
