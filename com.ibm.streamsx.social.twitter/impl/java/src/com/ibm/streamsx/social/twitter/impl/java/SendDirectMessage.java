/* Copyright (C) 2016, International Business Machines Corporation  */
/* All Rights Reserved                                              */

package com.ibm.streamsx.social.twitter;

import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * SendDirectMessage class
 */
public class SendDirectMessage
{

	protected Twitter twitter = null;
	
	/**
	 * initialize a new TwitterFactory and set the Consumer Credentials 
	 * @param consumerKey
	 * @param consumerSecret
	 * @param accessToken
	 * @param accessTokenSecret
	 * @throws Exception
	 */
	public void initialize(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret)
			throws Exception
	{

		TwitterFactory twitterFactory = new TwitterFactory();
		// Instantiate a new Twitter instance
		twitter = twitterFactory.getInstance();

		// setup OAuth Consumer Credentials
		twitter.setOAuthConsumer(consumerKey, consumerSecret);

		// setup OAuth Access Token
		twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));

	}

	/**
	 * Send a message via twitter4j.DirectMessage
	 * @param recipient
	 * @param message
	 * @return Result
	 * @throws Exception
	 */
	public String sendMessage(String recipient, String message) throws Exception
	{
		String result = "";
		try
		{
			DirectMessage directMessage = twitter.sendDirectMessage(recipient, message);
			result = "Direct message successfully sent this message \" " + message + " \" from "
					+ directMessage.getSenderScreenName() + " to " + recipient;
		} catch (TwitterException te)
		{
			te.printStackTrace();
			result = "Failed to send a direct message to : + " + recipient + " " + te.getMessage();
		}

		return result;

	}

	/**
	 * Release twitter profile
	 * @throws Exception
	 */
	public void disconnect() throws Exception
	{
		try
		{
			twitter.removeProfileBanner();
		} catch (TwitterException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
