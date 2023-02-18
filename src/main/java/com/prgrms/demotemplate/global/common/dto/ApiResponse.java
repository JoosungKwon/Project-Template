package com.prgrms.demotemplate.global.common.dto;

public record ApiResponse<T> (
	T data
){

}
