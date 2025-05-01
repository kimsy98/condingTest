import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedHashSet<String> cache = new LinkedHashSet<>();

        for (String city : cities) {
            city = city.toLowerCase();
            if (cacheSize == 0) {
                answer += 5;
                continue;
            }

            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer += 1;
            } else {
                if (cache.size() >= cacheSize) {
                    Iterator<String> it = cache.iterator();
                    it.next();
                    it.remove();
                }
                cache.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}
