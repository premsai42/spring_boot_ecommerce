package com.prem.demo.serivce;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtToken {
    public JwtToken()
    {
        generateKey();
    }
    private String key;
    public void generateKey()
    {
        try {
            KeyGenerator kg= KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk =kg.generateKey();
            key=Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    Map<String,Object> claims=new HashMap<>();
    public String generateToken(String username) {
        Map<String,Object> claims=new HashMap<>();
        return Jwts.builder().claims().add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*60*30))
                .and().signWith(getKey()).compact();
    }

    private Key getKey() {
        byte[] arr= Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(arr);
    }

    public String extractUserName(String token) {
        return "";
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return true;
    }
}
