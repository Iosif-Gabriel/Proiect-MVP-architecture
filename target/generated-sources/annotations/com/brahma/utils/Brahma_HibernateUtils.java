package com.brahma.utils;

import Model.Tables.Question;
import Model.Tables.User;
import java.lang.Class;

public final class Brahma_HibernateUtils {
  public static final Class[] entityAnnotatedClasses = new Class[] {
    Question.class,
    User.class,
  }
  ;
}
