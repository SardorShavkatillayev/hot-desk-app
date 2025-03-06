//package com.example.hotdesk.user.role;
//
//
//import com.example.hotdesk.user.role.dto.RoleCreateDto;
//import com.example.hotdesk.user.role.dto.RoleResponseDto;
//import com.example.hotdesk.user.role.entity.Role;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class RoleService {
//
//    private final RoleRepozitory roleRepozitory;
//    ModelMapper mapper = new ModelMapper();
//
//    public Role createRole(RoleCreateDto createDto) {
//
//        Role role = mapper.map(createDto, Role.class);
//        return roleRepozitory.save(role);
//    }
//
//
//}
