package com.k1fl1k.mvcarchitecture.mapper;

import com.k1fl1k.mvcarchitecture.dto.PostDTO;
import com.k1fl1k.mvcarchitecture.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDTO toDTO(Post post);
    Post toEntity(PostDTO postDTO);
}
