package br.edu.ibmec.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
}
