package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
        query = query.toLowerCase();
        // query = "what is 12 plus 15"
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "Eros";
        } else if (query.contains("plus")){
            // here we get a list of words
            query = query.replace(",","");
            String[] words = query.split(" ");
            int sum = 0;
            for(String word : words){
                try {
                    int  number = Integer.parseInt(word);
                    sum += number;
                } catch(Exception e){
                    // ignore
                }
            }
            return String.valueOf(sum);
        } else if (query.contains("largest")){
            int max = -1;
            String[] words = query.split(" ");
            for (String word : words){
                try{
                    int number = Integer.parseInt(word);
                    max = number > max ? number : max;
                } catch(Exception e){
                    //
                }
            }
            return String.valueOf(max);
        }

            // Add a new comment here, please don't remove it please}
        return "";
        }
    }

