package com.sort.capas.swvicaria.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String targetURL = determineTargetUrl(authentication);

        if(response.isCommitted()){ //only headers and status code are sent, not the info
            return;
        }
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request,response,targetURL);
    }

    protected String determineTargetUrl(Authentication authentication){
        String url = "login?error=true";

        //succionando el rol de la persona
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();
        for(GrantedAuthority a : authorities){
            roles.add(a.getAuthority());
        }

        //redireccionando en base al rol
        if(roles.contains("ROLE_LIDER")){
            url = "/Admin/Church";
        }
        //puede cambiar
        else if(roles.contains("ROLE_USUARIO") || roles.contains("ROLE_MIEMBRO")){
            url = "/VicariaSW/Church";
        }
        return url;
    }
}
