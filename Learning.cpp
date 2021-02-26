#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main()
{
    // Taking Input:
    string input;
    cout << endl;
    cout << setw(30) << "Enter a Palindrome: ";
    getline(cin, input);
    cout << endl;

    // transforming to lower case
    transform(input.begin(), input.end(), input.begin(), ::tolower);

    // checking that the sequence is palindromic or not
    int inputLenght = input.length();
    int match = 0;    // a check switch. 0 means same 1 means not same.
    for (int i = 0, j = (inputLenght - 1); i < inputLenght; i++, j--)
    {
        if (input[i] == input[j])
        {
            continue;
        }
        else
        {
            match = 1; // changing check switch to 1 which means not same.
            break;
        }
    }

    // printing the results based on check switch.
    cout << endl;
    if (match == 0)
    {
        cout << "          You entered a Palindrome..!" << endl;
    }
    else
    {
        cout << "          You entered a normal word !!!" << endl;
    }
    cout << endl << endl;

    // end..
    system("pause");
    return 0;
}
