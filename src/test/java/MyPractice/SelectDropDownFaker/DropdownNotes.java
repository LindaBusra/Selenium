package MyPractice.SelectDropDownFaker;

public class DropdownNotes {

    /*

    Dropdown
    We can select from a dropdown with 3 different ways.
        1.Select and Print Option 1 using index using selectByIndex();
        2.Select and Print Option 2 by value using selectByValue();
        3.Select and Print default value by visible text using selectByVisibleText();

    We can also put all of the dropdown elements in a List<WebElement> using getOptions();

    Step 1: Locate the select element dropdown using any locator. Example:
        WebElement selectElement=driver.findElement(By.id(“value of id"));

    Step 2: Create Select object and pass the selectElement to that object.Example:
        Select options=new Select(selectElement);

    Step 3: We now can handle dropdown using any method. Example:
        options.selectByIndex(1);
        options.selectByValue(“1”);
        options.selectByVisibleText(“Watch”);
     */
}
