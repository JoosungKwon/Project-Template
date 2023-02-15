package com.prgrms.demotemplate.domain.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prgrms.demotemplate.domain.user.dto.UserResponse;
import com.prgrms.demotemplate.domain.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(source = "user.name", target = "name")
	UserResponse.UserProfile toUserProfile(User user);

}
