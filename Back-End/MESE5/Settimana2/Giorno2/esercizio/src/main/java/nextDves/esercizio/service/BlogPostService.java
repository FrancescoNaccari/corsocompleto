package nextDves.esercizio.service;

import nextDves.esercizio.exception.BlogPostNonTrovatoException;
import nextDves.esercizio.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {
    private List<BlogPost> blogPosts=new ArrayList<>();

    public Optional<BlogPost> getBlogPostById(int id){
        return blogPosts.stream()
               .filter(blogPost -> blogPost.getId() == id)
               .findFirst();
    }

    public List<BlogPost> getAllBlogPost(){
        return blogPosts;
    }

    public String saveBlogPost(BlogPost blogPost){
        blogPosts.add(blogPost);
        return "BlogPost salvato con successo: " + blogPost.getId();
    }

    public BlogPost updateBlogPost(int id, BlogPost blogPostUp) throws BlogPostNonTrovatoException  {
        Optional<BlogPost> blogPostOpt = getBlogPostById(id);
        if(blogPostOpt.isPresent()){
           BlogPost blogPost = blogPostOpt.get();
            blogPost.setTitolo(blogPostUp.getTitolo());
            blogPost.setContenuto(blogPostUp.getContenuto());
            blogPost.setCategoria(blogPostUp.getCategoria());
            blogPost.setTempoDiLettura(blogPostUp.getTempoDiLettura());
            return blogPost;
        }else {
            throw new BlogPostNonTrovatoException("BlogPost non trovato");
        }
    }

    public String deleteBlogPost(int id) throws BlogPostNonTrovatoException {
        Optional<BlogPost> blogPostOpt = getBlogPostById(id);
        if(blogPostOpt.isPresent()){
            BlogPost blogPost = blogPostOpt.get();
            blogPosts.remove(blogPost);
            return "BlogPost eliminato con successo: " + blogPost.getId();
        }else {
            throw new BlogPostNonTrovatoException("BlogPost non trovato");
        }
    }





}
