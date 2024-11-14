package com.k1fl1k.mvcarchitecture.service;

import com.k1fl1k.mvcarchitecture.dto.PostDTO;
import com.k1fl1k.mvcarchitecture.mapper.PostMapper;
import com.k1fl1k.mvcarchitecture.model.Post;
import com.k1fl1k.mvcarchitecture.repository.PostRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public List<PostDTO> getAllPosts(int page) {
        return postRepository.findAll(page, 10).stream()
            .map(postMapper::toDTO)
            .collect(Collectors.toList());
    }

    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        return post != null ? postMapper.toDTO(post) : null;
    }

    public PostDTO createOrUpdatePost(PostDTO postDTO) {
        Post post = postMapper.toEntity(postDTO);
        return postMapper.toDTO(postRepository.save(post));
    }

    public void deletePost(Long id) {
        postRepository.delete(id);
    }
}