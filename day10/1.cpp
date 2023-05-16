#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <stack>
#include <vector>
#include <utility>

using namespace std;


class Main
{
public:
    Main()
    {
        stack<int> checkpoints = stack<int>({220, 180, 140, 100, 60, 20});
        auto program = read_program("../inputs/input10.txt");

        int cycles = 0;
        int signal_value = 1;
        int signal_strength = 0;

        for (auto instruction : program)
        {
            if(checkpoints.empty()) break;

            if(instruction.first == "addx")
            {
                cycles += 2;
                signal_value += instruction.second;
                
                if(cycles - checkpoints.top() >= 0) 
                {
                    cout << (signal_value-instruction.second) * (checkpoints.top()) << endl;
                    signal_strength += (signal_value-instruction.second) * (checkpoints.top());
                    checkpoints.pop();
                }
            }
            else
            {
                cycles++;
            }
        }

        cout << signal_strength << endl;
    }

    vector<pair<string, int>> read_program(string filename)
    {
        ifstream infile(filename);
        string line;

        vector<pair<string, int>> program;

        while (getline(infile, line))
        {
            istringstream iss(line);

            pair<string, int> instruction;
            string command;
            int arg;

            if (iss >> command >> arg) 
            { 
                instruction.first = command;
                instruction.second = arg;
            }
            else
            {
                instruction.first = command;
            }

            program.push_back(instruction);
        }

        return program;
    }
};


int main()
{
    Main m;
    return 0;
}