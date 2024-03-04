package com.group.libraryapp.dto.user.request;

import lombok.Getter;

@Getter
public class UserCreateRequest {
    private String name;
    private Integer age; //null을 표현할 수 있기 때문에 Integer.
}
