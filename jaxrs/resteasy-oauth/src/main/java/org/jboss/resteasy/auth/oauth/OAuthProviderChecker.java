package org.jboss.resteasy.auth.oauth;

/**
 * Used to make sure the OAuthProvider implementer does not return null values.
 * If any null is returned, throws a RuntimeException
 * @author Stéphane Épardaud <stef@epardaud.fr>
 */
public class OAuthProviderChecker implements OAuthProvider {
	
	private OAuthProvider provider;

	public OAuthProviderChecker(OAuthProvider provider) {
		this.provider = provider;
	}

	private <T> T checkNull(T arg) {
		if(arg == null)
			throw new RuntimeException("OAuthProvider should not return null");
		return arg;
	}

	public OAuthConsumer getConsumer(String consumerKey) throws OAuthException {
		return checkNull(provider.getConsumer(consumerKey));
	}

	public String getRealm() {
		return checkNull(provider.getRealm());
	}

	public OAuthToken getRequestToken(String consumerKey, String requestKey)
			throws OAuthException {
		return checkNull(provider.getRequestToken(consumerKey, requestKey));
	}

	public OAuthToken getAccessToken(String consumerKey, String accessKey)
	throws OAuthException {
		return checkNull(provider.getAccessToken(consumerKey, accessKey));
	}

	public void checkTimestamp(OAuthToken token, long timestamp) throws OAuthException {
		provider.checkTimestamp(token, timestamp);
	}

	public OAuthToken makeAccessToken(String consumerKey,
			String requestKey, String verifier) throws OAuthException {
		return checkNull(provider.makeAccessToken(consumerKey, requestKey, verifier));
	}

	public OAuthToken makeRequestToken(String consumerKey, String callback)
			throws OAuthException {
		return checkNull(provider.makeRequestToken(consumerKey, callback));
	}

	public String authoriseRequestToken(String consumerKey, String requestKey)
			throws OAuthException {
		return checkNull(provider.authoriseRequestToken(consumerKey, requestKey));
	}
}
