package tech.mccauley.androidhanadulses;

import java.util.ArrayList;
import java.util.HashMap;

public class LanguageManager {

    // declarations
    private static LanguageManager instance;
    final private String FAMILY = "family";
    final private String ANIMALS = "animals";
    final private String PLACES = "places";
    private HashMap<String, HashMap<String, String>> languageCategories;

    // constructor
    private LanguageManager() {
        languageCategories = new HashMap<>();
        setLanguageCategories();
    }

    // getinstance
    public static LanguageManager getInstance() {
        if (instance == null) {
            instance = new LanguageManager();
        }
        return instance;
    }

    // set words in category
    private void setLanguageCategories() {
        if (!languageCategories.containsKey(FAMILY)) {
            HashMap<String, String> familyWords = new HashMap<>();

            familyWords.put("grandfather", "할아버지");
            familyWords.put("grandmother", "할머니");
            familyWords.put("father", "아버지");
            familyWords.put("mother", "어머니");
            familyWords.put("brother", "형");
            familyWords.put("sister", "누나");

            languageCategories.put(FAMILY, familyWords);
        }
        if (!languageCategories.containsKey(ANIMALS)) {
            HashMap<String, String> animalsWords = new HashMap<>();

            animalsWords.put("dog", "강아지");
            animalsWords.put("cat", "고양이");
            animalsWords.put("chicken", "닭");
            animalsWords.put("pig", "돼지");
            animalsWords.put("bird", "새");
            animalsWords.put("turtle", "거북이");

            languageCategories.put(ANIMALS, animalsWords);
        }
        if (!languageCategories.containsKey(PLACES)) {
            HashMap<String, String> placesWords = new HashMap<>();

            placesWords.put("school", "학교");
            placesWords.put("library", "도서관");
            placesWords.put("park", "공원");
            placesWords.put("zoo", "동물원");
            placesWords.put("mart", "마트");
            placesWords.put("bank", "은행");

            languageCategories.put(PLACES, placesWords);
        }
    }

    // get category names
    protected ArrayList<String> getCategoryNames() {
        ArrayList<String> categoryNames = new ArrayList<>();

        categoryNames.addAll(languageCategories.keySet());

        return categoryNames;
    }

    // get category words
    protected HashMap getCategory(String category) {
        return languageCategories.get(category);
    }

    // check equality between languages
    protected boolean CheckAnswer(String category, String english, String korean) {
        if (getCategory(category).containsKey(english)) {
            if (getCategory(category).get(english).equals(korean)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
