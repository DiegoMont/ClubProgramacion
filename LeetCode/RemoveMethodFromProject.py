class Solution:
    def remainingMethods(self, n: int, k: int, invocations: list[list[int]]) -> list[int]:
        self.methods = self.build_graph(n, invocations)
        self.mark_buggy_methods(k)
        self.find_dependencies()
        if self.can_remove_all_suspicious():
            remaining_methods = []
            for i in range(len(self.methods)):
                if self.methods[i].is_dependency:
                    remaining_methods.append(i)
            return remaining_methods
        else:
            return list(range(n))

    def build_graph(self, n, invocations):
        methods = [Method() for _ in range(n)]
        for invocation in invocations:
            caller = methods[invocation[0]]
            callee = methods[invocation[1]]
            caller.invocations.append(callee)
        return methods

    def mark_buggy_methods(self, k):
        to_visit = [self.methods[k]]
        while to_visit:
            caller = to_visit.pop()
            caller.is_buggy = True
            caller.visited = True
            for callee in caller.invocations:
                if not callee.visited:
                    to_visit.append(callee)

    def find_dependencies(self):
        for method in self.methods:
            if  not method.is_buggy:
                self.mark_dependencies_as_not_buggy(method)

    def mark_dependencies_as_not_buggy(self, method):
        to_visit = [method]
        while to_visit:
            caller = to_visit.pop()
            caller.is_dependency = True
            for callee in caller.invocations:
                if not callee.is_dependency:
                    to_visit.append(callee)

    def can_remove_all_suspicious(self):
        for method in self.methods:
            if method.is_buggy and method.is_dependency:
                return False
        return True

class Method:
    def __init__(self):
        self.visited = False
        self.is_buggy = False
        self.is_dependency = False
        self.invocations = []


if __name__ == "__main__":
    s = Solution()
    assert s.remainingMethods(4, 1, [[1,2],[0,1],[3,2]]) == [0, 1, 2, 3]
    assert s.remainingMethods(5, 0, [[1,2],[0,2],[0,1],[3,4]]) == [3, 4]
    assert not s.remainingMethods(3, 2, [[1,2],[0,1],[2,0]])
    assert s.remainingMethods(3, 2, [[1, 0], [2, 0]])
