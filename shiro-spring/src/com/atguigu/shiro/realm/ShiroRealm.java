package com.atguigu.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroRealm extends AuthorizingRealm {

	private static final transient Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		logger.info("First realm======================");
		logger.info("shiro realm toten's hashCode:{}", token.hashCode());
		
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		
		if("unknown".equalsIgnoreCase(username)) {
			throw new UnknownAccountException("unknown username:"+username);
		}
		if("monster".equalsIgnoreCase(username)) {
			throw new LockedAccountException("I wanna kick your ass,monster,locked account,haha~~~");
		}
		
		Object credentials = null;
		if("admin".equals(username)) {
			credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
		} else if("user".equals(username)) {
			credentials = "098d2c478e9c11555ce2823231e02ec1";
		}
		
		Object principal = username;
//		Object credentials = "fc1709d0a95a6be30bc5926fdb7f22f4";
		String realmName = getName();
		
		ByteSource credentialSalt = ByteSource.Util.bytes(username);
 
		//SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo(principal,credentials,realmName);
		SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo(principal,credentials,credentialSalt, realmName);
		
		return authInfo;
	}

	public static void main(String[] args) {
		String hashAlgorithmName = "MD5";
		int hashIterations = 1024;
		Object salt = ByteSource.Util.bytes("user");
		Object credentials = "123456";
		
		SimpleHash hash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println(hash.toString());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		Object principal = principals.getPrimaryPrincipal();
		
		Set<String> roles = new HashSet<>();
		roles.add("user");
		
		if("admin".equals(principal)) {
			roles.add("admin");
		}
	
		return new SimpleAuthorizationInfo(roles);
	}

}
