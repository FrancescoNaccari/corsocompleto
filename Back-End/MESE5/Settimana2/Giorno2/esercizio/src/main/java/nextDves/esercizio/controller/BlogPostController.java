package nextDves.esercizio.controller;

import nextDves.esercizio.exception.BlogPostNonTrovatoException;
import nextDves.esercizio.model.BlogPost;
import nextDves.esercizio.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/api/blogposts")
    public String saveBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.saveBlogPost(blogPost);
    }

    @GetMapping("/api/blogposts")
    public List<BlogPost> getAllBlogPost() {
        return blogPostService.getAllBlogPost();
    }


    @GetMapping("/api/blogposts/{id}")
    public BlogPost getBlogPostById(@PathVariable int id) throws BlogPostNonTrovatoException {
        Optional<BlogPost> blogPostOpt = blogPostService.getBlogPostById(id);
        if (blogPostOpt.isPresent()) {
            return blogPostOpt.get();
        } else {
            throw new BlogPostNonTrovatoException( "BlogPost non trovato: z " + id );
        }
    }


    @PutMapping("/api/blogposts/{id}")
    public BlogPost updateBlogPost(@PathVariable int id, @RequestBody BlogPost blogPost) throws BlogPostNonTrovatoException {
     return blogPostService.updateBlogPost(id, blogPost);
    }

    @DeleteMapping("/api/blogposts/{id}")
    public String deleteBlogPost(@PathVariable int id) throws BlogPostNonTrovatoException {
        return blogPostService.deleteBlogPost(id);
    }

}
