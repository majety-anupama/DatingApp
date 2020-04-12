package com.learnings.datingapp.user;

import com.learnings.datingapp.Match;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * A basic comparator to sort users by best match score.
 */
public class MatchScoreComparator implements Comparator<UserInfo> {

  @Override
  public int compare(UserInfo o1, UserInfo o2) {
    TreeSet<Match> matches1 = (TreeSet<Match>) o1.getMatches();
    TreeSet<Match> matches2 = (TreeSet<Match>) o2.getMatches();
    return matches2.first().getScore() - matches1.first().getScore();
  }
}
