package rs.raf.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.apache.commons.codec.digest.DigestUtils;
import rs.raf.HelloApplication;
import rs.raf.entities.User;
import rs.raf.repositories.user.DBUserRepo;

import javax.inject.Inject;
import java.util.Date;

public class UserService {
    @Inject
    DBUserRepo userRepo;

    public String login(String username, String password) {
        String hashedPassword = DigestUtils.sha256Hex(password);

        User user = this.userRepo.findUser(username);
        if (user == null || !user.getHashedPassword().equals(hashedPassword)) {
            return null;
        }

        Date issuedAt = new Date();
        Date expiresAt = new Date(issuedAt.getTime() + 24 * 60 * 60 * 1000);

        Algorithm algorithm = Algorithm.HMAC256(HelloApplication.getSecret());

        return JWT.create()
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .withSubject(username)
                .withClaim("name", user.getName())
                .sign(algorithm);
    }

    public boolean isAuthorized(String token){
        Algorithm algorithm = Algorithm.HMAC256(HelloApplication.getSecret());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);

        //String username = jwt.getSubject();

        //User user = this.userRepository.findUser(username);

        //if (user == null){
        //    return false;
        //}

        return jwt.getSignature().equals(HelloApplication.getSecret());
    }


}
