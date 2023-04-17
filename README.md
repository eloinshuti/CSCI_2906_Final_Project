### Eloi Nshuti
### Southwest Technical College
### CSCI 2906 - Capstone Projects

## **Synopsis**
##### This is the final project for the Capstone Projects (CSCI 2906) class. The project contains code that provides a client and server window for input and output which are editable and non-editable respectively .

## **Motivation**
##### I built this program to help users write comprehensive resumes without compromising on what content to write. In this program the user can put additional information that may exceed the one page limitation. The viewer can also choose what to see which can be downloaded in pdf or text file format.

## **Code Example**
##### This is a code snippet of formulas used to open tabs or create them if they do not exist.
```
public static boolean tabExists(TabPane tabPane, Tab tabName) {
        for (Tab tab : tabPane.getTabs()) {
            if (tab.equals(tabName)) {
                return true;
            }
        }
        return false;
    }

    private void openTab(Tab tabName) {
       // check if a tab for this button already exists
    	if(tabExists(tabPane, tabName) == false) {
			  tabPane.getTabs().add(tabName);
			  tabPane.getSelectionModel().select(tabName);
    	}
    	else
    		tabPane.getSelectionModel().select(tabName);
    } 

```
## **Implementing**
##### To run the program, the user has to click the begin button, enter the informantion and press the submit button. When the submission is finished, the server will record the information in a text area. The text areas for diffirent sections can be navigated by clicking on the name.
![image](https://user-images.githubusercontent.com/112521045/232546038-90806867-3fd4-4766-9654-aaa1780a5664.png)
![image](https://user-images.githubusercontent.com/112521045/232545938-45215802-9cdc-4052-a5b4-0cff2768c5de.png)

## **Contributors**
##### Use this program using JUnit4.
