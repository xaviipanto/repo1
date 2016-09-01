package com.utilities;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

public class Download {

	public static void download(HttpServletResponse response, String fileName, byte[] byteArr, int type) throws IOException {
		String extension = "";
		if(type == Constants.EXPORT_TYPE_MSEXCEL){
			extension = ".xls";
		} else {
			extension = ".pdf";
		}
		String mimeType = "application/octet-stream";
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + fileName + extension + "\""));
		response.setContentLength((int)byteArr.length);
		InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(byteArr));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
}
