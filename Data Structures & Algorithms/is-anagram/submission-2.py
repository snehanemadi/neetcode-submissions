class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sdict={}
        tdict={}
        if len(s) == len(t):
            for i in range(0,len(s)):
                sdict[s[i]] = sdict.get(s[i],0) + 1
                tdict[t[i]] = tdict.get(t[i],0) + 1
            for i in range(0,len(s)):
                if sdict.get(s[i])!=tdict.get(s[i]):
                    return False
                
            return True
        return False