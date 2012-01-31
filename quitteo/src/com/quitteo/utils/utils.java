package com.quitteo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class utils {

	public static void sendFile(HttpServletResponse response, String filename, String format, File file) throws IOException {
    	response.setContentType(format);
        response.setHeader("Content-Disposition", "attachment; filename="+ filename);
		response.setContentLength((int) file.length());
        InputStream inputStream = null;
        try {
        	inputStream = new FileInputStream(file);
            IOUtils.copy(inputStream, response.getOutputStream());
        } finally {
        	IOUtils.closeQuietly(inputStream);
        }
	}
	
	public static void sendByteArray(HttpServletResponse response, String filename, String format, byte data[]) throws IOException {
    	response.setContentType(format);
        response.setHeader("Content-Disposition", "attachment; filename="+ filename);
		response.setContentLength(data.length);
        InputStream inputStream = null;
        try {
            IOUtils.write(data, response.getOutputStream());
        } finally {
        	IOUtils.closeQuietly(inputStream);
        }
	}
	
}
