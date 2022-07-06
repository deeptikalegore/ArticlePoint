package com.example.Artilce.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.Artilce.model.Article;
import com.example.Artilce.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository repo;

	public List<Article> getArticle() {
		return repo.findAll();
	}


	public Article addArticle(int aid,int uid, String title,
			String type,String content, MultipartFile image)throws IOException {
		String fileName = StringUtils.cleanPath(image.getOriginalFilename());
		Article art=new Article(aid,uid,title,type,content,fileName,new Date(System.currentTimeMillis()));
 
		String uploadDir = "src/main/resources/static/images/" + art.getAid();
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
         
        try (InputStream inputStream = image.getInputStream()) {
            Path filePath = uploadPath.resolve(art.getImage());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + art.getImage(), ioe);
        }  
        String img=uploadDir+"/"+art.getImage();
        art.setImage(img);
		return repo.save(art);
	}


	public Article deleteArticle(int id) {
		Article article=repo.findById(id).get();
		repo.deleteById(id);
		return article;
	}


	public Article updateArticle(int aid,int uid, String title,
			String type,String content, MultipartFile image) throws IOException {
		String fileName = StringUtils.cleanPath(image.getOriginalFilename());
		Article article=new Article(aid,uid,title,type,content,fileName,new Date(System.currentTimeMillis()));
		
		Optional<Article> op=repo.findById(article.getAid());
		if(!op.isPresent()) {
			throw new RuntimeException("Article with id "+ article.getAid()+ " not exist!");
		}
		Article art=op.get();
		if(article.getTitle()!=null) {
			art.setTitle(article.getTitle());
		}
		if(article.getType()!=null) {
			art.setType(article.getType());
		}
		if(article.getContent()!=null) {
			art.setContent(article.getContent());
		}
		if(article.getImage()!=null) {
			String uploadDir = "src/main/resources/static/images/" + article.getAid();
			FileUtils.forceDelete(new File(uploadDir));
	        Path uploadPath = Paths.get(uploadDir);
	        if (!Files.exists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }
	         
	        try (InputStream inputStream = image.getInputStream()) {
	        	String[] img=article.getImage().split("/");
	            Path filePath = uploadPath.resolve(img[img.length-1]);
	            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException ioe) {        
	            throw new IOException("Could not save image file: " + article.getImage(), ioe);
	        }  
	        String img=uploadDir+"/"+article.getImage();
	        art.setImage(img);
		}
		
		
		
		repo.saveAndFlush(art);
		return art;
	}

	public Article getById(int id) {
		return repo.findById(id).orElseThrow(()->new RuntimeException("Article with id"+id+"not exist"));
	}
}
