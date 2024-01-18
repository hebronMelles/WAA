package Hebron.Melles.lab1.service;

import Hebron.Melles.lab1.domain.Post;
import Hebron.Melles.lab1.repo.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
  private final   PostRepo repo;

    @Override
    public List<Post> getAllPost() {
        return repo.getAllPost();
    }

    @Override
    public Post getPostById(int id) {
        return repo.getPostById(id);
    }

    @Override
    public String createNewPost() {
       return repo.createNewPost();
    }

    @Override
    public Post getByAuthor(String author) {
        return repo.getByAuthor(author);
    }

    @Override
    public Post getPostByText(String text) {
        return repo.getPostByText(text);
    }

    @Override
    public String deleteById(int id) {
        return repo.deleteById(id);
    }
}
