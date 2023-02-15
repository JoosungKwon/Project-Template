package com.prgrms.demotemplate.global.security.oauth;

import static com.prgrms.demotemplate.global.security.oauth.dto.KakaoUserInfo.*;
import static lombok.AccessLevel.*;

import java.util.Objects;

import org.springframework.security.oauth2.core.user.OAuth2User;

import com.prgrms.demotemplate.global.security.oauth.dto.OauthUserInfo;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class OAuthProvider {

	public static OauthUserInfo toUserProfile(OAuth2User oauth, String providerName) {
		if (Objects.equals(providerName, "kakao")) {
			return toUserInfo(oauth);
		}
		throw new IllegalArgumentException();
	}
}