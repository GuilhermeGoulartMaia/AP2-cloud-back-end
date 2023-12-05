package br.edu.ibmec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ibmec.model.Comment;
import br.edu.ibmec.model.Post;
import br.edu.ibmec.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    CommentRepository repository;

    @Autowired PostService postService;

    public List<Comment> findAll() {
        return this.repository.findAll();
    }

    public Optional<Comment> findById(long id) {
        return this.repository.findById(id);
    }

    public void delete(long id) throws Exception{
        Optional<Comment> opPost=this.repository.findById(id);
        
        if (opPost.isPresent()==false){
            throw new Exception("nao encontrei o post");
        }
        this.repository.delete(opPost.get());
    }


    public Comment update(long id, Comment newData) throws Exception{
        Optional<Comment> opComment = this.repository.findById(id);

        if(opComment.isPresent()==false){
            throw new Exception("Commentario nao encontrado");
        }
        Comment comment = opComment.get();
        comment.setAutor(newData.getAutor());
        comment.setText(newData.getText());
        comment.setDtCommentario(newData.getDtComentario());

        this.repository.save(comment);
        return comment;
    }

    public Comment save(long idPost, Comment item) throws Exception {
        Optional<Post> opPost = this.postService.getById(idPost);

        if(opPost.isPresent()==false)
            throw new Exception("Post nao encontrado");

        Post post = opPost.get();
        item.setPost(post);

        this.repository.save(item);
        

        return item;
    }
    
}
