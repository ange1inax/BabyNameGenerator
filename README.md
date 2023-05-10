# BabyNameGenerator
Baby Name Generator

Uses dataset from Department of Social Security that contains babynames

Main BabyName class will create a new txt file that will provide random baby names for those who can't decide on which name to choose

Sample Output

java BabyNames yob2020.csv M    //will write out 3 randomly selected male names from yob2020.csv to "potential_names.txt"

To safeguard against malicious input, the class IncompatibleExtensionException is used if the file entered as a command line argument does not end with ".csv". If this happens, tell the user your program only works with CSV files.
