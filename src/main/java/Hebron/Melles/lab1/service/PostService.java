package Hebron.Melles.lab1.service;

import Hebron.Melles.lab1.domain.Post;
import Hebron.Melles.lab1.repo.PostRepo;

import java.util.List;

public interface PostService {
    List<Post> getAllPost();
    Post getPostById(int id);
    String createNewPost();
    Post getByAuthor(String author);
    Post getPostByText(String text);
    String deleteById(int id);
}
