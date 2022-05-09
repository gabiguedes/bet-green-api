package br.com.guedes.betgreen.security.jwt;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("dashboard")
public class DashboardResource {

    @Inject
    JsonWebToken token;

    @Inject
    @Claim(standard = Claims.sub)
    String sub;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String methodname() {
        System.out.println("--------------------------------------------");
        System.out.println(token.getRawToken());
        System.out.println(sub);
        return "dashboard acess";
    }
}
