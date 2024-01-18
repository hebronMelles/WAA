package Hebron.Melles.lab1.controller;

import Hebron.Melles.lab1.domain.Post;
import Hebron.Melles.lab1.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lab1/posts")
public class PostControl {
 PostService service;

 public PostControl(PostService postService){
  this.service = postService;
 }

 @GetMapping
    List<Post> getAllPost(){
   return service.getAllPost();
    }

    @GetMapping("/{id}")
    Post getPostById(@PathVariable int id){
     return service.getPostById(id);
    }

    @PostMapping
    String createNewPost(){
    return service.createNewPost();
    }

 @GetMapping("/author")
 Post getByAuthor(@RequestParam(value = "author") String author){
return service.getByAuthor(author);
 }

@GetMapping("/author/{text}")
 public Post getPostByText(@PathVariable String text) {
  return service.getPostByText(text);
 }

@DeleteMapping("/{id}")
 public String deleteById(@PathVariable int id) {
  return service.deleteById(id);
 }
}
