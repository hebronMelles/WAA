package Hebron.Melles.lab1.repo;

import Hebron.Melles.lab1.domain.Post;

import java.util.List;

public interface PostRepo  {
    List<Post> getAllPost();
    Post getPostById(int id);
    String createNewPost();
    Post getByAuthor(String author);
    Post getPostByText(String text);
    String deletePostById(int id);
}

