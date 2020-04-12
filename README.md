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

1. Number of users in its database/cache <p>
 Ex: 5
2. Users of the database in the format: <name>-<age>-<Male/Female>-<interests comma separated Cricket/Tennis/Badminton/Football> <p>
  Ex: UserA-25-Female-Cricket,Tennis
      UserB-27-Male-Cricket,Football,Movies
      UserC-26-Male-C=Movies,Tennis,Football,Cricket
      UserD-24-Female-C=Tennis,Football,Badminton
      UserE-32-Female-C=Cricket,Football,Movies,Badminton

3. Name of the user for whom the match needs to be found <p>
Ex: UserB
4. Number of users who closely match the above particular user <p>
Ex: 2

# Return result
  Returns the users who are close match for the given user based on the following priority: <p>
  1. Opposite Gender
  2. Age
  3. Interests which matched
  

# Alternate way to running the application
Download the DatingApp.jar and run from command promt withjava in the path using the below command:
java -jar DatingApp.jar

# Features available in the application

1. Ability to pick matches based on opposite gender
2. Ability to get match users with closest age first and then based on interest
3. Ability to get accept number of matches to be returned
4. If needed, the matches for all users can also be returned
5. Name is the user whose match to be found is case insensitive

# Features which can be extended in future
1. In case if a user is already matched with another user, then we can remove these users from the next searches
2. Ability to pick data from database. Schema file is included in the repository

