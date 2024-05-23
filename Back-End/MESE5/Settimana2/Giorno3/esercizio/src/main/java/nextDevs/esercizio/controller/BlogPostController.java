package nextDevs.esercizio.controller;


import nextDevs.esercizio.dto.BlogPostDto;

import nextDevs.esercizio.exception.BadRequestException;
import nextDevs.esercizio.exception.BlogPostNonTrovatoException;
import nextDevs.esercizio.model.BlogPost;
import nextDevs.esercizio.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/blogposts")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveBlogPost(@RequestBody @Validated BlogPostDto blogPostDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage()).reduce("",((s1,s2) -> s1+s2)));
        }
        return blogPostService.saveBlogPost(blogPostDto);
    }

    @GetMapping("/blogposts")
    public Page<BlogPost> getAllBlogPost(@RequestParam (defaultValue = "0") int page,
                                         @RequestParam (defaultValue = "15") int size,
                                         @RequestParam (defaultValue = "id") String sortBy) {
        return blogPostService.getAllBlogPost( page, size, sortBy);
    }


    @GetMapping("/blogposts/{id}")
    public BlogPost getBlogPostById(@PathVariable int id) throws BlogPostNonTrovatoException {
        Optional<BlogPost> blogPostOpt = blogPostService.getBlogPostById(id);
        if (blogPostOpt.isPresent()) {
            return blogPostOpt.get();
        } else {
            throw new BlogPostNonTrovatoException( "BlogPost con id: " + id+" non trovato" );
        }
    }


    @PutMapping("/blogposts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BlogPost updateBlogPost(@PathVariable int id, @RequestBody @Validated BlogPostDto blogPostDto, BindingResult bindingResult) throws BlogPostNonTrovatoException {
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage()).reduce("",((s1,s2) -> s1+s2)));
        }
     return blogPostService.updateBlogPost(id, blogPostDto);
    }

    @DeleteMapping("/blogposts/{id}")
    public String deleteBlogPost(@PathVariable int id) throws BlogPostNonTrovatoException {
        return blogPostService.deleteBlogPost(id);
    }

    @PatchMapping ("/blogposts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String patchCoverBlogPost(@RequestBody MultipartFile cover, @PathVariable int id) throws IOException {
        return blogPostService.patchCoverBlogPost(id, cover);

    }
}
