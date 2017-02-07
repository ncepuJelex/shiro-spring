package com.atguigu.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecondRealm extends AuthenticatingRealm {

	private static final transient Logger logger = LoggerFactory.getLogger(SecondRealm.class);
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		logger.info("Second realm======================");
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
			credentials = "ce2f6417c7e1d32c1d81a797ee0b499f87c5de06";
		} else if("user".equals(username)) {
			credentials = "073d4c3ae812935f23cb3f2a71943f49e082a718";
		}
		
		Object principal = username;
		String realmName = getName();
		
		ByteSource credentialSalt = ByteSource.Util.bytes(username);
 
		SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo("SecondRealmName",credentials,credentialSalt, realmName);
		
		return authInfo;
	}

	public static void main(String[] args) {
		String hashAlgorithmName = "SHA1";
		int hashIterations = 1024;
		Object salt = ByteSource.Util.bytes("admin");
		Object credentials = "123456";
		
		SimpleHash hash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println(hash.toString());
	}

}
