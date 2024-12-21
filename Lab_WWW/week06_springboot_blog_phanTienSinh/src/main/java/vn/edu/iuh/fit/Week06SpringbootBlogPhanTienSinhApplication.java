package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.backend.models.Post;
import vn.edu.iuh.fit.backend.models.PostComment;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.repositories.PostCommentRepository;
import vn.edu.iuh.fit.backend.repositories.PostRepository;
import vn.edu.iuh.fit.backend.repositories.UserRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = "vn.edu.iuh.fit")
public class Week06SpringbootBlogPhanTienSinhApplication  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Week06SpringbootBlogPhanTienSinhApplication.class, args);
    }


//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//            List<User> users = new ArrayList<>();
//            for(int i = 0; i < 10; i++) {
//                User user = new User();
//                user.setFirstName("User" + i);
//                user.setMiddleName("Middle" + i);
//                user.setLastName("Test" + i);
//                user.setEmail("user" + i + "@test.com");
//                user.setMobile("123456789" + i);
//                user.setPasswordHash("password" + i);
//                user.setRegisteredAt(Instant.now());
//                user.setLastLogin(Instant.now());
//                user.setIntro("Hello, I am user " + i);
//                user.setProfile("This is profile of user " + i);
//                users.add(user);
//            }
//
//            // Save all users
//            users.forEach(user -> userRepository.save(user));
//
//            // Create and save posts for each user
//            users.forEach(user -> {
//                for(int i = 0; i < 2; i++) {
//                    Post post = new Post();
//                    post.setAuthor(user);
//                    post.setTitle("Post " + i + " by " + user.getFirstName());
//                    post.setMetaTitle("Meta Title " + i);
//                    post.setSummary("Summary of post " + i);
//                    post.setPublished(true);
//                    post.setCreatedAt(Instant.now());
//                    post.setContent("Content of post " + i);
//                    Post savedPost = postRepository.save(post);
//
//                    // Create comments for each post
//                    for(int j = 0; j < 2; j++) {
//                        PostComment comment = new PostComment();
//                        comment.setPost(savedPost);
//                        comment.setUser(user);
//                        comment.setTitle("Comment " + j + " on post " + i);
//                        comment.setPublished(true);
//                        comment.setCreatedAt(Instant.now());
//                        comment.setContent("This is comment " + j + " content");
//                        postCommentRepository.save(comment);
//                    }
//                }
//            });
//        };
//    }

}
