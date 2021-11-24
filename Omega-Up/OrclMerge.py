#!/usr/bin/python3

def _main():
    string1 = input()
    string2 = input()
    merged_string = input()
    if test_string(merged_string, string1, string2):
        print("VALID MERGE")
    else:
        print("INVALID MERGE")

def test_string(merged_string, string1, string2):
    if merged_string == "" and string1 == "" and string2 == "":
        return True
    if string1 != "" and string1[0] == merged_string[0]:
        a1 = test_string(merged_string[1:], string1[1:], string2)
    else:
        a1 = False
    if string2 != "" and string2[0] == merged_string[0]:
        a2 = False or test_string(merged_string[1:], string1, string2[1:])
    else:
        a2 = False
    return a1 or a2


if __name__ == '__main__':
  _main()
  