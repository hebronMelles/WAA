package Hebron.Melles.lab1.repo;

import Hebron.Melles.lab1.domain.Comment;
import Hebron.Melles.lab1.domain.Post;
import Hebron.Melles.lab1.domain.User;
import Hebron.Melles.lab1.domain.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostUserRepoImpl implements UserRepo, PostRepo,CommentRepo {
    private static List<User> users;
    private static List<Post> posts;
    private static List<UserDto> userDto;
    private static List<Comment> comments;


    static {
        comments = new ArrayList<>();
        comments.add(new Comment(100,"Hebron","this is a good Idea"));
        comments.add(new Comment(200,"Genet","I dont Like this Idea"));
        comments.add(new Comment(300,"ALem","what is going on here"));

    }

    static  {
        posts = new ArrayList<>();
        posts.add(new Post(123,"java","Spring","Sam",comments));
        posts.add(new Post(223,"JavaScript","Constructor","John",comments));
        posts.add(new Post(333,"Python","Model","Genet",comments));

    }
  static   PostRepo postRepo;

    static  {
        users= new ArrayList<>();
        users.add(new User(200,"hebron",posts));
        users.add(new User(223,"Melles",posts));
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
    public User getUsersByNumberOfPosts(int n) {
       return users.stream()
                .filter(x -> x.getPosts().size() > n).findFirst().orElse(null);
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
   public UserDto deleteUserById(int id){
        UserDto userDto1 = getUserById(id);
        User user = getUserAndPost(id);
        users.remove(user);
        userDto.remove(userDto1);
        return userDto1 ;
    }



    @Override
    public String deletePostById(int id) {
        Post post = getPostById(id);
        posts.remove(post);
        return "Successfully deleted" ;
    }



    @Override
    public String getCommentByID(int id) {
        String commment = "Name =" +comments.stream().filter(x -> x.getId() == id).findFirst().get().getName()
                +  "\n" +
                "Id number = " +
                comments.stream().filter(x -> x.getId() == id).findFirst().get().getId() +
                 "\n" +
                "Comment = " +
                comments.stream().filter(x -> x.getId() == id).findFirst().get().getComment();
        return commment;
    }

    @Override
    public String addComment(int postId, int id, String name, String comment) {
       comments.add(new Comment(id,name,comment));
        Post post = getPostById(postId);
        post.setComments(comments);
        return getCommentByID(id);
    }


}
