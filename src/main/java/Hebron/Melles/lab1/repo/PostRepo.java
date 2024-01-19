package Hebron.Melles.lab1.repo;

import Hebron.Melles.lab1.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo  {
    List<Post> getAllPost();
    Post getPostById(int id);
    String createNewPost();
    Post getByAuthor(String author);
    Post getPostByText(String text);
    String deleteById(int id);
}

