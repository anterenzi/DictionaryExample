package DictionaryThesaurus;

import java.util.*;

/**
 * A WordInfo object is going to contain the definition of a word
 * and the set of synonyms of a word.
 * Thus, it's acting as both a dictionary and a thesaurus!
 */
public class WordInfo {
    
    //A string to hold the definition
    String definition;
    //Because of the commutive and transitive properties of synonyms,
    //a group of words can share the same "set" of synonyms.
    //A new set will be instantiated only when neither word in question
    //has any entries for a synonym. Otherwise, they will share a new set.
    //Yes, these sets will contain itself, but this can easily be
    //ignored when the data is iterated/printed.
    //Take for example, the words beautiful-gorgeous-lovely.
    //Let's say beautiful and gorgeous are added first, and then gorgeous
    //is made a synonym of beautiful. A new set is made with gorgeous and
    //beautiful. Then, lovely is made a synonym of beautiful. Since
    //beautiful will be also made a synonym of lovely, transitive will
    //make both a synonym of gorgeous, they can all be added to the same set.
    //If a fourth word is added, let's say pretty, it doesn't matter
    //if pretty becomes a synonym of beautiful or vice versa, the properties
    //ensure that they all become part of the same set, they just
    //need to exclude themselves.
    HashSet<String> synonyms;

    /**
     * Constructor method for a WordInfo object.
     * Note that synonym is not instantiated at all.
     * @param define, a string with the definition of a given word
     */
    public WordInfo(String define) {
        definition = define;
    }

    /**
     * Make the set of synonyms and a given word to it
     * @param word, the first word to go in the set of synonyms
     */
    public void makeSyn(String word) {
        synonyms = new HashSet<>();
        synonyms.add(word);
    }

    /**
     * Add a synonym to the set of synonyms
     * @param word, the word to be added to the set of synonyms
     */
    public void addSynonym(String word) {
        synonyms.add(word);
    }

    /**
     * Access method for definition
     * @return the definition held in this object
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Access method for synonyms
     * @return the set of synonyms held in this object
     */
    public HashSet<String> getSynonyms() {
        return synonyms;
    }
    
    /**
     * Set method for synonyms
     * @param other, the WordInfo to copy
     */
    public void setSynonym(WordInfo other)
    {
        synonyms = other.getSynonyms();
    }

    /**
     * Prints out the definition
     */
    public void printDefinition() {
        System.out.println(definition);
    }

    /**
     * Prints out the set of synonyms
     * @param word, the word that these synonyms come from.
     * It's used so that it can be skipped when iterating
     * through the set.
     */
    public void printSynonyms(String word) {
        System.out.print("Synonyms for " + word + ": { ");
        //For each entry in the set
        for (String syn : synonyms) {
            //Ignore the entry that equals itself!
            if (syn.equals(word)) {
                continue;
            }
            //Print out the synonym
            System.out.print(syn + " ");
        }
        System.out.println("}");
    }

    /**
     * Checks is the set of synonyms has been instantiated.
     * @return a boolean value representing if the set of synonyms is null
     */
    public boolean isSynEmpty() {
        return (synonyms == null);
    }
}
