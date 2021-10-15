package com.springboottutorials.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtil {

	public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException{
		Path uploadPath = Paths.get(uploadDir);
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try(InputStream inputStream = multipartFile.getInputStream()){
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO: handle exception
			throw new IOException("Could not save image file: " + fileName, e);
		}
	}
	
	public static void deleteFile(String uploadDir, String fileName) {
		Path path = Paths.get(uploadDir);
		try {
			if (Files.exists(path)) {
				Path filePath = path.resolve(fileName);
				Files.delete(filePath);
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
