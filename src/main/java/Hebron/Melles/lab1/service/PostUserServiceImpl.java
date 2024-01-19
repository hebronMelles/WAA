package Hebron.Melles.lab1.service;

import Hebron.Melles.lab1.domain.Post;
import Hebron.Melles.lab1.domain.User;

import Hebron.Melles.lab1.domain.UserDto;
import Hebron.Melles.lab1.repo.PostRepo;
import Hebron.Melles.lab1.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostUserServiceImpl implements UserService,PostService{
   private final UserRepo Userrepo;
    private final PostRepo PostRepo;
    @Override
    public List<UserDto> getAllUsers() {
        return Userrepo.getAllUsers();
    }

    @Override
    public UserDto getUserById(int id) {
        return Userrepo.getUserById(id);
    }

    @Override
    public String createNewUser() {
        return Userrepo.createNewUser();
    }

    @Override
    public User getUserAndPost(int id) {
        return Userrepo.getUserAndPost(id);
    }


    @Override
    public List<Post> getAllPost() {
        return PostRepo.getAllPost();
    }

    @Override
    public Post getPostById(int id) {
        return PostRepo.getPostById(id);
    }

    @Override
    public String createNewPost() {
        return PostRepo.createNewPost();
    }

    @Override
    public Post getByAuthor(String author) {
        return PostRepo.getByAuthor(author);
    }

    @Override
    public Post getPostByText(String text) {
        return PostRepo.getPostByText(text);
    }

    @Override
    public String deleteById(int id) {
        return PostRepo.deleteById(id);
    }
}
