package com.learnings.datingapp.user;

import java.util.Comparator;

/**
 * A basic comparator to sort users by age
 */
public class AgeComparator implements Comparator<UserInfo> {

  @Override
  public int compare(UserInfo o1, UserInfo o2) {
    return o1.getAge() - o2.getAge();
  }
}
