class Solution:
    def intToRoman(self, num: int) -> str:
        result: str = self.get_thousands(num // 1000) + self.get_hundreds((num % 1000) // 100) + self.get_tens((num % 100) // 10) + self.get_units(num % 10)
        return result
    
    def get_thousands(self, abs_value: int) -> str:
        return self.get_roman_value(abs_value, "M", "", "");
    
    def get_hundreds(self, abs_value: int) -> str:
        return self.get_roman_value(abs_value, "C", "D", "M");

    def get_tens(self, abs_value: int) -> str:
        return self.get_roman_value(abs_value, "X", "L", "C");

    def get_units(self, abs_value: int) -> str:
        return self.get_roman_value(abs_value, "I", "V", "X");

    def get_roman_value(self, abs_value: int, unit_symbol: str, fifth_symbol: str, ten_symbol: str) -> str:
        if abs_value < 4:
            return self.get_ones(abs_value, unit_symbol)
        elif abs_value < 9 and abs_value > 4:
            return fifth_symbol + self.get_ones(abs_value - 5, unit_symbol)
        elif abs_value == 4:
            return unit_symbol + fifth_symbol
        elif abs_value == 9:
            return unit_symbol + ten_symbol
        else:
            return ""
        
    def get_ones(self, unit_to_add: int, unit_symbol: str) -> str:
        ones: str = "";
        for _ in range(unit_to_add):
            ones += unit_symbol
        return ones