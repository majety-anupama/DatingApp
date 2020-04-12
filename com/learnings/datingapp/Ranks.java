package com.learnings.datingapp;

/**
 * File to hold the ranks for the criteria: age and interest
 * 
 */
import java.util.HashMap;
import java.util.Map;

public class Ranks {
  public static String AGE = "age";
  public static String INTEREST= "interest";
  private static Map<String, Integer> WEIGHTS_MAP = new HashMap<>(16);

  static {
    WEIGHTS_MAP.put(AGE, -100); // Age is given negative value as we care about users with less age diff.
    WEIGHTS_MAP.put(INTEREST, 10);
  }

  public static int getRank(String criteria) {
    return WEIGHTS_MAP.get(criteria);
  }
}
