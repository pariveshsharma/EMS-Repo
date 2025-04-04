package com.prudential.environment.config;

import com.nimbusds.jose.shaded.gson.internal.bind.JsonTreeReader;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GrantedAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    private static final String CLAIM_RESOURCE_ACCESS = "resource_access";
    private static final String CLAIM_ROLES = "roles";
    private static final String CLAIM_REALM_ACCESS = "realm_access";
    public static final String PREFIX_RESOURCE_ACCESS = "ROLE_";
    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {
        Map<String, Object> resourceAccess = source.getClaimAsMap(CLAIM_RESOURCE_ACCESS);
        Map<String, Object> resources = resourceAccess.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()));
        Map<String, Object> result = (Map<String, Object>) resources.get("account");
        if(Objects.nonNull(resourceAccess)){
            List<String> roles = (List<String>) result.get(CLAIM_ROLES);
            if(Objects.nonNull(roles)){
                return roles.stream().map(rm->new SimpleGrantedAuthority(PREFIX_RESOURCE_ACCESS+rm)).collect(Collectors.toList());
            }
        }

        return List.of();
    }
}
