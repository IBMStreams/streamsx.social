# streamsx.twitter
This toolkit provides one Java operator to send a direct message from one Twitter account to other.

The java streams operator **TwitterSendMessage** uses the open source third party library **twitter4j** to send a direct message via twitter.



Summary of TwitterSendMessage operator
	
	Ports
		This operator has 1 input port and 0 output port.
		The input port has to specify two strings: recipient and message. 

	Parameters
		This operator supports 1 parameter. 
		propertiesFile 
		The parameter propertiesFile specifies the name of twitter property file.
		This file has to contain the following configuration parameters:
		   ConsumerKey 
		   ConsumerSecret 
		   AccessToken
		   AccessTokenSecret

	Windowing
		This operator does not accept any windowing configurations.

	Metrics
		This operator does not report any metrics.





Please perform the following steps to set up a Twitter application 
and compile the operator.    

# Create a Twitter account:
 At first you need an active Twitter account:
 https://twitter.com/new_account


# Create a Twitter application:
 - Log into Twitter Developer Site (https://dev.twitter.com/) using your Twitter credentials. 
 - Go to Tools, Manage your application and create a new application in 
   https://apps.twitter.com/
 - Fill out all mandatory fields and accept the Terms. 
 - Fill Captcha and Submit.
   Once your application is created, you can change the details of your application.
   Under the “Details” tab and “OAuth Settings”, you will find the “Consumer Key” and “Consumer Secret”.
 - Change the access level to Read, Write and Access direct messages.
   And finaly generate your Access Token
 - Copy the value of following fields in a text file twitter.property.
 
	**Consumer Key** , **Consumer Secret** , **Access Token** and **Access Token Secret**

# Download and compile the operator.
 - Download the streamsx.social-master.zip file from GitHub.
 - Unzip it on your streams system. For example in /home/streamsadmin/workspace/streamsx.twitter-master
 - mv streamsx.social-master streamsx.social
 - Edit streamsx.social/com.ibm.streamsx.social.twitter/etc/twitter.properties file and replace  
   the xxxx with your Twitter credentials.

         consumerKey=XXXXXXXXXXXXXXXXXXXXXXXXXxxxx
         consumerSecret=XXXXXXXXXXXXXXXXXXXXXXXXXX
         accessToken=XXXXXXXXX-YXXXXXXXXXXXXXXXXXX
         accessTokenSecret=XXXXXXXXXXXXXXXXXXXXXXX
     

 - Edit the sample/TwitterSendMessageTest.spl file and replace the XXXX with recipient name of your partner account.
 
   expression<rstring> $recipient : "@xxxx" ;  --> expression<rstring> $recipient : "@your-twitter-recipient" ;
 
   You can send messages only to users who are following you.
 - Download the twitter4j package from: http://twitter4j.org/archive/twitter4j-4.0.4.zip
 
   Please read carefully the license agreement and then download the twitter4j libraries.
   Twitter4J is released under Apache License 2.0.
   http://www.apache.org/licenses/LICENSE-2.0
 - Extract only the **twitter4j-core-4.0.4.jar** from **twitter4j-4.0.4.zip** and copy it in the project lib directory.

     `$ cd streamsx.twitter/lib`  
     `$ unzip -j  /downloads/twitter4j-4.0.4.zip lib/twitter4j-core-4.0.4.jar`
     

# Software requirements:
 - JAVA 1.7 and higher
 - IBM Streams 4.0.0.0 and higher
 - Apache Ant version 1.7 and higher


# Compile the toolkit and the sample with ant:

     $ cd streamsx.twitter
     $ ant


If you did all steps as described, you will get a message like this:



     [jar] Building jar: /home/streamsadmin/workspace/com.ibm.streamsx.social.twitter/impl/lib/com.ibm.streamsx.social.twitter.jar
     ....
     [exec]  [CXX-operator] CrateMessage
     [exec]  [CXX-operator] twitterSendMessage
     [exec]  [CXX-pe] pe sample.TwitterSendMessageTest-a
     [exec]  [CXX-pe] pe sample.TwitterSendMessageTest-b
     [exec]  [LD-pe] pe sample.TwitterSendMessageTest-a
     [exec]  [LD-pe] pe sample.TwitterSendMessageTest-b
     [exec]  [Bundle] sample.TwitterSendMessageTest.sab
     [echo] 
     [echo]  Now you can test the application with the following command:
     [echo]  output/bin/standalone
     
     all:
     BUILD SUCCESSFUL

     
# Test the Streams sample application
  After a successful build, it creates the jar file
  ./impl/lib/**com.ibm.streamsx.social.twitter.jar**
  and the Streams Compiler creates a standalone sample application. 
  
  Now you can check your sample application.
  Make sure you have an internet connection. 
  

     $ output/bin/standalone
     
  This sample send 2 messages  to another twitter user.
  
  In case of any problem check the Streams log files.
 
