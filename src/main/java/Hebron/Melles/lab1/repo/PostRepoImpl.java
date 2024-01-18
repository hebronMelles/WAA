package Hebron.Melles.lab1.repo;

import Hebron.Melles.lab1.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo{
    private static List<Post> posts;

    static  {
    posts = new ArrayList<>();
        posts.add(new Post(123,"java","Spring","Hebron"));
        posts.add(new Post(223,"JavaScript","Constructor","Melles"));
        posts.add(new Post(333,"Python","Model","Genet"));

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
