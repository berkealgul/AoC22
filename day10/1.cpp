#include <iostream>
#include <fstream>
#include <sstream>
#include <string>

using namespace std;


class Main
{
public:
    Main()
    {
        read_input("../inputs/testcase.txt");
    }

    void read_input(string filename)
    {
        ifstream infile(filename);
        string line;

        while (getline(infile, line))
        {
            istringstream iss(line);

            string command;
            int arg;

            if (!(iss >> command >> arg)) 
            { 
                cout << "noop" << "lol"; 
            }
            else
            {
                cout << command << " " << arg << endl;
            }
        }
    }
};


int main()
{
    Main m;
    return 0;
}