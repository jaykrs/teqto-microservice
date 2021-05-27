package com.teqto.authservice.constant;

public class AuthConstant {

	public static Integer ACCESS_TOKEN_VALIDITY_SECONDS = 300;
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
