package br.com.template.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class UserAuthentication implements Authentication {


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return null;}

    @Override
    @JsonProperty
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    @JsonProperty
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {}

    @Override
    @JsonProperty
    public String getName() {
        return null;
    }
}
