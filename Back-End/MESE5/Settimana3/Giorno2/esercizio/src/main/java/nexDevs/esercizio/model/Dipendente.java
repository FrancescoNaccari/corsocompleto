package nexDevs.esercizio.model;

import jakarta.persistence.*;
import lombok.Data;
import nexDevs.esercizio.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Dipendente implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String avatar;

    @OneToMany(mappedBy="dipendente")
    private List<Dispositivo> dispositivi;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
