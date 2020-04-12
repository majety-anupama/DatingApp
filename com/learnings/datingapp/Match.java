package com.learnings.datingapp;

import com.learnings.datingapp.user.UserInfo;

/**
 * Class that represents a match for a given user. This holds match score and user with which match score is generated.
 */
public class Match implements Comparable{
  private int score;
  private UserInfo userInfo;

  public Match(int score, UserInfo user) {
    this.score = score;
    this.userInfo = user;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public UserInfo getUserInfo() {
    return userInfo;
  }

  public void setUserName(UserInfo user) {
    this.userInfo = user;
  }

  @Override
  public int compareTo(Object match) {
    return  ((Match)match).getScore() - this.getScore();
  }
}
