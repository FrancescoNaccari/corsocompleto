package nextDevs.esercizio.service;


import com.cloudinary.Cloudinary;
import nextDevs.esercizio.dto.BlogPostDto;
import nextDevs.esercizio.exception.AutoreNonTrovatoException;
import nextDevs.esercizio.exception.BlogPostNonTrovatoException;
import nextDevs.esercizio.model.Autore;
import nextDevs.esercizio.model.BlogPost;
import nextDevs.esercizio.repository.AutoreRepository;
import nextDevs.esercizio.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Collections;
import java.util.Optional;


@Service
public class BlogPostService {
    @Autowired
  private BlogPostRepository blogPostRepository;
    @Autowired
    private AutoreRepository autoreRepository;
    @Autowired
    private Cloudinary cloudinary ;





    public String saveBlogPost(BlogPostDto blogPostDto) {
    BlogPost blogPost = new BlogPost();
    blogPost.setTitolo(blogPostDto.getTitolo());
    blogPost.setContenuto(blogPostDto.getContenuto());
    blogPost.setCategoria(blogPostDto.getCategoria());
    blogPost.setTempoDiLettura(blogPostDto.getTempoDiLettura());
    blogPost.setCover("https://picsum.photos/200/300");
    blogPostRepository.save(blogPost);


    Optional<Autore> autoreOpt = autoreRepository.findById(blogPostDto.getAutoreId());
    if(autoreOpt.isPresent()){
        Autore autore = autoreOpt.get();
        blogPost.setAutore(autore);
        blogPostRepository.save(blogPost);

        return "BlogPost "+ blogPost.getId()+ "salvato con successo";
    }else {
    throw new AutoreNonTrovatoException("Autorecon id" + blogPost.getId()+"non trovata");
    }
    }

    public Optional<BlogPost> getBlogPostById(int id) {
        return blogPostRepository.findById(id);

    }

    public Page <BlogPost> getAllBlogPost( int page, int size , String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return blogPostRepository.findAll(pageable);
    }

    public BlogPost updateBlogPost(int id, BlogPostDto blogPostDto) throws BlogPostNonTrovatoException {
        Optional<BlogPost> blogPostOpt = getBlogPostById(id);

        if(blogPostOpt.isPresent()){
           BlogPost blogPost = blogPostOpt.get();

            blogPost.setTitolo(blogPostDto.getTitolo());
            blogPost.setContenuto(blogPostDto.getContenuto());
            blogPost.setCategoria(blogPostDto.getCategoria());
            blogPost.setTempoDiLettura(blogPostDto.getTempoDiLettura());

            Optional<Autore> autoreOpt = autoreRepository.findById(blogPostDto.getAutoreId());
            if(autoreOpt.isPresent()){
            Autore autore = autoreOpt.get();
            blogPost.setAutore(autore);
            blogPostRepository.save(blogPost);
            return blogPost;
        }else {
            throw new AutoreNonTrovatoException("Autore con id= " + blogPost.getId()+"non trovata");
            }
        }

    else {
        throw new BlogPostNonTrovatoException("BlogPost con id= " + id+"non trovato");
    }
}

    public String deleteBlogPost(int id) throws BlogPostNonTrovatoException {
        Optional<BlogPost> blogPostOpt = getBlogPostById(id);
        if(blogPostOpt.isPresent()){
            BlogPost blogPost = blogPostOpt.get();
            blogPostRepository.deleteById(blogPost.getId());
            return "BlogPost con id= " + blogPost.getId()+" eliminato con successo";
        }else {
            throw new BlogPostNonTrovatoException("BlogPost non trovato");
        }
    }

    public String patchCoverBlogPost(int id, MultipartFile cover) throws IOException {
        Optional<BlogPost> blogPostOpt = getBlogPostById(id);
        if (blogPostOpt.isPresent()) {

            String url = (String) cloudinary.uploader().upload(cover.getBytes(), Collections.emptyMap()).get("url");
            BlogPost blogPost= blogPostOpt.get();
            blogPost.setCover(url);
            blogPostRepository.save(blogPost);
            return "BlogPost con id" +id +" aggiornato correttamente la cover inviata";
        }else {
            throw new BlogPostNonTrovatoException("Studente non trovato");
        }

    }



}
