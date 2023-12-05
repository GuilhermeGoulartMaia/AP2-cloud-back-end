package br.edu.ibmec.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    
}
