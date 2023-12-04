// write template code

#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>

using namespace std;


vector<vector<int>> read_input(string filename)
{
    ifstream infile(filename);
    string line;

    vector<vector<int>> field;

    while (getline(infile, line))
    {
        vector<int> row;
        int num;

        for(char c : line)
        {
            int c_ = c - '0';
            row.push_back(c_);
        }

        field.push_back(row);
    }

    return field;
}

int count_visible(const vector<vector<bool>> &visible)
{
    int width  = visible[0].size();
    int height = visible.size();

    int visible_count = 2 * (width + height - 1);

    for (int i = 1; i < height - 1; i++)
    {
        for (int j = 1; j < width - 1; j++)
        {
            if(visible[i][j])
            {
                visible_count++;
            }
        }
    }

    return visible_count;
}

void scan_line(const vector<vector<int>> &field, vector<vector<bool>> &visible,
    int row, int col, int)
{
    int tallest = 0;
    for(int i = 0; i < field.size(); i++)
    {
        if(field[i][col] > tallest)
        {
            tallest = max(field[i][col], tallest);
        }
    }
}

int main()
{
    auto field = read_input("../inputs/input8.txt");

    int width = field[0].size();
    int height = field.size();

    vector<vector<bool>> visible(height, vector<bool>(width, false));

    int visible_count = count_visible(visible);

    cout << visible_count << endl;

    return 0;
}