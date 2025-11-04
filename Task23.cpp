//
// Created by luke on 04/11/2025.
//
#include <iostream>
#include <vector>
#include <numeric>
#include <cmath>
#include <algorithm>


using namespace std;
long long sumOfProperDivisors(int n) {
    if (n <= 1)
        return 0;
    long long sum = 1;
    int limit = static_cast<int>(sqrt(n));

    for (int i = 2; i <= limit; ++i) {
        if (n%i == 0) {
            sum += i;
            if (i*i != n) {
                sum+= n/i;
            }
        }
    }
    return sum;
}

bool isAbundant(int n) {
    return sumOfProperDivisors(n) > n;
}


int main() {
    const int LIMIT = 28123;
    vector<int> abundantNumbers;
    for (int i = 1; i <= LIMIT; ++i) {
        if (isAbundant(i))
            abundantNumbers.push_back(i);
    }

    vector<bool> isAbundantSum(LIMIT + 1, false);
    for (size_t i = 0; i < abundantNumbers.size(); ++i) {
        for (size_t j = i; j < abundantNumbers.size(); ++j) {
            int sum = abundantNumbers[i] + abundantNumbers[j];
            if (sum <= LIMIT) {
                isAbundantSum[sum] = true;
            } else {
                break;
            }
        }
    }

    long long totalSum = 0;
    for (int i = 1; i <= LIMIT; ++i) {
        if (!isAbundantSum[i]) {
            totalSum += i;
        }
    }

    cout << totalSum;
    return 0;
}
