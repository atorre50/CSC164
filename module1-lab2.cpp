#include <iostream>
using namespace std;

void error (int &highNum, int &lowNum) { //& modifies og values
    while (highNum < lowNum) {
        cout << "ERROR: High threshold must be greater than low threshold" << endl;
        cout << "Please try again: " << endl;
        cin >> highNum;
    }
}    

int main(){
    
    int lowThreshold, highThreshold;
    int thirdNum;
    
    cout << "Input one number with a low threshold: ";
    cin >> lowThreshold;
    
    cout << "Input one number with a high threshold: ";
    cin >> highThreshold;

    error(highThreshold, lowThreshold); //error msg function
    
    cout << "Enter a number within the range " << lowThreshold << " & " << highThreshold << endl;
    cin >> thirdNum;

        while (thirdNum < lowThreshold || thirdNum > highThreshold ){ 
            cout << "ERROR: Number must be within the range of " << lowThreshold << " & " << highThreshold << endl;
            cout << "Please try again: ";
            cin >> thirdNum;
        }

    cout << "SUCCESS! " << thirdNum << " is within range!" << endl; // edit: make this print
    

    return 0;
}
