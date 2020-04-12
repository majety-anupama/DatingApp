# DatingApp
Files for dating application 
com.learnings.datingapp.DatingRecommendationApp.java
com.learnings.datingapp.AppConstants.java
com.learnings.datingapp.Match.java
com.learnings.datingapp.Ranks.java

com.learnings.datingapp.user.AgeComparator.java
com.learnings.datingapp.user.Gender.java
com.learnings.datingapp.user.MatchScoreComparator.java
com.learnings.datingapp.user.UserInfo.java


# File to be run
DatingRecommendationApp

# Inputs accepted to DatingRecommendationApp when run

1. Number of users in its database/cache
 Ex: 5
2. Users of the database in the format: <name>-<age>-<Male/Female>-<interests comma separated Cricket/Tennis/Badminton/Football>
  Ex: UserA-25-Female-Cricket,Tennis
      UserB-27-Male-Cricket,Football,Movies
      UserC-26-Male-C=Movies,Tennis,Football,Cricket
      UserD-24-Female-C=Tennis,Football,Badminton
      UserE-32-Female-C=Cricket,Football,Movies,Badminton

3. Name of the user for whom the match needs to be found
Ex: UserB
4. Number of users who closely match the above particular user
Ex: 2

# Return result
  Returns the users who are close match for the given user based on the following priority:
  1. Opposite Gender
  2. Age
  3. Interests which matched
  

# Alter nate way to running the application
Download the DatingApp.jar and run from command promt withjava in the path using the below command:
java -jar DatingApp.jar

#
