package Hebron.Melles.lab1.repo;

import Hebron.Melles.lab1.domain.Post;
import Hebron.Melles.lab1.domain.User;
import Hebron.Melles.lab1.domain.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PostUserRepoImpl implements UserRepo, PostRepo {
    private static List<User> users;
    private static List<Post> posts;
    private static List<UserDto> userDto;

    static  {
        posts = new ArrayList<>();
        posts.add(new Post(123,"java","Spring","Hebron"));
        posts.add(new Post(223,"JavaScript","Constructor","Melles"));
        posts.add(new Post(333,"Python","Model","Genet"));

    }
  static   PostRepo postRepo;

    static  {
        users= new ArrayList<>();
        users.add(new User(200,"hebron",posts));
        users.add(new User(223,"hi",posts));
       userDto = new ArrayList<>();
       userDto.add(new UserDto(users.get(0).getId(),(users.get(0).getName())));
       userDto.add(new UserDto(users.get(1).getId(),users.get(1).getName()));




    }
    @Override
    public List<UserDto> getAllUsers() {
        return userDto;
    }

    @Override
    public UserDto getUserById(int id) {
        UserDto UserByID =  userDto.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
        return UserByID;
    }

    @Override
    public String createNewUser() {
        users.add(new User());
        return "New User created and Saved";
    }

    @Override
    public User getUserAndPost(int id) {
        return users.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }


    @Override
    public List<Post> getAllPost() {
        return posts;
    }

    @Override
    public Post getPostById(int id) {
        Post postByID =  posts.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
        return postByID;
    }

    @Override
    public String createNewPost() {

        posts.add(new Post());
        return "New Post created and Saved";
    }

    @Override
    public Post getByAuthor(String author) {
        return posts.stream()
                .filter(x -> x.getAuthor().equalsIgnoreCase(author))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post getPostByText(String text) {
        Post post = posts.stream()
                .filter(x -> x.getAuthor().startsWith(text))
                .findFirst()
                .orElse(null);
        return post;
    }

    @Override
    public String deleteById(int id) {
        Post post = getPostById(id);
        posts.remove(post);
        return "Successfully deleted" ;
    }
}
