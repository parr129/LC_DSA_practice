from collections import defaultdict, deque

class Solution:
    def findLadders(self, bw, ew, wl):
        s = set(wl)
        if ew not in s:
            return []
        
        p = defaultdict(list)
        q = deque([bw])
        v = set([bw])
        f = False
        
        while q and not f:
            n = set()
            for _ in range(len(q)):
                w = q.popleft()
                for i in range(len(w)):
                    for c in "abcdefghijklmnopqrstuvwxyz":
                        nw = w[:i] + c + w[i+1:]
                        if nw in s and nw not in v:
                            if nw == ew:
                                f = True
                            p[nw].append(w)
                            n.add(nw)
            v |= n
            q.extend(n)
        
        r = []
        
        def dfs(w, path):
            if w == bw:
                r.append(path[::-1])
                return
            for x in p[w]:
                dfs(x, path + [x])
        
        if f:
            dfs(ew, [ew])
        
        return r
