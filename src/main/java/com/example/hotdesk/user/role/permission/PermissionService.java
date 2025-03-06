//package com.example.hotdesk.user.role.permission;
//
//import com.example.hotdesk.user.role.permission.dto.PermissionCreateDto;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class PermissionService {
//    private final PermissionRepozitory permissionRepozitory;
//    ModelMapper mapper = new ModelMapper();
//
//    public Permission createPermission(PermissionCreateDto createDto) {
//
//        Permission permission = mapper.map(createDto, Permission.class);
//        permission = permissionRepozitory.save(permission);
//        return permission;
//    }
//
//}
