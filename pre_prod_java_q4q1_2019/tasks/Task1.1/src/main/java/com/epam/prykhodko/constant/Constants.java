package com.epam.prykhodko.constant;

import static java.lang.System.lineSeparator;

public class Constants {

  public static final String REG_DOT = "\\.";
  public static final String REG_MATCH_EXTENSION = "(.*)\\.(.*)";
  public static final String STRING_ONE = "1";
  public static final String STRING_ZERO = "0";
  public static final String INCORRECT_INPUT = "Incorrect input. Try again!!!";
  public static final String FILE_NOT_FOUND_ERROR = "File with this name doesn't exists."
      + " Try again!!!";
  public static final String CHOOSE_NAME_FILTER_STRING = "Do you want search by name? 0/1";
  public static final String CHOOSE_EXTENSION_FILTER_STRING = "Do you want search"
      + " by extension? 0/1";
  public static final String CHOOSE_SIZE_FILTER_STRING = "Do you want search by size? 0/1";
  public static final String CHOOSE_DATE_FILTER_STRING = "Do you want search by date? 0/1";
  public static final String ENTER_DIRECTORY_NAME_STRING = "Enter directory name: ";
  public static final String ENTER_FILE_NAME_STRING = "Enter the file name: ";
  public static final String ENTER_EXTENSION_STRING = "Enter the file extension: ";
  public static final String ENTER_MIN_SIZE_STRING = "Enter the min size in kilobytes: ";
  public static final String ENTER_MAX_SIZE_STRING = "Enter the max size in kilobytes: ";
  public static final String ENTER_FIRST_DATE_STRING = "Enter the first date(dd/mm/yyyy hh:mm): ";
  public static final String ENTER_LAST_DATE_STRING = "Enter the last date(dd/mm/yyyy hh:mm): ";
  public static final String HEADER_CORRECT = "HTTP/1.1 200 OK" + lineSeparator() + "Content-Type: text/html" + lineSeparator() + lineSeparator();
  public static final String HEADER_ERROR = "HTTP/1.1 404" + lineSeparator() + "Content-Type: text/html" + lineSeparator();
  public static final String HEADER_ERROR_INCORRECT_ID = "HTTP/1.1 400" + lineSeparator() + "Content-Type: text/html" + lineSeparator();
  public static final String BAD_REQUEST = "BAD_REQUEST";
  public static final String CLIENT_ACCEPTED = "Client accepted";
  public static final String PAGE_NOT_FOUND = "Page not found";
  public static final String SERVER_STARTED = "Server started";
  public static final String THREAD_INTERRUPTED = "Thread was interrupted!!!";
  public static final String STOP_STRING = "stop";
  public static final String CANT_CONNECT_TO_THE_SERVER = "Can't connect to the server";

  private Constants() {

  }
}
