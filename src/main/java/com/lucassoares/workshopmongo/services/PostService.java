package com.lucassoares.workshopmongo.services;

import com.lucassoares.workshopmongo.domain.Post;
import com.lucassoares.workshopmongo.domain.User;
import com.lucassoares.workshopmongo.dto.UserDTO;
import com.lucassoares.workshopmongo.repository.PostRepository;
import com.lucassoares.workshopmongo.repository.UserRepository;
import com.lucassoares.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }
}
