package org.killsoft.allegro;

import org.killsoft.allegro.enums.Environment;
import org.killsoft.allegro.objects.Auth;

public class AuthenticationTest {

    public static void main(String[] args) throws InterruptedException {
        Allegro allegro = new Allegro("clientId",
                "clientSecret", Environment.SANDBOX);
        Auth auth = allegro.authenticate();

        System.out.println("Token » " + auth.getToken());
        System.out.println("Token_Type » " + auth.getTokenType());
        System.out.println("Scope » " + auth.getScope());
        System.out.println("Expire Time » " + auth.getExpireTime());
    }
}
