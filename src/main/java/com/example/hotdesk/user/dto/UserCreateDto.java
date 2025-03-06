package com.example.hotdesk.user.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto extends UserBaseDto {

    @NotBlank(message = "auth.user.password.required")
    private String password;

//    private RoleCreateDto roleCreateDto;
//
//    private PermissionCreateDto permissionCreateDto;


}
