/*
A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence
 between letters and digits, such that the given arithmetic equation consisting of 
 letters holds true when the letters are converted to digits.

You have an array of strings crypt, the cryptarithm, and an an array containing the
mapping of letters and digits, solution. The array crypt will contain three 
non-empty strings that follow the structure: [word1, word2, word3], which should 
be interpreted as the word1 + word2 = word3 cryptarithm.

If crypt, when it is decoded by replacing all of the letters in the cryptarithm 
with digits using the mapping in solution, becomes a valid arithmetic equation 
containing no numbers with leading zeroes, the answer is true. If it does not become
 a valid arithmetic solution, the answer is false.

EXAMPLE
crypt = ["SEND", "MORE", "MONEY"]

solution = [['O', '0'],
            ['M', '1'],
            ['Y', '2'],
            ['E', '5'],
            ['N', '6'],
            ['D', '7'],
            ['R', '8'],
            ['S', '9']]
*/

boolean isCryptSolution(String[] crypt, char[][] solution) {
        String[] values = new String[crypt.length];

        for (int i = 0; i < crypt.length; i++) {
            StringBuilder b = new StringBuilder();
            for (char c : crypt[i].toCharArray()) {
                for (int j = 0; j < solution.length; j++) {
                    if (c == solution[j][0]) {
                        b.append(solution[j][1]);
                    }
                }
            }
            values[i] = b.toString();
        }
        if (values[0].charAt(0) == '0' && values[0].length() > 1
                || values[1].charAt(0) == '0' && values[1].length() > 1
                || values[2].charAt(0) == '0' && values[2].length() > 1) {
            return false;
        } else if (Long.parseLong(values[0]) 
                + Long.parseLong(values[1]) == Long.parseLong(values[2])) {
            return true;
        }

        return false;
    }