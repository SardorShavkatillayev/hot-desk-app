package com.example.hotdesk.user.entity;

import com.example.hotdesk.desk.entity.Desk;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@Entity
@Table( name = "users" )
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails
{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    @Column( nullable = false )
    private boolean isPhoneNumberVerified=true;

    private String email;

    private String password;

//    @Enumerated( EnumType.STRING )
//    private com.example.hotdesk.enums.Role role;

    // to do eager or lazy
    @OneToMany( fetch = FetchType.LAZY )
    @JoinTable( name = "user_desks",
                joinColumns = @JoinColumn( name = "user_id" ),
                inverseJoinColumns = @JoinColumn( name = "desk_id" ) )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Desk> desks;


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {

//        Set<SimpleGrantedAuthority> authorities= new HashSet<>();
//        for (Role role:roles) {
//            for (Permission permission:role.getPermissions()){
//                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission.getCode());
//                authorities.add(authority);
//            }
//        }
//
//        return authorities;
        return Collections.emptyList();
    }

    @Override
    public String getUsername()
    {
        return phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
