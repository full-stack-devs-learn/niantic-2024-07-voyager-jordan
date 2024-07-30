package com.nianatic;

public class ExerciseChallenge
{
    /*
     * Your companies website displays the name
     * of each of your employees. But the name
     * needs to be formatted with last name first.
     *
     * Examples:
     * Samuel Black             => Black, Samuel
     * Lori Bell, PhD           => Bell, Lori, PhD
     * Marcus Neuer III         => Neuer, Marcus, III
     * Miguel Bennett Jr., MBA  => Bennett, Miguel, Jr., MBA
     *
     * Your function will accept the full name of
     * an employee, and you must return the
     * appropriately formatted name.
     *
     * Input:
     * reformatName("Samuel Black")             => Black, Samuel
     * reformatName("Lori Bell, PhD")           => Bell, Lori, PhD
     * reformatName("Marcus Neuer III")         => Neuer, Marcus, III
     * reformatName("Miguel Bennett Jr., MBA")  => Bennett, Miguel, Jr., MBA
     *
     */
    public String reformatName(String fullName)
    {
        //Declared return value
        String result = "";
        //Split full name in to separate parts
        String[] nameSplit = fullName.split(" ");
        //These parts are standard and will not change based on input
        String firstName = nameSplit[0];
        //This handles if the input is only First and last and trims, else leaves it alone.
        String lastName = nameSplit[1].contains(",") ? nameSplit[1].substring(0, nameSplit[1].indexOf(",")) : nameSplit[1];
        //Auto Assigned to result
        result = lastName + " " + firstName;
        //Looped over remaining index that's why I started at 2 because I already processed up to index 1
        for (int i = 2; i < nameSplit.length; i++){
            //Trimmed suffix for more uniformed way of setting commas
            if(nameSplit[i].contains(",")){
                String trimmed = nameSplit[i].substring(0, nameSplit[i].indexOf(","));
                result += " " + trimmed;
                continue;
            }
            //Else added part to result
            result += " " + nameSplit[i];
        }
        //After formatted String with spaces replaces spaces accordingly with commas
        return result.replace(" ", ", ");
    }

    /*
     * JSON is yet another format that is used to
     * describe and transfer data. JSON stands for
     * JavaScript Object Notation
     *
     * There are no XML tags, but it is still self describing.
     *
     * It is more light-weight than XMl, and has become the
     * standard for transferring data over the web.
     *
     * { "id": 1, "name": "Belinda Carter"}
     *
     * The user will provide you a customer id and their name.
     * You are required to return a formatted JSON String
     * like the pattern shown above.
     *
     * createJSON(1, "Belinda Carter") => { "id": 1, "name": "Belinda Carter" }
     *
     */
    public String createJSON(int id, String name)
    {
        String json = "{ \"id\": %d, \"name\": \"%s\" }";
        return  String.format(json, id, name);
    }

}
