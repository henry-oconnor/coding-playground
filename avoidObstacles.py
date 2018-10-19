# You are given an array of integers representing coordinates 
# of obstacles situated on a straight line.

# Assume that you are jumping from the point with coordinate 
# 0 to the right. You are allowed only to make jumps of the 
# same length represented by some integer.

# Find the minimal length of the jump enough to avoid all 
# the obstacles.

# EXAMPLE
# For inputArray = [5, 3, 6, 7, 9], the output should be
# avoidObstacles(inputArray) = 4.

def avoidObstacles(input):
    input = sorted(input)
    for i in range(2, input[-1]):
        for n in input:
            if n % i == 0:
                break
            if n == input[-1]:
                return i
    return input[-1] + 1