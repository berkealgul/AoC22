#include <iostream>
#include <sstream>
#include <string>

using namespace std;

int main()
{
    string filepath = "../inputs/testcase.txt";

    string line;
    while (getline(filepath, line))
    {
        std::istringstream iss(line);
        int a, b;
        if (!(iss >> a >> b)) { break; } // error

        // process pair (a,b)
    }

    return 0;
}