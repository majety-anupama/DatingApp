package com.learnings.datingapp;

import com.learnings.datingapp.user.AgeComparator;
import com.learnings.datingapp.user.Gender;
import com.learnings.datingapp.user.MatchScoreComparator;
import com.learnings.datingapp.user.UserInfo;

import java.util.*;

/**
 * Main class which accepts input for users, number of top recommendations through scanner and
 * prints recommendations on console. Internally it generates matching score for every user with every other
 * user based on age and interests.
 */
public class DatingRecommendationsApp {
  public static void main(String args[]) {

    Scanner scanner = new Scanner(System.in);
    // input would be in the format: UserA-25-Female-Cricket,Tennis
    // prompt for the user's in cache
    System.out.print("--------------Entering database of users------------\n\n");
    System.out.print("Enter total number of users in database: ");
    int totalUsers = scanner.nextInt();
    String[] users = new String[totalUsers];
    
    System.out.print(
            "\n Enter the details in the cache in the format <name>-<age>-<Male/Female>-<interests comma separatedCricket/Tennis/Badminton/Football>: \n ");
    for (int i = 0; i < totalUsers; i++) {
      users[i] = scanner.next();
    }
    
    // prompt for the user's name
    System.out.print("\nEnter the name of the user you want to get recommendations: ");
    // get their input as a String
    String userName = scanner.next();
    // prompt for their age
    System.out.print("\nEnter the number of top recommendations needed: ");
    int numberOfRecommendations = scanner.nextInt();
    System.out.println(String.format("%s, your name and level is %d ", userName, numberOfRecommendations));
    
    scanner.close();

    // Maintaining a list based on gender
    List<UserInfo> maleList = new LinkedList<>();
    List<UserInfo> femaleList = new LinkedList<>();
    for(String user: users) {
      parseAndPopulateUser(user, maleList, femaleList);
    }
    
    // Sort the gender based lists by age.
    Collections.sort(maleList, new AgeComparator());
    Collections.sort(femaleList, new AgeComparator());
    generateScores(maleList, femaleList);
    
    // Sort by best match score
    Collections.sort(maleList, new MatchScoreComparator());

    /*
    DEBUG: To see a snapshot of all males along with their Recommendations.
    System.out.println("Here are recommendations for all male users: ");
    System.out.println("=============================================");
    for(UserInfo male: maleList) {
      System.out.println("Male Name: "+male.getName());
      System.out.println("Recommendations in the decreasing order of match score: ");
      for(Match match: male.getMatches()) {
        System.out.println("Female Name: "+match.getUserInfo().getName() + " Match Score: " + match.getScore());
      }
      System.out.println("------------------------------");
    }
    */
    //Get all the users
    
    List<UserInfo> allUsers = new LinkedList<>(maleList);
    allUsers.addAll(femaleList);
    
    // Display the output 
    for(UserInfo user: allUsers) {
      if (user.getName().equalsIgnoreCase(userName)) {
        System.out.println("-------------Output: Here  are the recommendations for "+ userName + ": -----------------");
        int count = 0;
        for(Match match: user.getMatches()) {
          if(count == numberOfRecommendations) {
            break;
          }
          System.out.println(match.getUserInfo().getName());
          count++;
        }
        break;
      }
    }
  }

  /**
   * Add the users to respective list based on the gender
   * The input given which is hyphen separated needs to be parsed
   * @param user
   * @param maleList
   * @param femaleList
   */
  public static void parseAndPopulateUser(String user, List<UserInfo> maleList, List<UserInfo> femaleList) {
    String[] parts = user.split("-");
    if (AppConstants.MALE.equals(parts[2])) {
      maleList.add(new UserInfo(parts[0], Gender.MALE, Integer.parseInt(parts[1]), getInterests(parts[3])));
    } else {
      femaleList.add(new UserInfo(parts[0], Gender.MALE, Integer.parseInt(parts[1]), getInterests(parts[3])));
    }
  }

  /**
   * Convert the comma separated string of interests to a set
   * @param interests
   * @return
   */
  public static Set<String> getInterests(String interests) {
    Set<String> interestSet = new TreeSet<>();
    StringTokenizer tokenizer = new StringTokenizer(interests, ",");
    while(tokenizer.hasMoreTokens()) {
      interestSet.add(tokenizer.nextToken());
    }
    return interestSet;
  }

  /**
   * Identify the scores/weights based on the following:
   * 1. Different in age * Rank of age
   * 2. Find matching interests. and for each matching interests find weight by multiplying with Rank of interests
   * 3. Add the weights got from #1 and #2
   * 4. Continue this for each male and each female in the database
   * @param maleList
   * @param femaleList
   */
  public static void generateScores(List<UserInfo> maleList, List<UserInfo> femaleList) {
    int score;
    Set<String> commonInterests;
    Set<Match> matches;
    
    for(UserInfo male: maleList) {
      for(UserInfo female: femaleList) {
        // Generate score w.r.t age diff.
        score = Math.abs(male.getAge() - female.getAge()) * Ranks.getRank(Ranks.AGE);
        // Generate score w.r.t matching interests.
        commonInterests = new TreeSet<>(male.getInterests());
        commonInterests.retainAll(female.getInterests());
        score += commonInterests.size() * Ranks.getRank(Ranks.INTEREST);
        // Add match score for both male & female.
        matches = male.getMatches();
        matches.add(new Match(score, female));
        matches = female.getMatches();
        matches.add(new Match(score, male));
      }
    }
  }
}
