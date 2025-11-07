package com.leetjourney.spring_security_jwt.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

public class JwtUtilTest {

    private JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil();
        ReflectionTestUtils.setField(jwtUtil, "jwtSecret", "mySecretKeymySecretKeymySecretKeymySecretKey");
        ReflectionTestUtils.setField(jwtUtil, "jwtExpirationMs", 86400000);
        jwtUtil.init();
    }

    @Test
    void testGenerateToken() {
        String token = jwtUtil.generateToken("testuser");
        
        assertNotNull(token);
        assertFalse(token.isEmpty());
        assertTrue(token.split("\\.").length == 3);
    }

    @Test
    void testGetUserFromToken() {
        String username = "testuser";
        String token = jwtUtil.generateToken(username);
        
        String extractedUsername = jwtUtil.getUserFromToken(token);
        
        assertEquals(username, extractedUsername);
    }

    @Test
    void testValidateJwtToken_Valid() {
        String token = jwtUtil.generateToken("testuser");
        
        assertTrue(jwtUtil.validateJwtToken(token));
    }

    @Test
    void testValidateJwtToken_Invalid() {
        String invalidToken = "invalid.token.here";
        
        assertFalse(jwtUtil.validateJwtToken(invalidToken));
    }

    @Test
    void testValidateJwtToken_Null() {
        assertFalse(jwtUtil.validateJwtToken(null));
    }
}