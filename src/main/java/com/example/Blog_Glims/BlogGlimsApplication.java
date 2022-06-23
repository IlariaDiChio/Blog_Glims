package com.example.Blog_Glims;

import com.example.Blog_Glims.model.Post;
import com.example.Blog_Glims.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BlogGlimsApplication implements CommandLineRunner {
	@Autowired
	PostRepository postRep;

	public static void main(String[] args) {
		SpringApplication.run(BlogGlimsApplication.class, args);
	}

	public void run(String... args) throws Exception {
		List<Post> dept = postRep.findAllPosts();
		for (Post d : dept) {
			System.out.println(d);


		}
	}
}