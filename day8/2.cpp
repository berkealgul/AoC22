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

int count_visibles_of_line(const vector<vector<int>> &field, int x, int y, int dx, int dy, int w, int h)
{
    int x_ = x + dx;
    int y_ = y + dy;

    int visible_count = 0;
    int tree_height = field[y][x];

    while (x_ >= 0 && x_ < w && y_ >= 0 && y_ < h)
    {
        visible_count++;
        if (field[y_][x_] >= tree_height)
        {
            break;
        }

        x_ += dx;
        y_ += dy;
    }

    return visible_count;
}

int max_visibility_score(const vector<vector<int>> &field)
{
    int width  = field[0].size();
    int height = field.size();

    int max_score = 1;

    for (int i = 1; i < height - 1; i++)
    {
        for (int j = 1; j < width - 1; j++)
        {
            int score = 1;
            
            score *= count_visibles_of_line(field, j, i,  1,  0,  width, height);
            score *= count_visibles_of_line(field, j, i,  0,  1,  width, height);
            score *= count_visibles_of_line(field, j, i,  -1, 0,  width, height);
            score *= count_visibles_of_line(field, j, i,  0, -1,  width, height);

            max_score = max(max_score, score);
        }
    }

    return max_score;
}


int main()
{
    auto field = read_input("../inputs/input8.txt");

    int score = max_visibility_score(field);

    cout << score <<  endl;

    return 0;
}