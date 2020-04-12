package com.learnings.datingapp.user;

import com.learnings.datingapp.Match;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class to hold user information
 */
public class UserInfo {
  private String userName;
  private Gender gender;
  private Integer age;
  private Set<String> interests;

  private boolean isAvailable = true;

  private Set<Match> matches = new TreeSet<>();

  public UserInfo(String userName, Gender gender, int age, Set<String> interests)
  {
    this.userName = userName;
    this.gender = gender;
    this.age = age;
    this.interests = interests;
  }

  public String getName()
  {
    return this.userName;
  }

  public Gender getGender()
  {
    return this.gender;
  }

  public int getAge()
  {
    return this.age;
  }

  public Set<String> getInterests()
  {
    return this.interests;
  }


  public Set<Match> getMatches() {
    return matches;
  }

  public void setMatches(Set<Match> matches) {
    this.matches = matches;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }
}