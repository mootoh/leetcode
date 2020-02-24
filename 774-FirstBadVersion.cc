// Forward declaration of isBadVersion API.
bool isBadVersion(int version) {
    switch (version) {
        case 1:
        case 2:
        case 3:
             return false;
        case 4:
        default: return true;
    }
}

class Solution {
public:
    // n is the latest and broken version
    int firstBadVersion(int n) {
        int good = 1;
        int bad = n;
        while (good < bad) {
            int cur = (int)(((long long)good+(long long)bad)/2LL);
            if (isBadVersion(cur))
                bad = cur;
            else
                good = cur+1;
        }
        return good;
    }
};

#include <iostream>
using namespace std;
int main(int argc, char **argv) {
    cout << (new Solution())->firstBadVersion(5) << endl;
    cout << (new Solution())->firstBadVersion(4) << endl;
    return 0;
}