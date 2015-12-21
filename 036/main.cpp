#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    bool check(vector<char> list) {
        for (int i = 0;i < 9;i++)
            if (!((list[i] == '.') || (('1' <= list[i]) && ('9' >= list[i])))) return false;
        for (int i = 0;i < 9;i++)
            for (int j = i + 1;j < 9;j++)
                if ((list[i] != '.') && (list[i] == list[j])) return false;
        return true;
    }

public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<char> list;
        for (int i = 0;i < 9;i++) {
            if (!check(board[i])) return false;
        }
        for (int i = 0;i < 9;i++) {
            list.clear();
            for (int j = 0;j < 9;j++) list.push_back(board[j][i]);
            if (!check(list)) return false;
        }
        for (int i = 0;i < 3;i++)
            for (int j = 0;j < 3;j++) {
                list.clear();
                for (int k = 0;k < 3;k++)
                    list.insert(list.end(), board[i*3+k].begin()+j*3, board[i*3+k].begin()+j*3+3);
                if (!check(list)) return false;
            }
        return true;
    }
};

int main() {
    return 0;
}