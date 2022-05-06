package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.entity.Role;
import by.skopinau.rescue.hr.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleServiceSpring extends BaseServiceSpring<Role> {

    @Autowired
    public RoleServiceSpring(RoleRepository roleRepository) {
        super(roleRepository);
    }

    public List<String> getRoles(Collection<? extends GrantedAuthority> grantedAuthorities) {
        return grantedAuthorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }
}