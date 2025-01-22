#include <iostream>
using namespace std;

//this function displays an error msg if the high threshold is lower than the low threshold.

void error (int &highNum, int &lowNum) { //& modifies og values
    while (highNum < lowNum) { //i used a while loop so the msg repeats until number is put in correctly
        cout << "ERROR: High threshold must be greater than low threshold" << endl;
        cout << "Please try again: " << endl;
        cin >> highNum;
    }
}    

int main() {
    
    int lowThreshold, highThreshold;
    int thirdNum; //defining my variables
    
    cout << "Input one number with a low threshold: ";
    cin >> lowThreshold;
    
    cout << "Input one number with a high threshold: ";
    cin >> highThreshold;

    error(highThreshold, lowThreshold); //error msg function. I call it here so it can say error or sumns wrong
    
    cout << "Enter a number within the range " << lowThreshold << " & " << highThreshold << endl;
    cin >> thirdNum;

        //it only displays error if the third num isnt within range
        while (thirdNum < lowThreshold || thirdNum > highThreshold ){ //same thing but this is not a function. used a while loop so msg repeats till correct
            cout << "ERROR: Number must be within the range of " << lowThreshold << " & " << highThreshold << endl;
            cout << "Please try again: ";
            cin >> thirdNum;
        }

    cout << "SUCCESS! " << thirdNum << " is within range!" << endl; 
    

    return 0;
}
