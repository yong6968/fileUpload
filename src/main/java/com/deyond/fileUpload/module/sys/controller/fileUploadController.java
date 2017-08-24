package com.deyond.fileUpload.module.sys.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.deyond.fileUpload.common.utils.FastdfsUtil;


@Controller
public class fileUploadController {
	
	
	/**
	 * 跳转上传页面
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/fileUpload.html", method = { RequestMethod.GET })
	public String fileUploadUI(ModelMap map, HttpServletRequest request, HttpServletResponse response)
	{
		return "fileUpload/index";
	}
	
	/**
	 * 功能:上传文件服务器
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "fileUpload.do", method = { RequestMethod.POST })
	public String fileUpload(ModelMap map, HttpServletRequest request, HttpServletResponse response)
	{
		String saveImagePath = null;
		// 获取当前运行文件在服务器上的绝对路径
    	String realPath = request.getSession().getServletContext().getRealPath("/uploadFile");
    	// 转型为MultipartHttpRequest：     
    	MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
        // 获得文件：     
        MultipartFile multipartFile = multipartRequest.getFile("media"); 
        try {
            if (multipartFile == null) {
                return "";
            }
            File pathFile = new File(realPath);
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }
            // 临时保存文件路径
            String temporaryPath = realPath + File.separator + multipartFile.getOriginalFilename();
            File tmpFile = new File(temporaryPath);
            multipartFile.transferTo(tmpFile);

            String[] uploadFile = FastdfsUtil.uploadFile(tmpFile);
            if(tmpFile.exists()){
                tmpFile.delete();
            }
            saveImagePath = FastdfsUtil.getConfValue(FastdfsUtil.IMAGE_VISIT_URL) + "/" + uploadFile[0] + "/" + uploadFile[1];
        } catch (Exception e) {
            
        }
		return saveImagePath;
	}
}
