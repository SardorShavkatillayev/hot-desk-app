//package com.example.hotdesk.user.role.entity;
//
//import com.example.hotdesk.user.role.permission.Permission;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.util.List;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Entity
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(unique = true)
//    private String name;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "role_permission",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "permission_id")
//    )
//    private List<Permission> permissions;
//
//}
