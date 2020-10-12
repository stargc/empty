package com.example.empty.business.service.security;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.hadoop.security.authentication.server.AuthenticationToken;
import org.apache.hadoop.security.authentication.util.KerberosName;
import org.apache.tomcat.util.codec.binary.Base64;
import org.ietf.jgss.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.PrivilegedExceptionAction;

/**
 * @author created by guanchen on 2020/7/28 14:23
 */
@Service
@Slf4j
public class KerberosService {

    @SneakyThrows
    public boolean check(HttpServletRequest request, HttpServletResponse response){
        String authorization = request.getHeader("Authorization");
        if (!authorization.startsWith("Negotiate")){
            response.setHeader("WWW-Authenticate", "Negotiate");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        authorization = authorization.substring("Negotiate".length()).trim();
        final Base64 base64 = new Base64(0);
        final byte[] clientToken = base64.decode(authorization);


        AuthenticationToken token = Subject.doAs(new Subject(), (PrivilegedExceptionAction<AuthenticationToken>)new PrivilegedExceptionAction<AuthenticationToken>() {
            @Override
            public AuthenticationToken run() throws Exception {
                AuthenticationToken token = null;
                GSSContext gssContext = null;
                try {
                    GSSManager manager = GSSManager.getInstance();
                    GSSName gssName = manager.createName("HTTP/host161.ehl.com@HADOOP.COM", new Oid("1.2.840.113554.1.2.2.1"));

                    Oid oid = new Oid("1.3.6.1.5.5.2");
                    gssContext = manager.createContext(gssName.canonicalize(oid), oid, null, 0);
                    final byte[] serverToken = gssContext.acceptSecContext(clientToken, 0, clientToken.length);
                    if (serverToken != null && serverToken.length > 0) {
                        final String authenticate = base64.encodeToString(serverToken);
                        response.setHeader("WWW-Authenticate", ("Negotiate " + authenticate));
                    }
                    if (!gssContext.isEstablished()) {
                        log.info("SPNEGO in progress");
                    } else {
                        final String clientPrincipal = gssContext.getSrcName().toString();
                        final KerberosName kerberosName = new KerberosName(clientPrincipal);
                        final String userName = kerberosName.getShortName();
                        token = new AuthenticationToken(userName, clientPrincipal, "kerberos");
                        log.info("SPNEGO completed for principal.");
                    }
                }
                finally {
                    if (gssContext != null) {
                        try {
                            gssContext.dispose();
                        }
                        catch (GSSException e) {
                            log.error(ExceptionUtils.getStackTrace(e));
                        }
                    }
                }
                return token;
            }
        });

        return true;
    }
}
