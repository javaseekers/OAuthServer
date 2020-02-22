package com.khatri.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
	private String clientid = "tutorialspoint";
	private String clientSecret = "tutspoints";
	private String privateKey = "-----BEGIN RSA PRIVATE KEY-----" + 
			"MIIEpAIBAAKCAQEAoDZbBoI1fRz47Fji28UVL0rnfYL2WJKkF6CSoj2bdkkX5+5y" + 
			"R5YGTW8MHv82rXrWgV3/nGCG0y9Czhk/jdq9Z4pwTTo3KoKL/YjtlgMlxzwByAen" + 
			"08xkWbuzONY6BQKD9vXJKJOP4PXhgibSOt0FnPd862rSmrGPc67ylxpBrtZLbWvH" + 
			"T7BURUoo2HlgbbawghtrKvaEnFeak4FgVDYuRaOn9Dc827xpil7ku2Rn9BIFmHeE" + 
			"TrHgar7rxCn8V3LzIykqz3muUmq+pGmDh89wGhw/T0y8gptMAvOu43bytsnyI/N1" + 
			"z+DZwOPwIRXwc9u0NxBWvuGBI4K92pxGMDzFEwIDAQABAoIBABd5v37Fp5bMnwDq" + 
			"yVsQltkWLbNrdDNoUVkQ80uIoXYEodcfTmmE5ymDgxArr1ReMn5ESsccMcVSIITY" + 
			"mEJt8eDxHSGDzT+SX3boEIAxt+Bov44S6RmU0oN/iHRkl53ST4npW+9xJ9z7ym5q" + 
			"x9VOO5tTfF92iKOYLv/xe6R+eW9nxcf1gl3BazSteStQbmAl+2iBsaashsZUE6VB" + 
			"qXu72EPLpNIUefEtgT/IvWTTymIKgkgddnvFELNLDP4eb/zrXhjyN/QjeTquMbfA" + 
			"MMx/y0GuskAE+mrsOslhZm3uxk5gYX28iS+xcEfShwfQ/DjgtOZKBq1JBA3UIaSu" + 
			"ifZXd5kCgYEA0EJoDViotNjRoL4t7qpvt1sypK0QmjrtPkpo5oVE7WDriWy/tiVh" + 
			"8OnYuf3w0opMAcPYPxoGBDVU43dzdFrAm70+YluosqnA8UOWf3SWc+EL6Fs3vX5P" + 
			"r5B7mGnlfHG/Rr8pRWtsYj5F65g1l1SOxEvRoje7SsCerGEgi+WtMy8CgYEAxPBU" + 
			"8hmw+/PFO1UWRO9H1pAnVpjRe7nD4T+Y17cTDmmBvxmFHxLtBwBjRDXV668dXaA3" + 
			"+uBIdyMo7NZJBBJ3jy+Gk7ZzZwjV1MprnsgcOjetyRytNB9xZMuAwb7tgcFibqmz" + 
			"bMR2LHXF5wqYbERAOiLGt4gyd1tXdalbWOlaY10CgYBV/iWi5Sn8Ss78Var3sq6g" + 
			"gmq97qw9UvmlT+pSzVKxxeRcAWiD2JnBdX3FBuNKvEo4LFr9a0xyrmbX6fnlYJfJ" + 
			"dvHsgTZ+V3PQ63yYMlbxkEpvbkLs3twefUVboNZedUVq/AIZpQrC4j3S0y3Fx+eP" + 
			"jFMKbYLLkg+y1AQxX+wNhwKBgQCfG9xFTORkamoqqW+4eel8PDLMD+MPJuJOlWcS" + 
			"wOIwfqVIk4GtvUiqo3GPpj8SjwQWpF8V3SYuusVRsz6Cf7kAgdEkff92evjnVjLk" + 
			"sZ+8mUdaeESnG9AtMwzveyW/81FnPsurUH55JR2isDi9H9cUIQyTMwIy1CUw9obK" + 
			"qp1QMQKBgQCjYojy6oUmIjt5Eg5H00Ra2x9DRc8h5MGrzTJpkQ+TvZkcBbOGFxQF" + 
			"QfpxmVx8U/OvsJ7dl/VNIB6D6Pss2ATg7PfJpCQX8MpnDiGW1MPe2kKJy6ExTZjF" + 
			"UGEEzvFiyu+OkMhu0602oSVw+4yv27t4MbrvglBkOzoXe76c+Ttmig==" + 
			"-----END RSA PRIVATE KEY-----";
	private String publicKey = "-----BEGIN PUBLIC KEY-----" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoDZbBoI1fRz47Fji28UV" + 
			"L0rnfYL2WJKkF6CSoj2bdkkX5+5yR5YGTW8MHv82rXrWgV3/nGCG0y9Czhk/jdq9" + 
			"Z4pwTTo3KoKL/YjtlgMlxzwByAen08xkWbuzONY6BQKD9vXJKJOP4PXhgibSOt0F" + 
			"nPd862rSmrGPc67ylxpBrtZLbWvHT7BURUoo2HlgbbawghtrKvaEnFeak4FgVDYu" + 
			"RaOn9Dc827xpil7ku2Rn9BIFmHeETrHgar7rxCn8V3LzIykqz3muUmq+pGmDh89w" + 
			"Ghw/T0y8gptMAvOu43bytsnyI/N1z+DZwOPwIRXwc9u0NxBWvuGBI4K92pxGMDzF" + 
			"EwIDAQAB" + 
			"-----END PUBLIC KEY-----";

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Autowired PasswordEncoder passwordEncoder;

	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		converter.setVerifierKey(publicKey);
		return converter;
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(tokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.inMemory().withClient(clientid).secret(clientSecret).scopes("read", "write")
//				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
//				.refreshTokenValiditySeconds(20000);
//
//	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(clientid).secret(passwordEncoder.encode(clientSecret)).scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(3600)
				.refreshTokenValiditySeconds(18000);
	}
}
