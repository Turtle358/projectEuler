with open("22_names.txt", "r") as file:
    names = sorted([names[1:-1] for names in file.read().split(",")])

scoreList = [(sum(ord(letter) - 64 for letter in name)) * (i + 1) for i, name in enumerate(names)]

print(sum(scoreList))